<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 10.06.2016
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp"%>

<form:form commandName="account" cssClass="form-horizontal">
    <c:if test="${param.success eq true}">
        <div class="alert alert-success">Registration successful</div>
    </c:if>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
            <form:password path="password" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">First Name:</label>
        <div class="col-sm-10">
            <form:input path="firstName" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">Last Name:</label>
        <div class="col-sm-10">
            <form:input path="lastName" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-lg btn-primary" value="Register"/>
        </div>
    </div>
</form:form>