create schema st;
use st;

create table student(
	s_no char(9) primary key,
	s_name char(20) unique,
	s_sex char(2),
	s_age smallint,
	s_dept char(20)
);

create table course(
	c_no char(4) primary key,
	c_name char (40),
	c_pno char (4),
	c_credit smallint,
	foreign key course(c_pno) references course(c_no)
);

create table select_course(
	s_no char(9),
	c_no char(4),
	grade smallint,
	primary key(s_no,c_no),
	foreign key select_course(s_no) references student(s_no),
	foreign key select_course(c_no) references course(c_no)
);

alter table student add s_entrance date;

drop table student cascade;


create unique index s_no_index on student(s_no);
create index s_name_index on student(s_name);
drop index s_name_index on student;
create unique index s_dept_index on student(s_dept);