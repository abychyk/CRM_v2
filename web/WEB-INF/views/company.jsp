<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<c:if test="${not empty company.name}">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">${company.name}</h2>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-1 col-lg-1 " align="center"></div>
                            <div class=" col-md-11 col-lg-11 ">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Company CEO</td>
                                        <td>${company.account.firstName} ${company.account.lastName}</td>
                                    </tr>
                                    <tr>
                                        <td>Creation Date</td>
                                        <td>${company.creationDate}</td>
                                    </tr>
                                    <tr>
                                        <td>Annual Revenue</td>
                                        <td>${company.annualRevenue}</td>
                                    </tr>
                                    <tr>
                                        <c:if test="${not empty company.addressSet}">
                                            <td>Address</td>
                                            <td>
                                                <c:forEach items="${company.addressSet}" var="address">
                                                    ${address.zip}, ${address.country}, ${address.city}, ${address.street} ${address.buildingNumber}
                                                    <br/>
                                                </c:forEach>
                                            </td>
                                        </c:if>
                                    </tr>
                                    <td>Phone Number</td>
                                    <td>${company.phone}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <a href="<c:url value="/company/${company.id}/products/"/>" class="btn btn-primary">Products</a>
                                <a href="<c:url value="/company/${company.id}/addresses"/>" class="btn btn-primary">Add Address</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${empty company.name}">
    <h1>You haven't created a company yet</h1>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        Create Company
    </button>
    <form:form commandName="company" cssClass="form-horizontal">
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
                            <label for="name" class="col-sm-2 control-label">Company Name:</label>
                            <div class="col-sm-10">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="annualRevenue" class="col-sm-2 control-label">Annual Revenue:</label>
                            <div class="col-sm-10">
                                <form:input path="annualRevenue" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Phone:</label>
                            <div class="col-sm-10">
                                <form:input path="phone" cssClass="form-control"/>
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
</c:if>