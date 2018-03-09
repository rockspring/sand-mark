# xmlint工具使用案例

数据例子

https://www.w3schools.com/xml/books.xml

xmllint --debug pom.xml

## 对于有默认命名空间xmlns的xml文件，在交互式shell里如何编写xpath

```
$ xmllint --shell pom.xml
/ > cat //modelVersion
/ > 
/ > 
/ > 
/ > setns x=http://maven.apache.org/POM/4.0.0
/ > cat //x:modelVersion
/ > cat /x:project/x:modelVersion
```


## 对于有默认命名空间xmlns的xml文件，使用local-name()

```
xmllint --xpath "/*[local-name()='project']/*[local-name()='modelVersion']"  pom.xml
xmllint --xpath "/*[local-name()='project']/*[local-name()='project' and namespace-uri()='http://maven.apache.org/POM/4.0.0']"  pom.xml
```

## 对于有默认命名空间xmlns的xml文件，可以先去掉xmlns这个属性，变成一个没有默认命名空间的xml文件

```
cat pom.xml |sed 's/xmlns="[^"]*"//g' | xmllint --xpath '/project/modelVersion' -
```

正则表达式可能太贪婪

排除掉"这个字符是最佳选择

```
sed 's/xmlns="[^"]*"//g'
```

还有一种方式

```
sed -e "s/xmlns/ignore/"
```

## 对于有默认命名空间xmlns的xml文件，先去掉xmlns这个属性，变成一个没有默认命名空间的xml文件，然后将交互式shell改成非交互式方式

````
cat pom.xml |sed 's/xmlns="[^"]*"//g' > pom.no-ns.xml
xmllint --shell pom.no-ns.xml --encode utf8 <<< `echo 'cat /project/modelVersion'`

rm pom.no-ns.xml
``

## 参考资料

https://gist.github.com/bitsgalore/3e403b02f776f03444c0622cb3b08b56

https://stackoverflow.com/questions/8264134/xmllint-failing-to-properly-query-with-xpath

http://www.objectorientedphp.com/articles/xmllint.html

https://docs.oracle.com/javase/tutorial/jaxp/xslt/xpath.html
