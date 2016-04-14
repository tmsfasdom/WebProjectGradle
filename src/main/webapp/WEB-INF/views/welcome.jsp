<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>HelloWorld page</title>
</head>
<body>
    Greeting : ${greeting}
    This is a welcome page.
    <c:forEach items="${listAuth}" var="ppl">
    <p>${ppl}</p>
    </c:forEach>
</body>
</html>