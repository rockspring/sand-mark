# curl访问Basic access authentication协议的服务

用户名和密码使用冒号链接起来形成用户名密码结合体。比如用户名为abc，密码为123，用户名和密码结合体为abc:123。

将用户名密码结合体使用base64编码编码成一个字符串。执行```echo "abc:123" | base64```得到```YWJjOjEyMwo=```。

设置curl的header参数。header参数的key为Authorization，value为Basic前缀加上空格再加上刚才经过base64编码后得到的字符串，例子中value为```Basic YWJjOjEyMwo=```。

```
curl --header "Authorization:Basic YWJjOjEyMwo=" http://www.example.com/index.html
```

如果有POST请求方式发送的参数

```
curl --header "Authorization:Basic YWJjOjEyMwo=" --data "a=1&b=2" http://www.example.com/index.html
```