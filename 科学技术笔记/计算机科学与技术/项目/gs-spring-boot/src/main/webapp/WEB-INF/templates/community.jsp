<%--
  Created by IntelliJ IDEA.
  User: zlq
  Date: 6/1/15
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UESearch 小区搜索服务查询接口示例</title>
</head>
<body>
    <h1>UESearch 小区搜索服务查询接口示例</h1>

    <div>
        <h2>查询一个城市的所有小区，按小区房源数量从大到小排序，取出前100条</h2>
        <a href="${url}" style="width: 100%; word-wrap: break-word;" target="_blank">${url}</a>
    </div>

    <div>
        <h2>查询一个城市的所有小区，按小区房源数量从大到小排序，取出前100条，用solr实现</h2>
        <a href="${solr_url}" style="width: 100%; word-wrap: break-word;" target="_blank">${solr_url}</a>
    </div>
</body>
</html>
