<%--
  Created by IntelliJ IDEA.
  User: yan
  Date: 2018/9/10
  Time: 18:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="header">
    <t:insertAttribute name="header"/>
    </div>
    <t:insertAttribute name="body"/>
    <div id="footer">
    <t:insertAttribute name="footer"/>
    </div>
</body>
</html>
