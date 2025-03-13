create database bankSystem;

use bankSystem;
create table signup
(form_no varchar(30),
name varchar (30),
father_name varchar(30),
DOB varchar(30),
gender varchar(30),
email varchar(30),
marital_status varchar(30),
address varchar(60),
city varchar(30),
pincode varchar(30),
state varchar(30));

select * from signup;

create table signuptwo
(form_no varchar(30),
religion varchar (30),
category varchar(30),
income varchar(30),
education varchar(30),
occupation varchar(30),
pan varchar(30),
aadhar varchar(60),
seniorcitizen varchar(30),
exitingaccount varchar(30));

select * from signuptwo;

create table signupthree(
form_no varchar(30),
account_Type varchar(40),
card_number varchar(30),
pin varchar(30),
facility varchar(200));

select * from signupthree;

create table login(
form_no varchar(30),
card_number varchar(30),
pin varchar(30));

select * from login;

create table bank(
pin varchar(10),
date varchar(20),
type varchar(20),
amount varchar (20));

select * from bank;
ALTER TABLE bank MODIFY COLUMN date DATETIME;

ALTER TABLE bank DROP COLUMN date;

ALTER TABLE bank ADD COLUMN status VARCHAR(10) DEFAULT 'active';

ALTER TABLE bank
DROP COLUMN status;








