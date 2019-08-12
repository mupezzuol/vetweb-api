package com.vetweb.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.vetweb.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${vetweb.jwt.secret}")
	private String secret;
	
	@Value("${vetweb.jwt.expiration}")
	private String expiration;//24h
	
	
	//Generate Token
	public String generateToken(Authentication authentication) {
		
		User userLogged = (User) authentication.getPrincipal();
		Date today = new Date();
		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("Vetweb API - Welcome")
				.setSubject(userLogged.getId().toString())
				.setIssuedAt(today)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)//Encryption Algorithm
				.compact();//Token Generated
	}

	
	//Valid Token
	public boolean isValidToken(String token) {

		try {
			Jwts.parser()
				.setSigningKey(this.secret)
				.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			System.out.println("Token is not valid: " + e.getMessage());
			return false;
		}
	}

	
	public Long getIdUser(String token) {
		
		Claims claims = Jwts.parser()
				.setSigningKey(this.secret)
				.parseClaimsJws(token)
				.getBody();
		
		return Long.parseLong(claims.getSubject());
	}

}
