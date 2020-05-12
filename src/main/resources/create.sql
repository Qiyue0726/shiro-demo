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

drop table if exists user_role;
create table user_role(
uid int(10) not null,
rid int(10) not null);
 insert into user_role values(1,1);
 insert into user_role values(2,2);


 drop table if exists permission;
 create table permission(
 id int(10) not null primary key,
 perms varchar(30) default null);

 insert into permission values(1,"user:update");
 insert into permission values(2,"user:add");

 drop table if exists user_perms;
 create table user_perms(
 uid int(10) not null,
 mid int(10) not null);

 insert into user_perms values(2,1);
 insert into user_perms values(2,2);