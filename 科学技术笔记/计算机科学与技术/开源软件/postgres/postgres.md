# postgres

## 安装

## mac

```
brew install postgres --with-dtrace --with-python --without-perl --without-tcl
```

```
$ brew install postgres --with-dtrace --with-python --without-perl --without-tcl
Updating Homebrew...
==> Auto-updated Homebrew!
Updated 1 tap (homebrew/core).
==> New Formulae
pdfsandwich                                                                                                             pony-stable
==> Updated Formulae
abcm2ps                 baobab                  consul-template         folly                   gom                     jpeg-turbo              libraw                  notmuch                 pwntools                valabind
anjuta                  basex                   elasticsearch           freexl                  gtk+3                   kibana                  libsoup                 openrtsp                rabbitmq                you-get
app-engine-go-64        bitrise                 emacs ✔                 gdk-pixbuf              gucharmap               lbdb                    llnode                  packetbeat              rebar@3
app-engine-java         btfs                    ffmpeg                  gdl                     hugo                    libgsm                  logstash                paket                   roswell
at-spi2-atk             buku                    fibjs                   glib                    iozone                  libgweather             media-info              pam_yubico              sdb
at-spi2-core            cgrep                   file-roller             glib-networking         ired                    libhdhomerun            metricbeat              plantuml                tgui
atk                     chronograf              filebeat                gobject-introspection   jenkins                 libinfinity             mongodb                 poco                    todoman
awscli                  cmark-gfm               fizmo                   gofabric8               jhipster                libmowgli               nomad                   pre-commit              vala
==> Renamed Formulae
fbida -> exiftran

==> Downloading https://ftp.postgresql.org/pub/source/v9.6.5/postgresql-9.6.5.tar.bz2
######################################################################## 100.0%
==> ./configure --prefix=/usr/local/Cellar/postgresql/9.6.5 --datadir=/usr/local/share/postgresql --libdir=/usr/local/lib --sysconfdir=/usr/local/etc --docdir=/usr/local/Cellar/postgresql/9.6.5/share/doc/postgresql --enable-thread-safety 
==> make
==> make install-world datadir=/usr/local/Cellar/postgresql/9.6.5/share/postgresql libdir=/usr/local/Cellar/postgresql/9.6.5/lib pkglibdir=/usr/local/Cellar/postgresql/9.6.5/lib/postgresql
==> /usr/local/Cellar/postgresql/9.6.5/bin/initdb /usr/local/var/postgres
==> Caveats
If builds of PostgreSQL 9 are failing and you have version 8.x installed,
you may need to remove the previous version first. See:
  https://github.com/Homebrew/legacy-homebrew/issues/2510

To migrate existing data from a previous major version (pre-9.0) of PostgreSQL, see:
  https://www.postgresql.org/docs/9.6/static/upgrading.html

To migrate existing data from a previous minor version (9.0-9.5) of PostgreSQL, see:
  https://www.postgresql.org/docs/9.6/static/pgupgrade.html

  You will need your previous PostgreSQL installation from brew to perform `pg_upgrade`.
  Do not run `brew cleanup postgresql` until you have performed the migration.

To have launchd start postgresql now and restart at login:
  brew services start postgresql
Or, if you don't want/need a background service you can just run:
  pg_ctl -D /usr/local/var/postgres start
==> Summary
🍺  /usr/local/Cellar/postgresql/9.6.5: 3,267 files, 36.5MB, built in 26 minutes 55 seconds
```

```
createuser -s postgres
```

### ubuntu

```
apt-get install postgresql
```

https://askubuntu.com/questions/831292/how-to-install-postgresql-9-6-on-any-ubuntu-version

### 启动

```
~# service postgresql
Usage: /etc/init.d/postgresql {start|stop|restart|reload|force-reload|status} [version ..]
```

```
postgres  21034  0.0  0.0 246112 21148 ?        S    10:01   0:00 /usr/lib/postgresql/9.3/bin/postgres -D /var/lib/postgresql/9.3/main -c config_file=/etc/postgresql/9.3/main/postgresql.conf
```


```
~# lsof -p 21034
COMMAND    PID     USER   FD   TYPE             DEVICE SIZE/OFF       NODE NAME
postgres 21034 postgres  cwd    DIR                8,4     4096     265659 /var/lib/postgresql/9.3/main
postgres 21034 postgres  rtd    DIR                8,2     4096          2 /
postgres 21034 postgres  txt    REG                8,2  5633016    1319675 /usr/lib/postgresql/9.3/bin/postgres
postgres 21034 postgres  DEL    REG                0,5          1534892119 /dev/zero
postgres 21034 postgres  mem    REG                8,2  3165552    1179788 /usr/lib/locale/locale-archive
postgres 21034 postgres  mem    REG                8,2    30944    1184547 /usr/lib/x86_64-linux-gnu/libffi.so.6.0.1
postgres 21034 postgres  mem    REG                8,2    43368    2621643 /lib/x86_64-linux-gnu/libcrypt-2.19.so
postgres 21034 postgres  mem    REG                8,2   754880    1183973 /usr/lib/x86_64-linux-gnu/libsqlite3.so.0.8.6
postgres 21034 postgres  mem    REG                8,2   295816    1186592 /usr/lib/x86_64-linux-gnu/libhx509.so.5.0.0
postgres 21034 postgres  mem    REG                8,2    56768    1186580 /usr/lib/x86_64-linux-gnu/libheimbase.so.1.0.0
postgres 21034 postgres  mem    REG                8,2   166040    1186586 /usr/lib/x86_64-linux-gnu/libwind.so.0.0.0
postgres 21034 postgres  mem    REG                8,2    18416    2621699 /lib/x86_64-linux-gnu/libgpg-error.so.0.10.0
postgres 21034 postgres  mem    REG                8,2   268368    1184581 /usr/lib/x86_64-linux-gnu/libp11-kit.so.0.0.0
postgres 21034 postgres  mem    REG                8,2    80256    1183947 /usr/lib/x86_64-linux-gnu/libtasn1.so.6.2.0
postgres 21034 postgres  mem    REG                8,2    85680    1186532 /usr/lib/x86_64-linux-gnu/libroken.so.18.1.0
postgres 21034 postgres  mem    REG                8,2   204104    1186574 /usr/lib/x86_64-linux-gnu/libhcrypto.so.4.1.0
postgres 21034 postgres  mem    REG                8,2   657712    1186538 /usr/lib/x86_64-linux-gnu/libasn1.so.8.0.0
postgres 21034 postgres  mem    REG                8,2   552584    1186598 /usr/lib/x86_64-linux-gnu/libkrb5.so.26.0.0
postgres 21034 postgres  mem    REG                8,2    35856    1186604 /usr/lib/x86_64-linux-gnu/libheimntlm.so.0.1.0
postgres 21034 postgres  mem    REG                8,2   524704    2621499 /lib/x86_64-linux-gnu/libgcrypt.so.11.8.2
postgres 21034 postgres  mem    REG                8,2   775112    1183951 /usr/lib/x86_64-linux-gnu/libgnutls.so.26.22.6
postgres 21034 postgres  mem    REG                8,2   251872    1186610 /usr/lib/x86_64-linux-gnu/libgssapi.so.3.0.0
postgres 21034 postgres  mem    REG                8,2   109296    1186618 /usr/lib/x86_64-linux-gnu/libsasl2.so.2.0.25
postgres 21034 postgres  mem    REG                8,2    59640    1186629 /usr/lib/x86_64-linux-gnu/liblber-2.4.so.2.8.3
postgres 21034 postgres  mem    REG                8,2   141574    2621653 /lib/x86_64-linux-gnu/libpthread-2.19.so
postgres 21034 postgres  mem    REG                8,2   101240    2621465 /lib/x86_64-linux-gnu/libresolv-2.19.so
postgres 21034 postgres  mem    REG                8,2    14256    2621771 /lib/x86_64-linux-gnu/libkeyutils.so.1.4
postgres 21034 postgres  mem    REG                8,2    43672    1186550 /usr/lib/x86_64-linux-gnu/libkrb5support.so.0.1
postgres 21034 postgres  mem    REG                8,2   186824    1186554 /usr/lib/x86_64-linux-gnu/libk5crypto.so.3.1
postgres 21034 postgres  mem    REG                8,2   104936    2621452 /lib/x86_64-linux-gnu/libaudit.so.1.0.0
postgres 21034 postgres  mem    REG                8,2   137400    2621511 /lib/x86_64-linux-gnu/liblzma.so.5.0.0
postgres 21034 postgres  mem    REG                8,2   100728    2621686 /lib/x86_64-linux-gnu/libz.so.1.2.8
postgres 21034 postgres  mem    REG                8,2  1840928    2621652 /lib/x86_64-linux-gnu/libc-2.19.so
postgres 21034 postgres  mem    REG                8,2   323056    1186627 /usr/lib/x86_64-linux-gnu/libldap_r-2.4.so.2.8.3
postgres 21034 postgres  mem    REG                8,2  1071552    2621467 /lib/x86_64-linux-gnu/libm-2.19.so
postgres 21034 postgres  mem    REG                8,2    14664    2621639 /lib/x86_64-linux-gnu/libdl-2.19.so
postgres 21034 postgres  mem    REG                8,2   285848    1186564 /usr/lib/x86_64-linux-gnu/libgssapi_krb5.so.2.2
postgres 21034 postgres  mem    REG                8,2    14592    2621454 /lib/x86_64-linux-gnu/libcom_err.so.2.1
postgres 21034 postgres  mem    REG                8,2   831616    1186558 /usr/lib/x86_64-linux-gnu/libkrb5.so.3.3
postgres 21034 postgres  mem    REG                8,2  1930528    2621501 /lib/x86_64-linux-gnu/libcrypto.so.1.0.0
postgres 21034 postgres  mem    REG                8,2   387256    2621502 /lib/x86_64-linux-gnu/libssl.so.1.0.0
postgres 21034 postgres  mem    REG                8,2    55856    2621535 /lib/x86_64-linux-gnu/libpam.so.0.83.1
postgres 21034 postgres  mem    REG                8,2  1461496    1184523 /usr/lib/x86_64-linux-gnu/libxml2.so.2.9.1
postgres 21034 postgres  mem    REG                8,2   149120    2621648 /lib/x86_64-linux-gnu/ld-2.19.so
postgres 21034 postgres  mem    REG                8,4   217032     525420 /var/cache/nscd/hosts
postgres 21034 postgres  DEL    REG                0,5             1343489 /SYSV0052e2c1
postgres 21034 postgres    0r   CHR                1,3      0t0       1029 /dev/null
postgres 21034 postgres    1w   REG                8,4     1506     656724 /var/log/postgresql/postgresql-9.3-main.log
postgres 21034 postgres    2w   REG                8,4     1506     656724 /var/log/postgresql/postgresql-9.3-main.log
postgres 21034 postgres    3u  IPv4         1534892114      0t0        TCP localhost:postgresql (LISTEN)
postgres 21034 postgres    4w   CHR                1,3      0t0       1029 /dev/null
postgres 21034 postgres    5w   CHR                1,3      0t0       1029 /dev/null
postgres 21034 postgres    6u  unix 0xffff8810aac67700      0t0 1534892117 /var/run/postgresql/.s.PGSQL.5432
postgres 21034 postgres    7r  FIFO                0,9      0t0 1534892121 pipe
postgres 21034 postgres    8w  FIFO                0,9      0t0 1534892121 pipe
postgres 21034 postgres    9u  IPv4         1534892126      0t0        UDP localhost:65411->localhost:65411
```

# 登陆

默认只能切换OS的用户到，然后执行如下命令

```
# su - postgres
psql
```

```
ALTER USER postgres PASSWORD 'admin';
```


# 修改服务器配置文件

## 查找配置在哪里

find / -type f -name "pg_hba.conf"

/etc/postgresql/9.6/main/pg_hba.conf

# MacOS

```
/Library/PostgreSQL/9.4/data/pg_hba.conf
```

### 端口监听配置

/etc/postgresql/9.6/main/postgresql.conf

```
listen_addresses = '*'
```

### 访问授权配置

/etc/postgresql/9.6/main/pg_hba.conf

```
host  all  all 0.0.0.0/0 md5
```

# 交互式客户端

```
psql -h 127.0.0.1 -p 5432 -U postgres
```

# 使用

## 查看有哪些数据库

MySQL: show databases

```
postgres-# \l
                                  List of databases
   Name    |  Owner   | Encoding |   Collate   |    Ctype    |   Access privileges
-----------+----------+----------+-------------+-------------+-----------------------
 postgres  | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
 template0 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
           |          |          |             |             | postgres=CTc/postgres
 template1 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
           |          |          |             |             | postgres=CTc/postgres
(3 rows)
```

## 连接到新的数据库

```
\c test
```

## 查看有哪些表

MySQL: show tables

```
postgres=# \dt
          List of relations
 Schema |  Name   | Type  |  Owner
--------+---------+-------+----------
 public | weather | table | postgres
(1 row)
```

## 查看表的详细情况

```
postgres=# \d+ pg_proc                                                                                                                                                               
                             Table "pg_catalog.pg_proc"
     Column      |     Type     | Modifiers | Storage  | Stats target | Description 
-----------------+--------------+-----------+----------+--------------+-------------
 proname         | name         | not null  | plain    |              | 
 pronamespace    | oid          | not null  | plain    |              | 
 proowner        | oid          | not null  | plain    |              | 
 prolang         | oid          | not null  | plain    |              | 
 procost         | real         | not null  | plain    |              | 
 prorows         | real         | not null  | plain    |              | 
 provariadic     | oid          | not null  | plain    |              | 
 protransform    | regproc      | not null  | plain    |              | 
 proisagg        | boolean      | not null  | plain    |              | 
 proiswindow     | boolean      | not null  | plain    |              | 
 prosecdef       | boolean      | not null  | plain    |              | 
 proleakproof    | boolean      | not null  | plain    |              | 
 proisstrict     | boolean      | not null  | plain    |              | 
 proretset       | boolean      | not null  | plain    |              | 
 provolatile     | "char"       | not null  | plain    |              | 
 pronargs        | smallint     | not null  | plain    |              | 
 pronargdefaults | smallint     | not null  | plain    |              | 
 prorettype      | oid          | not null  | plain    |              | 
 proargtypes     | oidvector    | not null  | plain    |              | 
 proallargtypes  | oid[]        |           | extended |              | 
 proargmodes     | "char"[]     |           | extended |              | 
 proargnames     | text[]       |           | extended |              | 
 proargdefaults  | pg_node_tree |           | extended |              | 
 prosrc          | text         |           | extended |              | 
 probin          | text         |           | extended |              | 
 proconfig       | text[]       |           | extended |              | 
 proacl          | aclitem[]    |           | extended |              | 
Indexes:
    "pg_proc_oid_index" UNIQUE, btree (oid)
    "pg_proc_proname_args_nsp_index" UNIQUE, btree (proname, proargtypes, pronamespace)
Has OIDs: yes
```

# 显示语句的执行时间开关

```
\timing on
\timing off
```

# 建表、写入数据、查询数据

```

CREATE TABLE weather (
    city            varchar(80),
    temp_lo         int,           -- low temperature
    temp_hi         int,           -- high temperature
    prcp            real,          -- precipitation
    date            date
);

CREATE TABLE cities (
    name            varchar(80),
    location        point
);

DROP TABLE weather;
DROP TABLE cities;

INSERT INTO weather VALUES ('San Francisco', 46, 50, 0.25, '1994-11-27');
INSERT INTO cities VALUES ('San Francisco', '(-194.0, 53.0)');
INSERT INTO weather (city, temp_lo, temp_hi, prcp, date)
    VALUES ('San Francisco', 43, 57, 0.0, '1994-11-29');

INSERT INTO weather (date, city, temp_hi, temp_lo)
    VALUES ('1994-11-29', 'Hayward', 54, 37);

COPY weather TO '/tmp/weather.txt';

COPY weather FROM '/tmp/weather.txt'
select * from weather;

复制到客户端机器的文件中。
\COPY weather TO '/tmp/weather.txt';


\COPY weather TO PROGRAM 'awk -F "\t" "{print $1}" > /tmp/weather.txt.1';

从程序的标准输出复制

awk -F "\t" 'BEGIN{OFS="\t"}{print "a"$1,$2,$3,$4,$5}' /tmp/weather.txt

\COPY weather FROM PROGRAM 'bash /tmp/transform-weather.sh';
```

```
CREATE TABLE log (
    log_time            timestamp,
    log_time2            timestamp,           -- time
    log_label         varchar(100),           -- 标签
    t1            integer,
    t2            integer,
    t3            integer
);

awk -F " " 'BEGIN{OFS=" "}{print strftime("%Y-%m-%d %H:%M:%S",$1/1000),strftime("%Y-%m-%d %H:%M:%S",$2/1000),$3,$4,$5,$6}' /tmp/log.txt

awk -F " " 'BEGIN{OFS="\t"}{print strftime("%Y-%m-%d %H:%M:%S",$1/1000),strftime("%Y-%m-%d %H:%M:%S",$2/1000),$3,$4,$5,$6}' scf.client.server.log.2017042112.txt

awk -F " " 'BEGIN{OFS="\t"}{print strftime("%Y-%m-%d %H:%M:%S",$1/1000),strftime("%Y-%m-%d %H:%M:%S",$2/1000),$3,$4,$5,$6}' http.client.server.log.2017042112.txt


COPY log FROM PROGRAM 'bash /tmp/log.sh' WITH DELIMITER as ' ';

COPY log FROM '/data1/logs/sdk-speed/scf.client.server.log.2017042112.txt.transform';

SELECT log_time, COUNT(*), histogram(t1, 0.0, 1000, 20) FROM log GROUP BY log_time ORDER BY log_time;
```


```
#50%分位线的值，没有刚好落在一个数据点上，取排名更靠前的一个值
select percentile_disc(0.5) within group (order by t1) from log;
#50%分位线的值，没有刚好落在一个数据点上，使用插值法计算一个
select percentile_cont(0.5) within group (order by t1) from log;
#6在数据中的排名，前面有百分之多少的小于6
select percent_rank(6) within group  (order by t1) from log;
```


SELECT date_trunc('minute', log_time) from log;


SELECT date_trunc('minute', log_time) as m from log group by m order by m;

SELECT date_trunc('minute', log_time) as m, percentile_cont(0.5) within group (order by t2) from log group by m order by m;

SELECT date_trunc('minute', log_time) as m, percentile_cont(0.95) within group (order by t1),percentile_cont(0.95) within group (order by t2),percentile_cont(0.95) within group (order by t3) from log group by m order by m;

SELECT date_trunc('minute', log_time) as m, percentile_cont(1.0) within group (order by t1),percentile_cont(1.0) within group (order by t2),percentile_cont(1.0) within group (order by t3) from log group by m order by m;


SELECT date_trunc('minute', log_time) as m, percentile_cont(0.5) within group (order by t2) from log group by m order by m;

\COPY (SELECT date_trunc('minute', log_time) as m, percentile_disc(0.95) within group (order by t1) from log group by m order by m) TO  '/data1/logs/sdk-speed/20170421.95.t1.txt';

\COPY (SELECT date_trunc('minute', log_time) as m, percentile_disc(0.95) within group (order by t2) from log group by m order by m) TO  '/data1/logs/sdk-speed/20170421.95.t2.txt';

\COPY (SELECT date_trunc('minute', log_time) as m, percentile_disc(0.95) within group (order by t3) from log group by m order by m) TO  '/data1/logs/sdk-speed/20170421.95.t3.txt';


paste /data1/logs/sdk-speed/20170421.95.t1.txt /data1/logs/sdk-speed/20170421.95.t2.txt /data1/logs/sdk-speed/20170421.95.t3.txt | awk -F "\t" 'BEGIN{print "|时间|客户端95线|时间|服务端95线|时间|损耗95线"; print "|---|---|---|---|---|---|"}{print "|"$1"|"$2"|"$3"|"$4"|"$5"|"$6"|"}'


SELECT width_bucket(salary, 70000, 140000, 5) as bucket, 
       count(*) as cnt
GROUP BY bucket 
ORDER BY bucket;
