<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="address" cssClass="form-horizontal">
    <div class="form-group">
        <label for="zip" class="col-sm-2 control-label">Zip:</label>
        <div class="col-sm-10">
            <form:input path="zip" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="country" class="col-sm-2 control-label">Country:</label>
        <div class="col-sm-10">
            <form:input path="country" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="col-sm-2 control-label">City:</label>
        <div class="col-sm-10">
            <form:input path="city" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="street" class="col-sm-2 control-label">Street:</label>
        <div class="col-sm-10">
            <form:input path="street" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="buildingNumber" class="col-sm-2 control-label">Building:</label>
        <div class="col-sm-10">
            <form:input path="buildingNumber" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-lg btn-primary" value="Add"/>
        </div>
    </div>
</form:form>