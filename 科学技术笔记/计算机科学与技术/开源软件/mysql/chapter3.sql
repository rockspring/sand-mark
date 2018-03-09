create table t
(
	a char(5)
)engine=innodb;
insert into t select 'a';
insert into t select NULL;
insert into t select 'b';
insert into t select 'c';
insert into t select NULL;