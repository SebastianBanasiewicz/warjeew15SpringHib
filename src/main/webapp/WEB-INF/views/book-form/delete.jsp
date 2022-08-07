<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="POST" modelAttribute="book">
    <table>
        <tr>
            Are you sure you want to delete this item?
        </tr>
    </table>
    <table>
        <tr>
            <th>title</th>
            <th>rating</th>
            <th>publisher</th>
        </tr>
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
        </tr>
    </table>
    <input type="submit" value="delete">
    <a href="<c:url value="/book-form/list"/>">back</a>
</form:form>
</body>
</html>
