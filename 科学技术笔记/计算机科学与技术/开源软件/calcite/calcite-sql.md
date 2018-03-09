```
0: jdbc:calcite:model=target/test-classes/mod> values(1);
+------------+
|   EXPR$0   |
+------------+
| 1          |
+------------+
1 row selected (0.037 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> with a(n) as (values(1)) select * from a;
+------------+
|     N      |
+------------+
| 1          |
+------------+
1 row selected (0.025 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> with a(n) as (values(1)), b(n) as (values(2)) select * from a cross join b;
+------------+------------+
|     N      |     N0     |
+------------+------------+
| 1          | 2          |
+------------+------------+
1 row selected (0.077 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> select 1;
+------------+
|   EXPR$0   |
+------------+
| 1          |
+------------+
1 row selected (0.001 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> select 1 union all select 2;
+------------+
|   EXPR$0   |
+------------+
| 1          |
| 2          |
+------------+
2 rows selected (0.034 seconds)
```

## tableExpression

```
0: jdbc:calcite:model=target/test-classes/mod> select * from LATERAL (values('[1,2]',2));
+--------+------------+
| EXPR$0 |   EXPR$1   |
+--------+------------+
| [1,2]  | 2          |
+--------+------------+
1 row selected (0.025 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> select * from LATERAL (values(array[1,2],2)) as alias (array_field0,b);
+--------------+------------+
| ARRAY_FIELD0 |     B      |
+--------------+------------+
| [1, 2]       | 2          |
+--------------+------------+
1 row selected (0.013 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> select * from unnest(array[2,1]) WITH ORDINALITY;
+------------+------------+
|   EXPR$0   | ORDINALITY |
+------------+------------+
| 2          | 1          |
| 1          | 2          |
+------------+------------+
2 rows selected (0.021 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> values array[2,1,2],array[2,1,2];
+--------+
| EXPR$0 |
+--------+
| [2, 1, 2] |
| [2, 1, 2] |
+--------+
2 rows selected (0.014 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 100        | Fred | 10         |        |      | 30         | 25         | true    | false   | 1996-08-03 |
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
| 120        | Wilma | 20         | F      |      | 1          | 5          |         | true    | 2005-09-07 |
| 130        | Alice | 40         | F      | Vancouver | 2          | null       | false   | true    | 2007-01-01 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
5 rows selected (0.011 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps LIMIT 1;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 100        | Fred | 10         |        |      | 30         | 25         | true    | false   | 1996-08-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
1 row selected (0.018 seconds)
```

```
[ LIMIT { count | ALL } ]
[ OFFSET start { ROW | ROWS } ]
[ FETCH { FIRST | NEXT } [ count ] { ROW | ROWS } ]
```

大写的是关键字，小写的是变量

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps LIMIT 1 OFFSET 1;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
1 row selected (0.015 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROW FETCH FIRST 2 ROW ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.118 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROWS FETCH FIRST 2 ROW ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.118 seconds)
```


```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROWS FETCH FIRST 2 ROWS ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.013 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROWS FETCH NEXT 2 ROWS ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.019 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROWS FETCH FIRST 2 ROW ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.015 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps OFFSET 1 ROWS FETCH NEXT 2 ROW ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.012 seconds)
```

LIMIT语句被FETCH语句覆盖了。
```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps LIMIT 1 OFFSET 1 ROW FETCH NEXT 2 ROW ONLY;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
2 rows selected (0.014 seconds)
```

```
[ ORDER BY orderItem [, orderItem ]* ]

orderItem:
      expression [ ASC | DESC ] [ NULLS FIRST | NULLS LAST ]
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps ORDER BY age DESC;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
| 130        | Alice | 40         | F      | Vancouver | 2          | null       | false   | true    | 2007-01-01 |
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 100        | Fred | 10         |        |      | 30         | 25         | true    | false   | 1996-08-03 |
| 120        | Wilma | 20         | F      |      | 1          | 5          |         | true    | 2005-09-07 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
5 rows selected (0.037 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps ORDER BY age DESC NULLS FIRST;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
| 130        | Alice | 40         | F      | Vancouver | 2          | null       | false   | true    | 2007-01-01 |
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 100        | Fred | 10         |        |      | 30         | 25         | true    | false   | 1996-08-03 |
| 120        | Wilma | 20         | F      |      | 1          | 5          |         | true    | 2005-09-07 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
5 rows selected (0.016 seconds)
```

```
0: jdbc:calcite:model=target/test-classes/mod> SELECT * FROM emps ORDER BY age + age DESC NULLS FIRST;
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
|   EMPNO    | NAME |   DEPTNO   | GENDER | CITY |   EMPID    |    AGE     | SLACKER | MANAGER | JOINEDAT |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
| 110        | John | 40         | M      | Vancouver | 2          | null       | false   | true    | 2002-05-03 |
| 130        | Alice | 40         | F      | Vancouver | 2          | null       | false   | true    | 2007-01-01 |
| 110        | Eric | 20         | M      | San Francisco | 3          | 80         |         | false   | 2001-01-01 |
| 100        | Fred | 10         |        |      | 30         | 25         | true    | false   | 1996-08-03 |
| 120        | Wilma | 20         | F      |      | 1          | 5          |         | true    | 2005-09-07 |
+------------+------+------------+--------+------+------------+------------+---------+---------+----------+
5 rows selected (0.08 seconds)
```
