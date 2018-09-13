<%--
  Created by IntelliJ IDEA.
  User: 11835
  Date: 2018/9/9
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<sf:form method="post" modelAttribute="people">
    Name  :<input type="text" name="name" /><sf:errors path="name" cssClass="error"></sf:errors><br>
    age   :<input type="text" name="age" /><sf:errors path="age" cssClass="error"></sf:errors><br>
    phone :<input type="text" name="phone" /><sf:errors path="phone" cssClass="error"></sf:errors><br>
    <input type="submit" value="提交">
</sf:form>
