<%--
  Created by IntelliJ IDEA.
  User: dominikkoszkul
  Date: 07.05.2021
  Time: 07:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring 01 hibernate</title>
</head>
<body>
<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>
---------
<form:checkboxes items="${languages}" path="languages" />
</body>
</html>
