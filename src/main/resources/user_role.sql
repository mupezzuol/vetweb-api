-- BCrypt
-- admin: $2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u
-- 1234: $2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK

INSERT INTO tbl_user(email, "name", password_user) VALUES('administrator@gmail.com', 'administrator', '$2a$10$DJr9REpKHS5SknDJxUwVPOXQ6SCI72qt5ki5vvYOa4ln3Hfrh67.u');
INSERT INTO tbl_user(email, "name", password_user) VALUES('owner@hotmail.com', 'owner', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK');
INSERT INTO tbl_user(email, "name", password_user) VALUES('assistant@gmail.com', 'assistant', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK');
INSERT INTO tbl_user(email, "name", password_user) VALUES('murillopezzuol@hotmail.com', 'mu', '$2a$10$Ui91L7As0DQzgHiYwTsmv.BrnF9iBY2N3qPpbf/vR6cDAXUPAlqOK');

INSERT INTO tbl_role("name") VALUES('ADMIN');
INSERT INTO tbl_role("name") VALUES('CLINIC_OWNER');
INSERT INTO tbl_role("name") VALUES('CLINIC_ASSISTANT');

INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(1,1);
INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(1,2);
INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(1,3);
INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(2,2);
INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(3,3);
INSERT INTO tbl_user_roles(tbl_user_id, roles_id) VALUES(4,1);