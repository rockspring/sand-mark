# Mac系统功能

2018年01月19日

## 守护进程管理器

launchd -- System wide and per-user daemon/agent manager

launchctl -- Interfaces with launchd

plutil -- property list utility

### launchd

#### 相关文件

```
~/Library/LaunchAgents         Per-user agents provided by the user.
/Library/LaunchAgents          Per-user agents provided by the administrator.
/Library/LaunchDaemons         System-wide daemons provided by the administrator.
/System/Library/LaunchAgents   Per-user agents provided by Apple.
/System/Library/LaunchDaemons  System-wide daemons provided by Apple.
```

## 开机自启动MySQL服务器

### 编写MySQL的配置文件

文件目录：/Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple Computer//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
    <key>Label</key>             <string>com.oracle.oss.mysql.mysqld</string>
    <key>ProcessType</key>       <string>Interactive</string>
    <key>Disabled</key>          <false/>
    <key>RunAtLoad</key>         <true/>
    <key>KeepAlive</key>         <true/>
    <key>SessionCreate</key>     <true/>
    <key>LaunchOnlyOnce</key>    <false/>
    <key>UserName</key>          <string>_mysql</string>
    <key>GroupName</key>         <string>_mysql</string>
    <key>ExitTimeOut</key>       <integer>600</integer>
    <key>Program</key>           <string>/usr/local/mysql/bin/mysqld</string>
    <key>ProgramArguments</key>
        <array>
            <string>/usr/local/mysql/bin/mysqld</string>
            <string>--user=_mysql</string>
            <string>--basedir=/usr/local/mysql</string>
            <string>--datadir=/usr/local/mysql/data</string>
            <string>--plugin-dir=/usr/local/mysql/lib/plugin</string>
            <string>--log-error=/usr/local/mysql/data/mysqld.local.err</string>
            <string>--pid-file=/usr/local/mysql/data/mysqld.local.pid</string>
             <string>--keyring-file-data=/usr/local/mysql/keyring/keyring</string>
             <string>--early-plugin-load=keyring_file=keyring_file.so</string>
           
        </array>
    <key>WorkingDirectory</key>  <string>/usr/local/mysql</string>
</dict>
</plist>

```

### 重载配置

```
sudo launchctl uload -w /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
sudo launchctl load -w /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
```

## postgresql

```
sudo launchctl unload -w /Library/LaunchDaemons/com.edb.launchd.postgresql-9.4.plist
```
