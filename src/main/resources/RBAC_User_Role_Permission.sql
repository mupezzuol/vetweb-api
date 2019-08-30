-- BCrypt
-- admin: $2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u
-- 1234: $2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK



-- Selects in order
select * from tbl_role;
select * from tbl_permission;
select * from tbl_role_permissions;
select * from tbl_user;
select * from tbl_user_roles;


-- Role
INSERT INTO public.tbl_role (role_id, "name") VALUES(1, 'ADMIN');
INSERT INTO public.tbl_role (role_id, "name") VALUES(2, 'CLINIC_OWNER');
INSERT INTO public.tbl_role (role_id, "name") VALUES(3, 'CLINIC_ASSISTANT');

	
-- Permission
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(1, 'user_create');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(2, 'user_read');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(3, 'user_update');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(4, 'user_delete');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(5, 'clinic_user_create');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(6, 'clinic_user_read');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(7, 'clinic_user_update');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(8, 'clinic_user_delete');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(9, 'clinic_animal_create');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(10, 'clinic_animal_read');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(11, 'clinic_animal_update');
INSERT INTO public.tbl_permission (permission_id, "name") VALUES(12, 'clinic_animal_delete');


-- Role + Permission
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 1);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 2);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 3);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 4);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 5);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 6);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 7);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(1, 8);

INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 6);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 9);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 10);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 11);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(2, 12);

INSERT INTO public.tbl_role_permissions (role_id, permission_id) VALUES(3, 10);
INSERT INTO public.tbl_role_permissions (role_id, permission_id) values(3, 11);


-- User
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid) 
VALUES(1, 'administrator@gmail.com', '2019-08-22', 'Murillo Pezzuol', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u', '85205603-3f7a-4b64-b1e2-b34e1774a52e');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(2, 'owner@hotmail.com', '2019-08-20', 'Elvis Pexuka', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 'de499c3b-12ca-432f-a849-960dd9d5889d');
INSERT INTO public.tbl_user (user_id, email, inclusion_date, "name", password_user, uuid)
VALUES(3, 'assistant@gmail.com', '2019-08-22', 'Teste Nome', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK', 'd91f4088-db3a-4346-a692-f3e4828aff2e');







