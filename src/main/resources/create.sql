drop table if exists user;

CREATE table user(
id int(10) not null PRIMARY KEY,
name varchar(10) not null,
password varchar(10) not null);

insert into user values(1,"zhangsan","123");
insert into user values(2,"lisi","123");

drop table if exists role;

create table role(
id int(10) not null PRIMARY KEY,
role varchar(20) not null);

insert into role values(1,"admin");
insert into role values(2,"user");