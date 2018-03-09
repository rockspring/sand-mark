create table t1
(
	column1 int
);

create table t2
(
	column1 int
);

insert into t1 select 1;
insert into t1 select 2;
insert into t1 select 3;
insert into t1 select 3;

insert into t2 select 1;
insert into t2 select 2;
insert into t2 select 3;
insert into t2 select 3;

select column1 from t1 where column1=(select max(column1) from t2);

--查询t1表中出现两次的列
select column1 from t1 as t where 2=(select count(*) from t1 where t1.column1=t.column1);

select * from t1 where column1 > any (select column1 from t2);
select * from t1 where column1 = any (select column1 from t2);
select * from t1 where column1 in (select column1 from t2);--in是= any的同义词