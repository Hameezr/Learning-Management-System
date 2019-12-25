use assignment 
go

select * from attendance
select * from course
select * from degree
select * from marks
select * from section
select * from student
select * from teacher
select * from transcript

create table section
(
	[courseid] int,
	[secid] varchar(10),
	stid varchar(50),
	primary key ([courseid],stid)
)
go

create table transcript
(
	studentid varchar(50),
	courseid int,
	semesterno int,
	grade varchar(50)
)
go