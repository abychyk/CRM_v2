<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 22.05.2016
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login to CRM</title>
</head>
<body>
    <form:form id="loginForm" action="/login" method="POST" modelAttribute="account">
        <form:label path="email">Enter your email</form:label>
        <form:input id="email" name="email" path="" /><br>
        <form:label path="password">Please enter your password</form:label>
        <form:password id="password" name="password" path="" /><br>
        <input type="submit" value="executeLogin" />
    </form:form>
</body>
</html>
