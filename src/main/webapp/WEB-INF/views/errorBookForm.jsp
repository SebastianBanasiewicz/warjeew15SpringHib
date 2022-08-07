<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="book">

    <label>Title:</label>
    <form:input path="title" />
    <form:errors path="title" cssClass="error-class"/>

    <br>
    <label>Description:</label>
    <form:input path="description" />
    <form:errors path="description" cssClass="error-class"/>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
