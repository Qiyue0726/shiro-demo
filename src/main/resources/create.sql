drop table user;


CREATE table user(
id int(10) not null PRIMARY KEY,
name varchar(10) not null,
password varchar(10) not null);

insert into user values(1,"zhangsan","123");
insert into user values(2,"lisi","123");