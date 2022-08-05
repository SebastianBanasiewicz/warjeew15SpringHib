<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potężny developer</title>
</head>
<body>
<a href="<c:url value="/person/add"/>">
    <button>Add</button>
</a>
<table>
    <tr>
        <th>LOGIN</th>
        <th>PASSWORD</th>
        <th>EMAIL</th>
        <th>ACTIONS</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.login}</td>
            <td>${person.password}</td>
            <td>${person.email}</td>
            <td>
                <a href="<c:url value="/person/edit?id=${person.id}"/>">
                    <button>Edit</button>
                </a>
                <a href="<c:url value="/person/delete?id=${person.id}"/>">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
