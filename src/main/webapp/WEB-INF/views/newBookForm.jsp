<%--
  Created by IntelliJ IDEA.
  User: dominikkoszkul
  Date: 07.05.2021
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Book Form</title>
    <style>
        .my-error {
            color: red;
        }
    </style>
</head>
<body>
    <form:form method="POST" modelAttribute="book">
        <form:input path="title"/>
        <form:errors path="title" cssClass="my-error"/></br>

        <form:input path="rating"/>
        <form:errors path="rating" cssClass="my-error"/></br>

        <form:input path="description"/>
        <form:errors path="description" cssClass="my-error"/></br>

        <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}" /></br>

        <input type="submit">
    </form:form>
</body>
</html>
