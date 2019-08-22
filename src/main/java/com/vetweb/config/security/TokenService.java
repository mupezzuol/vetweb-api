package com.vetweb.config.security;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.vetweb.entities.User;
import com.vetweb.services.IUserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenService {
	
	public static long EXPIRATION_TIME;//24h
	
	public static String SECRET;
	
	public static String TOKEN_PREFIX;
	
	public static String HEADER_STRING;
	
	private static IUserService userService;
	
	
	public static void addTokenToResponse(HttpServletResponse response, String userName) {
		String jsonWebToken = createToken(userName);//Token formatted for used
		response.addHeader(HEADER_STRING, jsonWebToken);
	}
	
	
	//Generate Token
	public static String createToken(String userEmail) {
		User userLogged = userService.findByEmail(userEmail);
		
		//Claims
		Map<String, Object> claims = new HashMap<>();
		claims.put("userEmail", userLogged.getEmail());
		claims.put("inclusionDate", userLogged.getInclusionDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		String[] roles = userLogged.getRoles().stream()
                .map(role -> role.getName())
                .toArray(String[]::new);
		
		String[] permissions = userLogged.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(permission -> permission.getName())
                .toArray(String[]::new);
		
		claims.put("roles", roles);
		claims.put("permissions", permissions);
		
		return TOKEN_PREFIX + " " + Jwts.builder()
				.setIssuer("Vetweb API - Welcome")
				.setSubject(userLogged.getUserId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.addClaims(claims)
				.signWith(SignatureAlgorithm.HS256, SECRET)//Encryption Algorithm
				.compact();//Token Generated
	}

	
	//Get Token
	public static Authentication getTokenFromRequest(HttpServletRequest request) {
		String jwt = request.getHeader(HEADER_STRING);
		
		if (jwt != null) {
			String userFromToken = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(jwt.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
			if (userFromToken != null) {
				return new UsernamePasswordAuthenticationToken(userFromToken, null, Collections.emptyList());//OK -> Yes Authenticated
			}
		}
		return null;//NOK -> No Authenticated
	}
	
	
	//Get User Token
	public Long getIdUser(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody();
		return Long.parseLong(claims.getSubject());
	}
	

	public static void setUserService(IUserService userService) {
		TokenService.userService = userService;
	}
	
	@Value("${vetweb.jwt.secret}")
	public void setSecret(String secret) {
		TokenService.SECRET = secret;
	}

	@Value("${vetweb.jwt.expiration}")
	public void setExpirationTime(long expirationTime) {
		TokenService.EXPIRATION_TIME = expirationTime;
	}

	@Value("${vetweb.jwt.prefix}")
	public void setTokenPrefix(String tokenPrefix) {
		TokenService.TOKEN_PREFIX = tokenPrefix;
	}

	@Value("${vetweb.jwt.header}")
	public void setHeaderString(String headerString) {
		TokenService.HEADER_STRING = headerString;
	}
	

}
