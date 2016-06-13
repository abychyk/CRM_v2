<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 12.06.2016
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>
<link href="<c:url value="/resources/styles/userProfile.css" />" rel="stylesheet"/>


<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title">${user.firstName} ${user.lastName}</h2>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td>${user.birthDate}</td>
                                </tr>
                                <tr>
                                <c:if test="${not empty user.address}">
                                    <tr>
                                        <td>Home Addresses</td>
                                        <td>
                                            <c:forEach items="${user.address}" var="address">
                                                ${address.zip}, ${address.country}, ${address.city}, ${address.street} ${address.buildingNumber}
                                                <br/>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:${user.email}">${user.email}</a></td>
                                </tr>
                                <td>Phone Number</td>
                                <td>${user.phone}</td>
                                </tr>
                                </tbody>
                            </table>

                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                Edit
                            </button>
                            <security:authorize access="isAuthenticated() and !hasRole('ROLE_ADMIN')">
                                <a href="<spring:url value="/company"/>" class="btn btn-primary">Company</a>
                                <a href="<spring:url value="/addressAdd"/>" class="btn btn-primary">Add Address</a>
                            </security:authorize>

                            <form:form commandName="account" cssClass="form-horizontal">
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel">Edit</h4>
                                            </div>
                                            <div class="modal-body">
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
                                                    <label for="lastName" class="col-sm-2 control-label">Phone:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="phone" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="birthDate" class="col-sm-2 control-label">Birth Date:</label>
                                                    <div class="col-sm-10">
                                                        <form:input path="birthDate" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <input type="submit" class="btn btn-primary" value="Save"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                            <%--<a href="#" class="btn btn-primary">Team Sales Performance</a>--%>
                        </div>
                    </div>
                </div>
                <%--<div class="panel-footer">
                    <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                    <span class="pull-right">
                        <a href="<c:url value="/profile/edit"/>" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="<c:url value="/profile/remove"/>" data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </security:authorize>
                    </span>
                </div>--%>
            </div>
        </div>
    </div>
</div>
