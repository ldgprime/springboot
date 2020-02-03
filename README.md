# Springboot-MyBatis-MySQL

## 1. MySQL 세팅
```sql
create user 'spring'@'%' identified by 'bitc5600';

create database spring;


grant all privileges on spring.* to 'spring'@'%';


CREATE TABLE mem(
	id int  AUTO_INCREMENT PRIMARY KEY,     
	username varchar(20) UNIQUE not null, 
	password varchar(100) not null,
	email varchar(30),
    createtime timestamp
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;

```
