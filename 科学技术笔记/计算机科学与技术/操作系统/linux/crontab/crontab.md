# crontab

调度计划保存在哪个文件？

/var/spool/cron/crontabs

crontab -e 编辑的就是这个文件的内容

每个用户一个文件，文件名为用户名

crontab后台程序每分钟读一次这个文件

## /etc/crontab配置文件

system-wide crontab

crontab后台程序每分钟读一次这个文件

### 用到的命令

run-parts - run scripts or programs in a directory