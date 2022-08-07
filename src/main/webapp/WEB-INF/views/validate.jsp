<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${violations}" var="violation">
    <p>${violation.message.concat(" - ").concat(violation.propertyPath)}</p>
</c:forEach>
</body>
</html>
