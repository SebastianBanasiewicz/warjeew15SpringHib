<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="person">
    LOGIN:
    <form:input path="login"/><br>
    PASSWORD:
    <form:input path="password"/><br>
    EMAIL:
    <form:input path="email"/><br>
    <input type="submit"/><br>
    <a href="<c:url value="/person/list"/>">LIST</a>


</form:form>
</body>
</html>
