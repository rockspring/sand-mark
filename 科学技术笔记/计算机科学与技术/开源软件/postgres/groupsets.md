https://www.depesz.com/2015/05/24/waiting-for-9-5-support-grouping-sets-cube-and-rollup/

create table db_details (
    appnumber int4,
    day date,
    inserts int8,
    updates int8,
    deletes int8,
    transactions int8,
    primary key (appnumber, day)
);

create sequence x increment by 7;

insert into db_details
select
    i,
    j,
    nextval('x'),
    nextval('x'),
    nextval('x'),
    nextval('x')
from
    generate_series(1,3) i,
    generate_series(now() - '2 days'::interval, now(), '1 day'::interval) j;


drop sequence x;

select * from db_details;

select appnumber, sum(inserts), sum(updates), sum(deletes), sum(transactions)
from db_details
group by appnumber;

select day, sum(inserts), sum(updates), sum(deletes), sum(transactions)
from db_details
group by day;

select
    appnumber,
    day,
    sum(inserts),
    sum(updates),
    sum(deletes),
    sum(transactions)
FROM
    db_details
GROUP BY GROUPING SETS ( appnumber, day );


select
    appnumber,
    day,
    sum(inserts)
FROM
    db_details
GROUP BY GROUPING SETS ( (appnumber), (day), () );

create table test (
    d1 text,
    d2 text,
    d3 text,
    v int4,
    primary key (d1, d2, d3)
);

insert into test
select
    a, b, c,
    cast( random() * 50 as int4)
from
    (values ('a'),('b') ) as d1(a),
    (values ('c'),('d') ) as d2(b),
    (values ('e'),('f') ) as d3(c)
;

select
    d1, d2, d3,
    sum(v)
from
    test
group by grouping sets ( (d1), (d2, d3) );

explain analyze select
    d1, d2, d3,
    sum(v)
from
    test
group by cube( d1, d2, d3 );

select
    d1, d2, d3,
    sum(v)
from
    test
group by cube( (d1), (d2, d3) );


select
    d1, d2, d3,
    sum(v)
from
    test
group by ROLLUP( d1, d2, d3 );


select
    d1, d2, d3,
    sum(v)
from
    test
group by d1, cube(d2, d3);

select
    d1, d2, d3, GROUPING(d1, d2, d3), count(*)
FROM
    test
GROUP BY
    CUBE( (d1), (d2, d3) )
ORDER BY 4;

select
    d1, d2, d3, GROUPING(d1, d2, d3)::bit(3), count(*)
FROM
    test
GROUP BY
    CUBE( (d1), (d2, d3) )
ORDER BY 4;

select
    d1, d2, d3, GROUPING(d1, d2, d3)::bit(3), count(*)
FROM
    test
GROUP BY
    CUBE( (d1), (d2), (d3) )
ORDER BY 4;


https://www.depesz.com/2014/01/11/waiting-for-9-4-support-ordered-set-within-group-aggregates/

