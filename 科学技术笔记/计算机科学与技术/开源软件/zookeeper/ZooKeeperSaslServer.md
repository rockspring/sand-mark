ServerCnxnFactory调用configureSaslLogin，如果有jaas.conf配置文件，创建Login实例，作为ServerCnxnFactory的一个字段login，并启动login的登陆线程

NIOServerCnxn实例创建时，如果ServerCnxnFactory的login存在，则创建一个ZooKeeperSaslServer实例，作为NIOServerCnxn实例的字段一个zooKeeperSaslServer


## ZooKeeperSaslServer实例创建

调用ZooKeeperSaslServer的createSaslServer方法

从login获得Subject

SaslServer createSaslServer(String mechanism,
                    String protocol,
                    String serverName,
                    Map<String,?> props,
                    javax.security.auth.callback.CallbackHandler cbh)

mechanism：GSSAPI

//zookeeper/myhost.foo.com@FOO.COM

servicePrincipalName:zookeeper

serviceHostnameAndKerbDomain:myhost.foo.com@FOO.COM

serviceHostname:myhost.foo.com

login的CallbackHandler

Sasl.createSaslServer(mech, servicePrincipalName, serviceHostname, null, login.callbackHandler)