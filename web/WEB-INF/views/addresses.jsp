<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<h1>Address Listing</h1>
<c:if test="${not empty addresses}">
    <table class="table table-bordered table-responsive table-hover table-striped">
        <thead>
        <tr>
            <th>Address</th>
            <%--<th>Country</th>
            <th>City</th>
            <th>Street</th>
            <th>Building</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${addresses}" var="address">
            <tr>
                <td>
                    <a href="<spring:url value="/company/${companyId}/address/${address.id}"/>">${address.zip} ${address.country} ${address.city} ${address.street} ${address.buildingNumber}</a>
                </td>
                <%--<td>${account.lastName}</td>
                <td>${account.birthDate}</td>
                <td>${account.email}</td>
                <td>${account.password}</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Add address
</button>
<form:form commandName="address" cssClass="form-horizontal">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Add address</h4>
                </div>
                <div class="modal-body">
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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
        </div>
    </div>
</form:form>
