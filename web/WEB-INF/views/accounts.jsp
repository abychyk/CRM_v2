<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 22.05.2016
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp"%>

<h1>Account Listing</h1>
<c:if test="${not empty accounts}">
    <table class="table table-bordered table-responsive table-hover table-striped">
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
