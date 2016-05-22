<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 22.05.2016
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CRM</title>
    <link href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/resources/styles/app.css' />" rel="stylesheet"/>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="/"/>">
                    <img alt="Brand" src="<c:url value="/resources/img/brand.png" />">
                </a>
            </div>
            <div class="collapse navbar-collapse">
                <p class="navbar-text">CRM system</p>
                <div class="nav navbar-nav navbar-right">
                    <a href="<c:url value="/login"/>" class="btn btn-primary navbar-btn">Login</a>
                    <input type="button" onclick="<c:url value="/login" />" value="Login" class="btn btn-primary navbar-btn">
                    <a href="<c:url value="/sighUp"/>" class="btn btn-success navbar-btn">Sign Up</a>
                </div>
            </div>
        </div>
    </nav>
    <%--<div class="container">
        <div class="col-md-4 col-md-offset-8">
            <a href="<c:url value="login.jsp"/>" class="btn btn-primary">Login</a>
            <a href="<c:url value="signUp.jsp"/>" class="btn btn-success">Sign Up</a>
        </div>
    </div>--%>
</body>
</html>
