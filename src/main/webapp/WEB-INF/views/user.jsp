<%--
  Created by IntelliJ IDEA.
  User: 11835
  Date: 2018/9/9
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal.username" var="name" scope="page"/>
<h1>${name}</h1>
<h1>${people.name}</h1>
<h1>${people.age}</h1>
<h1>${people.phone}"</h1>
<sec:authorize access="hasRole('ROLE_USER')">
    <span><button>ok</button></span>
</sec:authorize>
<a href="<s:url value="/logout"/>"><button>退出</button></a>