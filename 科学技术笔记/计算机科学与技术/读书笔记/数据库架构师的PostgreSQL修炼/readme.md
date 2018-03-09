```
select
    c.relname,
    count(*) as buffers
from
    pg_class c
join
    pg_buffercache b
on b.relfilenode = c.relfilenode
inner join
    pg_database d
on (b.reldatabase = d.oid AND d.datname = current_database())
group by c.relname
order by 2 desc;


select * from pg_class limit 1;

select * from pg_buffercache limit 1;

select * from pg_database limit 1;


// 限制非pg自身的表
select
    c.relname,
    count(*) as buffers
from
    pg_class c
join
    pg_buffercache b
on b.relfilenode = c.relfilenode
inner join
    pg_database d
on (b.reldatabase = d.oid AND d.datname = current_database())
where c.relname not like 'pg%'
group by c.relname
order by 2 desc;
```

```
create table emp(id serial, first_name varchar(50));
insert into emp(first_name) values('Jayadeva');
select * from emp;


select
    c.relname,
    b.isdirty
from
    pg_class c
join
    pg_buffercache b
on b.relfilenode = c.relfilenode
inner join
    pg_database d
on (b.reldatabase = d.oid AND d.datname = current_database())
where c.relname like '%emp%';
```

强制设置一个检查点

```
checkpoint;
```

更新表
```
update emp set first_name = 'Newname';
```


## 2.3 检查点

```
select pg_relation_filepath('emp');
```


```
insert into emp(id, first_name) select generate_series(1, 5000000), 'A longer name';
```

## 2.7 日志进程


```
create or replace function audit_tbl()
returns trigger as
$body$
declare
    aud_data text;
begin
    aud_data = new.first_name;
    raise log 'Audit data : %', aud_data;
    return new;
end;$body$
language plpgsql;

create trigger emp_trg
    before insert
    on emp
for each row
    execute procedure audit_tbl();

insert into emp(first_name) values('Scott');
```

## 2.8 统计信息收集器进程

```
select relname, n_tup_ins from pg_stat_user_tables;

select pg_stat_reset();

insert into emp(first_name) values('周乐钦');

```

## 2.10 使用work_mem在内存中进行排序

```
create table myt(id serial);

insert into myt select generate_series(1, 1000000);

set work_mem = '64kB';
select temp_files, temp_bytes from pg_stat_database where datname = 'postgres';

select * from (select * from myt order by id) t limit 1000;

show work_mem;

set work_mem to '1MB';

```