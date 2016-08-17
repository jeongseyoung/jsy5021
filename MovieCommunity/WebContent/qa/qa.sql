create table qa(
num number not null,
writer varchar2(20),
pwd  varchar2(20),
title  varchar2(30),
qa_date date,
content  varchar2(100)
);

create sequence seq_qa;

create table qarep(
num number not null,
writer varchar2(20),
content varchar2(50),
rep_date date);