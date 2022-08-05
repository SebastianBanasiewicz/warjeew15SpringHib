<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
DANE:<br>
${student.firstName} ${student.lastName}<br>
Gender:
${student.gender}<br>
Country:
<ul>
    <c:forEach items="${student.countries}" var="country">
        <li> ${country} </li>
    </c:forEach>
</ul>
Notes:<br>
${student.notes}<br>
Mailing: ${student.mailingList}<br>
Programing skills:<br>
<ul>
    <c:forEach items="${student.programmingSkills}" var="skills">
        <li> ${skills} </li>
    </c:forEach>
</ul>
Hobbies:<br>
<ul>
    <c:forEach items="${student.hobbies}" var="hobby">
        <li> ${hobby} </li>
    </c:forEach>
</ul>
</body>
</html>
