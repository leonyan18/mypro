<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11835
  Date: 2018/9/9
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="user" items="${test}">
<c:out value="user.id"/><br/>
    <c:out value="user.username"/><br/>
</c:forEach>
<a href="<s:url value="/register"/>"><button>注册</button></a>