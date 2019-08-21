-- BCrypt
-- admin: $2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u
-- 1234: $2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK


-- Select'
select * from tbl_clinic;
select * from tbl_profile;
select * from tbl_user;
select * from tbl_user_profile;


-- Insert's
INSERT INTO tbl_user(email, inclusion_date, "name", password_user) VALUES('administrator@gmail.com', '2019-05-05', 'administrator', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u');
INSERT INTO tbl_user(email, inclusion_date, "name", password_user) VALUES('owner@hotmail.com', '2019-08-08', 'owner', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK');
INSERT INTO tbl_user(email, inclusion_date, "name", password_user) VALUES('assistant@gmail.com', '2019-09-09', 'assistant', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK');


INSERT INTO tbl_profile("role") VALUES('ADMIN');
INSERT INTO tbl_profile("role") VALUES('CLINIC_OWNER');
INSERT INTO tbl_profile("role") VALUES('CLINIC_ASSISTANT');

INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(1,1);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(1,2);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(1,3);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(2,2);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(3,3);

-- Insert Clinic + User + Profile + Role
INSERT INTO public.tbl_clinic (id, cnpj, "owner", razao_social) VALUES(1, '75908592000143', 'Murillo Pezzuol', 'Razao Social LTDA');
INSERT INTO public.tbl_user (id, email, inclusion_date, "name", password_user, fk_clinic) VALUES(4, 'murillopezzuol@hotmail.com', '2019-05-05', 'mu', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 1);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(4,1);
INSERT INTO tbl_user_profiles(users_id, profiles_id) VALUES(4,2);



-- Consulta do JPA/Hibernate no Spring (Autenticação com JWT)

-- 1ª -> Consulta o usuário
    select
        user0_.id as id1_2_,
        user0_.fk_clinic as fk_clini5_2_,
        user0_.email as email2_2_,
        user0_.name as name3_2_,
        user0_.password_user as password4_2_ 
    from
        tbl_user user0_ 
    where
        user0_.email = 'murillopezzuol@hotmail.com'

-- 2ª -> Consulta os perfis desse usuário
    select
        profiles0_.users_id as users_id1_3_0_,
        profiles0_.profiles_id as profiles2_3_0_,
        profile1_.id as id1_1_1_,
        profile1_.role as role2_1_1_ 
    from
        tbl_user_profiles profiles0_ 
    inner join
        tbl_profile profile1_ 
            on profiles0_.profiles_id=profile1_.id 
    where
        profiles0_.users_id=4
        
        