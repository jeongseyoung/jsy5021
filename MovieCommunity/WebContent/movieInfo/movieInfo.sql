create table movieInfo(
num number primary key,
title varchar2(20) not null,
director varchar2(20) not null,
release_date varchar2(20) not null,
video varchar2(2000),
content varchar2(100)
);


create sequence seq_moviInfo;