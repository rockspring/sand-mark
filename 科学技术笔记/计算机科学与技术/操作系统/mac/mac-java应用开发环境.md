# mac java应用开发环境

## 安装JDK

Oracle JDK主页

http://www.oracle.com/technetwork/java/javase/overview/index.html

JAVA_HOME目录

执行/usr/libexec/java_home命令输出JAVA_HOME

/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home

~/.bash_profile文件内容
```
export JAVA_HOME=`/usr/libexec/java_home`
export PATH=$JAVA_HOME:$PATH
```

Mac系统自行安装的路径
```
/usr/bin/appletviewer -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/appletviewer
/usr/bin/apt -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/apt
/usr/bin/extcheck -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/extcheck
/usr/bin/idlj -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/idlj
/usr/bin/jar -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jar
/usr/bin/jarsigner -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jarsigner
/usr/bin/java -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/java
/usr/bin/javac -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javac
/usr/bin/javadoc -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javadoc
/usr/bin/javah -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javah
/usr/bin/javap -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javap
/usr/bin/javapackager -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javapackager
/usr/bin/javaws -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/javaws
/usr/bin/jcmd -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jcmd
/usr/bin/jconsole -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jconsole
/usr/bin/jcontrol -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jcontrol
/usr/bin/jdb -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jdb
/usr/bin/jdeps -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jdeps
/usr/bin/jhat -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jhat
/usr/bin/jhsdb -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jhsdb
/usr/bin/jimage -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jimage
/usr/bin/jinfo -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jinfo
/usr/bin/jjs -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jjs
/usr/bin/jmap -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jmap
/usr/bin/jmc -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jmc
/usr/bin/jps -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jps
/usr/bin/jrunscript -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jrunscript
/usr/bin/jsadebugd -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jsadebugd
/usr/bin/jshell -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jshell
/usr/bin/jstack -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jstack
/usr/bin/jstat -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jstat
/usr/bin/jstatd -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jstatd
/usr/bin/jvisualvm -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/jvisualvm
/usr/bin/keytool -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/keytool
/usr/bin/native2ascii -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/native2ascii
/usr/bin/orbd -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/orbd
/usr/bin/pack200 -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/pack200
/usr/bin/policytool -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/policytool
/usr/bin/rmic -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/rmic
/usr/bin/rmid -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/rmid
/usr/bin/rmiregistry -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/rmiregistry
/usr/bin/schemagen -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/schemagen
/usr/bin/serialver -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/serialver
/usr/bin/servertool -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/servertool
/usr/bin/tnameserv -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/tnameserv
/usr/bin/unpack200 -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/unpack200
/usr/bin/wsgen -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/wsgen
/usr/bin/wsimport -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/wsimport
/usr/bin/xjc -> /System/Library/Frameworks/JavaVM.framework/Versions/Current/Commands/xjc
```

Java Cryptography Extension (JCE)

http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html

http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

```
jrunscript -e 'exit (javax.crypto.Cipher.getMaxAllowedKeyLength("RC5") >= 256);'; echo $?
#[必须返回值为1，否则会出现登陆不了的问题]
#如果返回0，需要替换jdk中的jar包，下载http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html ,替换JAVA_HOME/jre/lib/security/下的local_policy.jar，US_export_policy.jar即可
```

```
mv ~/Downloads/UnlimitedJCEPolicy/local_policy.jar $JAVA_HOME/jre/lib/security/local_policy.jar
mv ~/Downloads/UnlimitedJCEPolicy/US_export_policy.jar $JAVA_HOME/jre/lib/security/US_export_policy.jar
```

## 安装软件开发工具

```
brew install maven
brew install ant
brew install gradle
```

## 安装maven

```
brew install maven
```

### 配置文件

全局配置 $M2_HOME/conf/settings.xml

用户特定的配置 ${user.home}/.m2/settings.xml

## 安装ant

```
brew install ant
```

## 安装gradle

```
brew install gradle
```

## 安装IntelliJ IDEA

http://www.jetbrains.com/idea/

```
cd /Applications/IntelliJ\ IDEA\ CE.app/Contents

配置文件 Info.plist

cd /Applications/IntelliJ\ IDEA\ CE.app/Contents/bin

配置文件 idea.vmoptions

更改主题为Darcula

字体 默认Lucida Grande 13

更改Editor配置，主题另存为my

配置JDK

更改Editor配置

preferences --> Editor --> General --> Appearance --> Show line numbers
```

## jconsole监控java虚拟机的线程插件

jconsole是jdk中的一个工具，通过JMX监控java虚拟机

[https://bitbucket.org/pjtr/topthreads](https://bitbucket.org/pjtr/topthreads)

## java应用剖析工具

[https://www.ej-technologies.com/products/jprofiler/overview.html](https://www.ej-technologies.com/products/jprofiler/overview.html)

## java性能监控工具

[https://www.azul.com/jhiccup/](https://www.azul.com/jhiccup/)
