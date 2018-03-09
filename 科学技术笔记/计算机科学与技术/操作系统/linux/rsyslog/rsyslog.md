命令安装路径

/usr/sbin/rsyslogd

配置文件

/etc/rsyslog.conf

/etc/rsyslog.d

/etc/rsyslog.d/20-ufw.conf

/etc/rsyslog.d/50-default.conf

服务启动相关

/etc/init.d/rsyslog


logger命令

```
logger -i -s -p user.notice -t zlq 测试日志
logger -i -s -p user.notice -t zlq -- "-测试日志(前缀有个“-”符号，所以之前需要“--”作为消息分隔符)"
```

/var/log/syslog

```
Nov 28 04:11:53 ubuntu-14 zlq[1934]: 测试日志
Nov 28 04:11:57 ubuntu-14 zlq[1935]: -测试日志(前缀有个“-”符号，所以之前需要“--”作为消息分隔符)
```

文件内容source.txt

```
我是来自文件的第一行数据
我是来自文件的第二行数据
我是来自文件的第三行数据
```

```
logger -i -s -p user.notice -t zlq -f source.txt
```

/var/log/syslog

```
Nov 28 04:12:10 ubuntu-14 zlq[1937]: 我是来自文件的第一行数据
Nov 28 04:12:10 ubuntu-14 zlq[1937]: 我是来自文件的第二行数据
Nov 28 04:12:10 ubuntu-14 zlq[1937]: 我是来自文件的第三行数据
```

## 自定义配置/etc/rsyslog.d/user.conf

template这个一行的内容不能换行，所以只能看起来混乱一点了

@@表示用TCP协议发送日志

logger.example.com:8080 为接收日志的服务器

```
$template ls_json,"{%timestamp:::date-rfc3339,jsonf:@timestamp%,%source:::jsonf:@source_host%,\"@source\":\"syslog://%fromhost-ip:::json%\",\"@message\":\"%timestamp% %app-name%:%msg:::json%\",\"@fields\":{%syslogfacility-text:::jsonf:facility%,%syslogseverity-text:::jsonf:severity%,%app-name:::jsonf:program%,%procid:::jsonf:processid%}}\n"

*.*    @@logger.example.com:8080;ls_json
```

```
$template ls_json,"{%timestamp:::date-rfc3339,jsonf:@timestamp%,%source:::jsonf:@source_host%,\"@source\":\"syslog://%fromhost-ip:::json%\",\"@message\":\"%timestamp% %app-name%:%msg:::json%\",\"@fields\":{%syslogfacility-text:::jsonf:facility%,%syslogseverity-text:::jsonf:severity%,%app-name:::jsonf:program%,%procid:::jsonf:processid%}}\n"
*.*    /var/log/user.log;ls_json
```

每条日志添加了一个换行符，适合输出到文件日志

```
$template ls_json,"{
    %timestamp:::date-rfc3339,jsonf:@timestamp%,
    %source:::jsonf:@source_host%,
    \"@source\":\"syslog://%fromhost-ip:::json%\",
    \"@message\":\"%timestamp% %app-name%:%msg:::json%\",
    \"@fields\":{
        %syslogfacility-text:::jsonf:facility%,
        %syslogseverity-text:::jsonf:severity%,
        %app-name:::jsonf:program%,
        %procid:::jsonf:processid%
    }
}"
```

%timestamp:::date-rfc3339,jsonf:@timestamp%

%fromhost-ip:::json%

%timestamp%

%app-name%

%msg:::json%

%syslogfacility-text:::jsonf:facility%

%syslogseverity-text:::jsonf:severity%

%app-name:::jsonf:program%

%procid:::jsonf:processid%

模板解释说明：

%property:fromChar:toChar:options%

property为属性名称

fromChar和toChar是下标索引，从1开始计算

options为模板替换属性的操作选项

如果要取得属性的全部值，fromChar和toChar都可以省去，结果如下

%property:::options%

lowercase为options中一个，将属性值转换成小写

%msg:::lowercase%

jsonf，将一个属性值转换成一个json字段，形如"fieldname"="value"

fieldname在输出属性名称中指定，如果没有指定，则使用输入属性名称

属性值抽取需要转换操作的内容有多种方式

1 指定两个下标，截取一个字符串

设property=abcdefg

%property:2:3:options%，截取的字符串为bc

2 指定开始开始，截取后缀字符串

%property:2:$:options%，抽取的后缀为bcdefg

3 使用正则表达式

fromChar的地方放入R字符串

```
%msg:R:.*Sev:. \(.*\) \[.*–end%”
```

修改了配置，重载rsyslogd

# /sbin/reload
sudo reload rsyslog

/var/log/syslog日志文件中，内容如下：

```
Nov 28 09:57:58 ubuntu-14 zlq[3394]: 测试日志
```

在rsyslogd的字符串模板系统中进行属性替换（property replacer）后得到日志/var/log/user.log内容如下所示

```
{
    "@timestamp": "2016-11-28T09:57:58.710690+00:00",
    "@source_host": "ubuntu-14",
    "@source": "syslog://127.0.0.1",
    "@message": "Nov 28 09:57:58 zlq: 测试日志",
    "@fields": {
        "facility": "user",
        "severity": "notice",
        "program": "zlq",
        "processid": "3394"
    }
}
```

## 调试日志

配置文件修改/etc/rsyslog.conf

```
$DebugFile /var/log/debug.log
$DebugLevel 2
```

/var/log/debug.log

```
7045.909635462:7ff2a5ca4780: debug level 2 set via config file
7045.909750581:7ff2a5ca4780: This is rsyslog version 7.4.4
7045.909799441:7ff2a5ca4780: config parser: reached end of file /etc/rsyslog.conf
7045.909843516:7ff2a5ca4780: config parser: parsing completed
7045.909896018:7ff2a5ca4780: Decoding traditional PRI filter '*.*'
7045.909943330:7ff2a5ca4780: symbolic name: * ==> 255
7045.910021220:7ff2a5ca4780: cnf:global:script
7045.910078653:7ff2a5ca4780: begin ruleset optimization phase
7045.910125645:7ff2a5ca4780: ruleset 'RSYSLOG_DefaultRuleset' before optimization:
```

# 在程序中使用syslog

syslog-example.c

```
#include <syslog.h>

/*void openlog(const char *ident, int option, int facility);
void syslog(int priority, const char *format, ...);
void closelog(void);

#include <stdarg.h>

void vsyslog(int priority, const char *format, va_list ap);*/


int main(int argv, char* arg[]) {
    const char *ident = "我是程序名称";
    int option = LOG_CONS | LOG_NDELAY | LOG_NOWAIT | LOG_PERROR | LOG_PID;
    int facility = LOG_USER;
    openlog(ident, option, facility);

    int priority = LOG_DEBUG;

    syslog(priority, "%s,number=%d","我是一条测试日志",10);
    closelog();

    return 0;
}
```

## logrotate

/usr/sbin/logrotate

/var/lib/logrotate

/var/lib/logrotate/status

状态文件，记录每个日志文件名称及日期

/etc/logrotate.conf

/etc/logrotate.d

/etc/logrotate.d/apt

/etc/logrotate.d/upstart

/etc/logrotate.d/dpkg

/etc/logrotate.d/ufw

/etc/logrotate.d/rsyslog

/etc/logrotate.d/aptitude

/etc/logrotate.d/ppp

定时任务

/etc/cron.daily/logrotate


https://github.com/rsyslog/rsyslog/blob/master/tests/tcpflood.c

https://www.nginx.com/resources/wiki/start/topics/examples/logrotation/

