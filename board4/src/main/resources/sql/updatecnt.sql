select * from board;
update board set cnt=0 where cnt is null;

create table board(
seq number primary key,
title varchar2(30),
writer varchar2(30),
content varchar2(2000),
regDate date default sysdate,
cnt number(3),
uploadFile varchar2(100)
);
select * from board;

/* 칼럼 추가*/
alter table board add (uploadFile varchar2(100));






