<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
  <form:hidden path="id"/>
  Imię:<br>
  <form:input path="firstName"/><br>
  Nazwisko:<br>
  <form:input path="lastName"/><br>
  <%--    Wydawca--%>
  <%--    <form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name"/>--%>
  <%--    Autor--%>
  <%--    <form:select path="authors" items="${authors}" itemValue="id" itemLabel="fullName"/>--%>


  <input type="submit" value="Save">
</form:form>
</body>
</html>
