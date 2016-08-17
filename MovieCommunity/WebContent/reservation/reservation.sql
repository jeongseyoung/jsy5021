create table reservation(
num number not null,
movie varchar2(100) not null,
userid varchar2(100) not null,
theater varchar2(100) not null,
reservday varchar2(100) not null,
running varchar2(100) not null,
people varchar2(100) not null,
seat varchar2(100) not null,
pay varchar2(100) not null
);


create sequence seq_reserv
START WITH 20160001
INCREMENT BY 1
NOMAXVALUE;