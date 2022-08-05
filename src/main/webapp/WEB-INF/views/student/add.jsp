<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potężny developer</title>
</head>
<body>
<form:form method="POST" modelAttribute="student">
    Firstname:
    <form:input path="firstName"/><br>
    Lastname:
    <form:input path="lastName"/><br>
    Gender:
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Country:
    <form:select path="countries" items="${countries}"/><br>
    Notes:<br>
    <form:textarea path="notes"/><br>
    Mailing list:
    <form:checkbox path="mailingList"/><br>
    Programming skills:<br>
    <form:select path="programmingSkills">
    <form:option value="-" label="--Please Select--"/>
    <form:options items="${programmingSkills}"/>
    </form:select><br>
    Hobbies:<br>
    <form:checkboxes path="hobbies" items="${hobbies}"/><br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
