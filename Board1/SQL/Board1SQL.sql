CREATE TABLE board(
seq NUMBER PRIMARY KEY,
title VARCHAR2(30),
writer VARCHAR2(30),
content VARCHAR2(2000),
regDate DATE DEFAULT SYSDATE,
cnt NUMBER(3) DEFAULT 0
);
DESC BOARD;
SELECT*FROM BOARD;