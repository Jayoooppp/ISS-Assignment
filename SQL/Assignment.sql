-- Creating Database
create database assignment;
use assignment;

-- Creating Tables
-- There are 4 tables in this examples 
-- 1. Customer
-- 2. SalesStaffCustomer
-- 3. SalesStaffInformation
-- 4. SalesOffice 

-- Customer Table
create table Customer(
	CustomerId int primary key auto_increment,
    CustomerName varchar(255) not null,
    CustomerCity varchar(255) not null,
    CustomerZipCode int default(00000)
);

-- SalesOffice
create table SalesOffice(
	SalesOfficeId int primary key,
    SalesOfficeLocation varchar(255) not null,
    OfficeNumber long not null,
    check(OfficeNumber > 999999999)
);

-- SalesStaffInformation
create table SalesStaffInformation(
	EmployeeId int primary key,
    EmployeeName varchar(255) not null,
    SalesOffice int,
    foreign key(SalesOffice) references SalesOffice(SalesOfficeId)
);

-- SalesStaffCustomer
create table SalesStaffCustomer(
	CustomerId int not null,
    EmployeeId int not null,
    foreign key(CustomerId) references Customer(CustomerId) on delete cascade,
    foreign key(EmployeeId) references SalesStaffInformation(EmployeeId) on delete cascade  
);


-- Creatring Index
create index idx_EmployeeToCustomer on SalesStaffCustomer(CustomerId,EmployeeId);


-- Inserting data into the tables 

-- Customers Table
insert into Customer(CustomerName,CustomerCity,CustomerZipCode)
values
("Sonam","Mumbai",403012),
("Virat","Indore",342281),
("Siraj","Nagpur",67521),
("Poonam","Ahmedabad",89831),
("Karina","Chennai",54219),
("Josh","Lucknow",87010),
("Dhruv","Jaipur",98553),
("Manav","Rajkot",69312);

insert into Customer(CustomerName,CustomerCity)
values 
("Raj","Agra"),
("Jesse","Delhi");

-- SalesOffice Table
insert into SalesOffice
values
(101,"New York",1234567892),
(102,"Sydeny",7893189843),
(103,"London",5789156739),
(104,"Delhi",9812897645),
(105,"France",6521890876);

-- SalesStaffInformation
insert into SalesStaffInformation
values
(01,"Sonam Singh",101),
(02,"Kanishk Trivedi",102),
(03,"Krish Bhatt",105),
(04,"Vivek Das",103),
(05,"Hiral Dixit",103),
(06,"Heena Gupta",102),
(07,"Riddhi Kulkarni",104),
(08,"Raj Doshi",101),
(09,"Manthan Mehta",104),
(010,"Sahil Pandey",105);


-- SalesStaffCustomer
insert into SalesStaffCustomer
values
(1,04),
(2,07),
(3,02),
(4,09),
(5,010),
(6,01),
(7,02),
(8,08),
(9,07),
(10,05);


-- Selecting data from Tables
select * from Customer;
select EmployeeId,SalesOffice from SalesStaffInformation;

-- Select Distinct
select count(*) as UniqueCities
from (select distinct CustomerCity from Customer) as result;  

-- Select TOP
select * from SalesStaffCustomer limit 5; 

-- Select along With
select * from SalesStaffInformation where SalesOffice = 102 or EmployeeId = 04; 

select * from SalesStaffCustomer where (EmployeeId = 05 or EmployeeId = 07) and CustomerId = 9;

-- Update Table
update Customer
set CustomerZipCode = 87310
where CustomerId = 2;

-- Delete from table
delete from SalesStaffInformation where EmployeeId = 3;

-- Like Clause 
select * from Customer 
where CustomerName like "S%"; -- names starting with "s"

select * from Customer 
where CustomerName like "%l"; -- names ending with "l"

select * from Customer
where CustomerName like "_a%"; -- names with a in 2nd place


-- IN Clause 

select * from SalesStaffInformation 
where SalesOffice in (102,104,107);

-- Between Clause 
select * from Customer
where CustomerZipCode between 60000 and 90000;

-- Alias 
select EmployeeId , EmployeeName 
from SalesStaffInformation as EmployeeInfo;

-- JOINS 

-- INNER Join
-- Finding which customer is managed by which employee
select Customer.CustomerId , Customer.CustomerName , SalesStaffCustomer.EmployeeId 
from Customer inner join SalesStaffCustomer on Customer.CustomerId = SalesStaffCustomer.CustomerId; 

-- LEFT Join
-- Finding which out the working location of each employee
select SalesStaffInformation.EmployeeId,SalesStaffInformation.EmployeeName,SalesOffice.SalesOfficeLocation from 
SalesStaffInformation left join SalesOffice 
on SalesStaffInformation.SalesOffice = SalesOffice.SalesOfficeId;

-- RIGHT Join 
-- Finding customers managed by each employee
select SalesStaffCustomer.customerId ,  SalesStaffInformation.EmployeeId,SalesStaffInformation.EmployeeName from 
SalesStaffCustomer right join SalesStaffInformation
on SalesStaffCustomer.EmployeeId = SalesStaffInformation.EmployeeId;

-- CROSS Join (Full Join)
select Customer.CustomerId , Customer.CustomerName , SalesStaffCustomer.EmployeeId 
from Customer cross join SalesStaffCustomer where Customer.CustomerId = SalesStaffCustomer.CustomerId; 



-- Group by
-- Finding City wise Customer Count 
select count(CustomerCity) , CustomerCity from Customer 
group by CustomerCity;

-- Finding City wise Customer Count in Ascending Order
select count(CustomerCity) , CustomerCity from Customer 
group by CustomerCity
order by count(CustomerCity);

-- Finding total customers managed by each employee	
select SalesStaffInformation.EmployeeName , count(SalesStaffCustomer.CustomerId) as TotalCustomers
from SalesStaffCustomer left join SalesStaffInformation 
on SalesStaffCustomer.EmployeeId = SalesStaffInformation.EmployeeId
group by SalesStaffInformation.EmployeeId;

-- Having clause
-- Finding City wise customer count having customers greater than 1
select count(CustomerCity) , CustomerCity from Customer 
group by CustomerCity
having count(CustomerCity) > 1
order by count(CustomerCity);

-- Creating View
create view MumbaiCustomers as 
select * from Customer
where CustomerCity = "Mumbai";
select * from MumbaiCustomers;
	
-- IFNULL 
-- If No Cutomer is managed by Employee Set CustomerId as -1
select ifnull(SalesStaffCustomer.customerId , -1) as CustomerId,  SalesStaffInformation.EmployeeId,SalesStaffInformation.EmployeeName from 
SalesStaffCustomer right join SalesStaffInformation
on SalesStaffCustomer.EmployeeId = SalesStaffInformation.EmployeeId;


-- select into 
-- creating backup of Customer Table

create table CustomerBackup select * from Customer;
select * from CustomerBackup;

-- SQL Injection Exmple 
-- It will return all the Rows in the table 
select * from SalesStaffInformation where SalesOffice = 102 or ""="";

-- Alter and Drop
alter table Customer
add column CustomerContact int default(0);
select * from Customer;

alter table Customer
drop column CustomerContact;
select * from Customer;

drop table Customer;