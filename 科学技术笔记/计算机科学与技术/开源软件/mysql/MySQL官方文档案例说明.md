# https://dev.mysql.com/doc/refman/5.7/en/ 文档案例

在MySQL交互式客户端如何查看文档如下所示。这里的文档比网站上的简短。

```
mysql> help contents
You asked for help about help category: "Contents"
For more information, type 'help <item>', where <item> is one of the following
categories:
   Account Management
   Administration
   Compound Statements
   Data Definition
   Data Manipulation
   Data Types
   Functions
   Functions and Modifiers for Use with GROUP BY
   Geographic Features
   Help Metadata
   Language Structure
   Plugins
   Procedures
   Storage Engines
   Table Maintenance
   Transactions
   User-Defined Functions
   Utility


mysql> help Data Manipulation
You asked for help about help category: "Data Manipulation"
For more information, type 'help <item>', where <item> is one of the following
topics:
   CALL
   DELETE
   DO
   DUAL
   HANDLER
   INSERT
   INSERT DELAYED
   INSERT SELECT
   JOIN
   LOAD DATA
   LOAD XML
   REPLACE
   SELECT
   UNION
   UPDATE

```

## https://dev.mysql.com/doc/refman/5.7/en/create-database.html

MySQL系统自身的数据的字符编码及对齐

```
# cat db.opt 
default-character-set=latin1
default-collation=latin1_swedish_ci
```

创建新的数据库使用如下字符编码和对齐

```
# cat db.opt 
default-character-set=utf8
default-collation=utf8_general_ci
```

```
CREATE DATABASE IF NOT EXISTS test
    DEFAULT CHARACTER SET = utf8
    DEFAULT COLLATE = utf8_general_ci;

CREATE DATABASE IF NOT EXISTS test
    CHARACTER SET = utf8
    COLLATE = utf8_general_ci;

CREATE DATABASE test
    CHARACTER SET = utf8
    COLLATE = utf8_general_ci;

CREATE SCHEMA IF NOT EXISTS test
    DEFAULT CHARACTER SET = utf8
    DEFAULT COLLATE = utf8_general_ci;
```

## 13.1.18 https://dev.mysql.com/doc/refman/5.7/en/create-table.html


### 1 Table Name

### 2 Temporary Tables

创建的表仅仅在会话期间可见，会话结束后就被删除掉。

### 3 Cloning or Copying a Table

```
CREATE TABLE t (c CHAR(20) CHARACTER SET utf8 COLLATE utf8_bin);

INSERT INTO t VALUES('aaa');
INSERT INTO t VALUES('bbb');

CREATE TABLE t_copy LIKE t;

CREATE TABLE t_as_query (c CHAR(20) CHARACTER SET utf8 COLLATE utf8_bin) AS SELECT 'abc';

CREATE TABLE t_as_query1 AS SELECT * from t;
```

### 4 Column Data Types and Attributes

#### 4.1 data_type

基本数据类型 https://dev.mysql.com/doc/refman/5.7/en/data-types.html

空间数据类型 https://dev.mysql.com/doc/refman/5.7/en/spatial-types.html

JSON数据类型 https://dev.mysql.com/doc/refman/5.7/en/json.html

AUTO_INCREMENT仅仅适用于整形和浮点型数据类型

DEFAULT不适用于BLOB, TEXT, GEOMETRY, 和 JSON数据类型

CHARACTER SET 和 COLLATE仅仅适用于CHAR, VARCHAR, TEXT

MySQL 5.7用对字符类型的长度解释为字符数，对BINARY 和 VARBINARY类型的长度解释为字节数。

CHAR, VARCHAR, BINARY, and VARBINARY类型可以仅仅使用前缀部分创建索引。BLOB and TEXT只能使用前缀部分创建索引。

```
CREATE TABLE test_blob (blob_col BLOB, INDEX(blob_col(10)));
```

JSON不能建索引。

#### 4.2 NOT NULL | NULL

列默认可以为NULL。

#### 4.3 DEFAULT

除了TIMESTAMP或DATETIME类型，其他类型的字段的默认值必须为常量，不能是一个函数或表达式。

TIMESTAMP或DATETIME类型的字段默认值可以是CURRENT_TIMESTAMP。

BLOB, TEXT,和 JSON不能设置默认值。

如果指定了SQL模式NO_ZERO_DATE和NO_ZERO_IN_DATE并且启用了严格SQL模式，c1 DATE DEFAULT '2010-00-00'产生错误。

如果指定了SQL模式NO_ZERO_DATE和NO_ZERO_IN_DATE并且未启用了严格SQL模式，c1 DATE DEFAULT '2010-00-00'产生警告。

#### 4.4 AUTO_INCREMENT

仅仅适用于整形和浮点型数据类型。


```
CREATE TEMPORARY TABLE IF NOT EXISTS test.test_table_autoincrement
(
	a INT UNSIGNED ZEROFILL
	AUTO_INCREMENT UNIQUE KEY PRIMARY KEY
)

INSERT INTO test.test_table_autoincrement VALUES(1);
INSERT INTO test.test_table_autoincrement VALUES(0);
INSERT INTO test.test_table_autoincrement VALUES(NULL);

mysql> select * from test.test_table_autoincrement;
+------------+
| a          |
+------------+
| 0000000001 |
| 0000000002 |
| 0000000003 |
+------------+
3 rows in set (0.00 sec)

mysql> SELECT LAST_INSERT_ID();
+------------------+
| LAST_INSERT_ID() |
+------------------+
|                3 |
+------------------+
1 row in set (0.00 sec)
```

如果启用了NO_AUTO_VALUE_ON_ZERO这种SQL模式，插入值为0时不会自增，就是插入0这个值。

```
set sql_mode='NO_AUTO_VALUE_ON_ZERO';

INSERT INTO test.test_table_autoincrement VALUES(0);

mysql> select * from test.test_table_autoincrement;
+------------+
| a          |
+------------+
| 0000000000 |
| 0000000001 |
| 0000000002 |
| 0000000003 |
+------------+
4 rows in set (0.00 sec)
```

每个表只能有一个AUTO_INCREMENT列，必须有索引，不能有默认值，不能为负数。

```
SELECT * FROM test.test_table_autoincrement WHERE a IS NULL;
```

#### 4.5 COMMENT

```
CREATE TEMPORARY TABLE IF NOT EXISTS test.test_table_comment
(
  a INT UNSIGNED ZEROFILL
  AUTO_INCREMENT UNIQUE KEY PRIMARY KEY
  COMMENT '字段a的注解，最多1024个字符'
)

SHOW CREATE TABLE test.test_table_comment\G;

SHOW FULL COLUMNS FROM test.test_table_comment;
SHOW FULL COLUMNS IN test.test_table_comment;
```

```
mysqlshow -uroot -padmin test t
```

#### 4.6 COLUMN_FORMAT

仅仅对NDB集群的NDB引擎有用。

#### 4.7 STORAGE

仅仅对NDB集群的NDB引擎有用。必须指定表空间。

```
CREATE TABLESPACE `ts_1` ADD DATAFILE 'ts_1.ibd' Engine=NDB;

CREATE TABLE t1_ndb (
     c1 INT STORAGE DISK,
     c2 INT STORAGE MEMORY
) TABLESPACE ts_1 ENGINE NDB;
```

#### 4.8 GENERATED ALWAYS

支持生成字段列。

```
CREATE TABLE triangle (
  sidea DOUBLE,
  sideb DOUBLE,
  sidec DOUBLE AS (SQRT(sidea * sidea + sideb * sideb))
);
INSERT INTO triangle (sidea, sideb) VALUES(1,1),(3,4),(6,8);

SELECT * FROM triangle;

CREATE TABLE triangle_like LIKE triangle;

CREATE TABLE triangle_select SELECT * FROM triangle;

```

## 


```
CREATE TEMPORARY TABLE IF NOT EXISTS test.test_table
(
	a INT UNSIGNED ZEROFILL
	#NOT NULL DEFAULT 0
	AUTO_INCREMENT UNIQUE KEY PRIMARY KEY
	COMMENT '字段a'
	COLUMN_FORMAT FIXED
	STORAGE DISK,

	b INT UNSIGNED ZEROFILL
	#NOT NULL DEFAULT 0
	UNIQUE KEY
	COMMENT '字段a'
	COLUMN_FORMAT FIXED
	STORAGE DISK
)
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 8
DEFAULT CHARACTER SET = utf8
CHECKSUM = 0
DEFAULT COLLATE = utf8_general_ci
COMMENT = '表test_table'
COMPRESSION = 'NONE'
CONNECTION = ''
DATA DIRECTORY = '/usr/local/mysql/data'
INDEX DIRECTORY = '/usr/local/mysql/data'
DELAY_KEY_WRITE = 0
ENCRYPTION = 'N'
ENGINE = 'InnoDB'
INSERT_METHOD = NO
KEY_BLOCK_SIZE = 1024
MAX_ROWS = 10
MIN_ROWS = 5
PACK_KEYS = 0
PASSWORD = 'abc'
ROW_FORMAT = FIXED
STATS_AUTO_RECALC = 1
STATS_PERSISTENT = 1
STATS_SAMPLE_PAGES = 16
TABLESPACE innodb_file_per_table STORAGE DISK
;
```


## https://dev.mysql.com/doc/refman/5.7/en/select.html

https://mariadb.com/kb/en/library/select-into-outfile/

SELECT ... [INTO OUTFILE 'file_name'
	[CHARACTER SET charset_name]
	export_options
	| INTO DUMPFILE 'file_name'
	| INTO var_name [, var_name]]