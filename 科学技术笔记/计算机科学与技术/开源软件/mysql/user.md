SET PASSWORD FOR 'root'@'localhost' = PASSWORD('admin');

GRANT ALL ON *:* TO 'root'@'%' identified by 'admin' with grant option;

select * from mysql.USER\G;

select * from information_schema.USER_PRIVILEGES;