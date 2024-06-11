use assignment;

create table user(
	email varchar(200) primary key,
    name varchar(200) not null,
    password varchar(200) not null
);
