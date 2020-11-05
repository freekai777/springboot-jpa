<%--
  Created by IntelliJ IDEA.
  User: fellakai
  Date: 2020/11/5
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring MVC Themes</title>
    <!-- 属性文件中定义的键值 -->
    <link rel="stylesheet" href="<spring:theme code="style"/>" type="text/css" />
</head>
<body>
Theme :
<a href="?theme=light">Light</a> - <a href="?theme=red">Red</a>
<br/>
</body>
