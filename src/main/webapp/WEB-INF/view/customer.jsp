<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/28
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顾客信息列表</title>
</head>
<body>

<table border="1px solid blue;">
    <thead>
    <h1>客户信息列表</h1>
    </thead>
    <tr>
        <th>客户名称</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>邮箱地址</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach var="item" items="${customers}">
        <tr>
            <td>${item.name}</td>
            <td>${item.contact}</td>
            <td>${item.telephone}</td>
            <td>${item.email}</td>
            <td>
                <a href="${BASE}/customer_edit?id=${item.id}">编辑</a>
            </td>
            <td>
                <a href="${BASE}/customer_delete?id=${item.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
