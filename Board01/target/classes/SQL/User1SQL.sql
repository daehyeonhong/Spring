CREATE TABLE users(
id VARCHAR2(20) PRIMARY KEY,
password VARCHAR2(20),
name VARCHAR2(20),
role VARCHAR2(20)
);
INSERT INTO users(id,password,name,role)VALUES('admin','1234','관리자','admin');
INSERT INTO users(id,password,name,role)VALUES('test','test1234','사용자','user');
SELECT*FROM users WHERE id='test' and password='test1234'