SET SQL_SAFE_UPDATES=0;
create database bankmanagementsystem;

show databases;

use bankmanagementsystem;
show tables;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital varchar(20), address varchar(40), city varchar(20),state varchar(20),pincode varchar(20));
select * from signup;
delete from signup where formno=0;

create table signuptwo(formno varchar(20),religion varchar(20), category varchar(20), income varchar(30), education varchar(30), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorCitizen varchar(20), exist varchar(20));
select * from signuptwo;
delete from signuptwo where formno=0;

 create table signupthree(formno varchar(20), accountType varchar(40), cardNumber varchar(25), pinNumber varchar(10), Facilities varchar(100));
select * from signupthree;

create table login(formno varchar(20),cardNumber varchar(25),pin varchar(10));
select * from login;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
select * from bank;
DROP table bank;