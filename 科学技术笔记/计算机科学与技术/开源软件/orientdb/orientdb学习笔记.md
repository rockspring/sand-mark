在图的术语中，一个记录（record）是一个顶点（vertex）。
在文档的术语中，一个记录（record）是一个文档。

边（edge）在图的术语中，含义丰富。

链接（link）在文档的术语中。

类（class）通过继承、属性和约束限制为数据库模式提供了规则和结构

集群（cluster）提供数据分片和复制功能。

数据实体（entity），数据的主要存储容器，也成为记录（record），在图中叫做顶点（vertex或node）。

数据关系（relationship），两个顶点或文档之间的直接连接。

数据属性（attribute或properties），嵌入到文档、顶点或边的有类型的或json数据。

Each "O" Class has a purpose and helps add functionality to the database. You should research their purpose before you remove or modify one of them. 

Studio provides mechanisms for using both the visual interface and executing code commands in the browse tab. 

The V class is the base class for a Vertex while the E class is the base class for an Edge. 

In the graph view, when you execute a query only the first 20 records are displayed. Subsequent queries with different parameters will add nodes to the view within these result limits. 


console

create database remote:localhost/ConsoleDemo root admin plocal

disconnect

help

connect remote:localhost root admin

list databases

connect remote:localhost/databases/ConsoleDemo admin admin

config

config get storage.useWAL

create class Person extends V

list classes

create property Person.name string

info class Person

insert into Person (name) values ("小明"), ("小花"), ("张三")

browse class Person

disconnect

# backup

停止服务器进程

./server.sh

connect plocal:../databases/ConsoleDemo admin admin

backup database /tmp/ConsoleDemo.zip

disconnect

./server.sh

connect remote:localhost/databases/ConsoleDemo admin admin

select from Person

load record #25:0

export database /tmp/ConsoleDemo.export

import database /tmp/ConsoleDemo.export.gz

# SQL API

create class Person

create class Lead EXTENDS V

create class Vehicle cluster 10

create class DataItem abstract

alter class Person name Individual

alter class Account addcluster EuropeA

alter class Car clusterselection round-robin

drop class Person

truncate class Lead

create cluster accountsUSA

create cluster CarsUSA position 3

alter cluster Europe name Italy

alter cluster Europe compression gzip

alter cluster V conflictstrategy automerge

drop cluster CarsUSA

drop cluster 10

truncate cluster NorthAmerica

## properties

create property Person.name string

create property Company.salesVolume float

create property Profile.tags embeddedlist string

alter property Person.name mandatory true

alter property Contact.gender regexp [M|F]

alter property Company.tagline name slogan

drop property Person.name


## creating records

insert into V (name, type) values ('SuperSong', 'song'), ('Brian', 'artist')

insert into V set name='Gary', type='artist'

insert into V content {"name": "Dave", "type":"artist"}

insert into cluster:9 (name) values('Bobby')

insert into Diver set name='Bill', buddy = (select from diver where name='Max')

insert into Husband set name='Wayne', wife = (insert into diver name='Jill')

insert into cluster:ClientFR from (select from client where country='Canada')

create vertex Bus cluster Operational

create vertex Employee content {"name" : "Jay", "Surname" : "Miner"}


select from Account

select name, age from Account

select * from Person where name like 'Luk%'

select * from Person where name.left(3) = 'Luk'

select from [#10:3, #10:4, #10:5]

select name.toUppercase(), address.city.country.name from Profile

select from Profile order by @rid desc

select from Profile let $city = address.city
where $city.name like '%Saint%' and ($city.country.name = 'Italy' or $city.country.name = 'France')


update Profile set name ='Dave' where name is NULL

update Profile remove name

update Account ADD addresses = #12:0

update #15:332 set address = {"street": "Rose Ave.", "city":{"name": "NY"}}

update Profile set job = 'Labourer' where job is NULL limit 20

update Counter increment views = 1 where page='/downloads/' LOCK RECORD

update Person SET firstname = 'Dave' upsert where status='active'


delete from Profile where suname.toLowerCase() = 'unknown'

delete from Leads where age > 120

delete from cluster:Archive

delete from #13:45 return before


## do some extra checks and balances to enure your database actions conform to certain requirements such as the need for a vertex to belong to a class extending V.

create vertex Person set firstName="Bob", lastName="Wilson"

create vertex Person cluster Italy set firstName="Bob", lastName = "Brown"

delete vertex #24:865

delete vertex Automobile where currentModel=false

delete vertex Person where in.@Class='MembershipExpired'


create edge from #10:3 to #11:4

create edge WorksAt from #10:3 to #11:4

create edge WorksAt cluster Teamsters from $#10:321 to #11:42

create edge Underage from (select from Person where age < 18) to $14:5

create edge from #20:1013 to #21:1012 content {value: 12000}

delete edge owns where date < "2011-11"

delete edge owns where date < "2011-11" and in.boughtFor <=350

delete edge from #11:101 to #11:117 where date<="2009-01-01"

delete edge from #11:101 to #11:117 where @class = "comment" and status = "SPAM"


### traverse

traverse * from #10:1234

traverse * from #14:350 while $depth<=2

select from Person where any() traverse(0, 3) (firstName="Carl")

select out('Bought').out('Bought') from #25:769

select $path from (traverse out from Make while $depth<=3)

traverse Friends from #10:1234 while $depth <=3 strategy breadth_first

select from (traverse Friends from #10:1234 while $depth<=3) where $depth>=1

select out("Owns") from (traverse out("Bought", "Sold")[buyerRating>6 and sellerRating>6].in("Bought", "Sold") from #1:1 while $depth<3) where out("IsModel")[0] = #12:0


graph function

select in('isModel').color from #14:300

select both('Friend', 'Brother') from Person where lastName="Davis"

select outV() from bought where puchasePrice<10000

select from poi where distance(x,y,52,20472, 0.14056) <=30

select shortestPath(#13:30, #27:600, 'BOTH')

select dijstra($current, #13:30, 'weight') from V

select from (select in("IsModel") from #12:12) where avg(in("Owns").out("Sold").buyerRating) > 6



3 附加功能

server side functions

存储为文档

### users and roles

存储为OUser and ORole

role可以继承

每个资源有权限

记录级安全

用户的状态ACTIVE or SUSPENDED

### HTTP rest API


create read update delete

inspect dataproperties

execute server side function

build and manage data model

## distributed deployment

scale request - add bandwidth

replication - high availability

sharding - big data scale

./dserver.sh

## ETL module

extract transform load


