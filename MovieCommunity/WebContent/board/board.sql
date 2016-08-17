create table board(
num number not null,
writer varchar2(20),
pwd  varchar2(20),
title  varchar2(30),
board_date date,
content  varchar2(100)
);

create sequence seq_board;