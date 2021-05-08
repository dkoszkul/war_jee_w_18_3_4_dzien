<%--
  Created by IntelliJ IDEA.
  User: dominikkoszkul
  Date: 07.05.2021
  Time: 07:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<c:forEach items="${violations}" var="v">
    ${v.getPropertyPath()} : ${v.message} </br>
</c:forEach>
</body>
</html>
