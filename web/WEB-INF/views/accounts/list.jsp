<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 22.05.2016
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account list</title>
</head>
<body>
    <h1>Account Listing</h1>
    <c:if test="${not empty accounts}">
        <table>
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birth Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.firstName}</td>
                    <td>${account.lastName}</td>
                    <td>${account.birthDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
