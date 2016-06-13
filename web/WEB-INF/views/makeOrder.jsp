<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="order" cssClass="form-horizontal">
    <div class="form-group">
        <label for="requiredDate" class="col-sm-2 control-label">Required Date:</label>
        <div class="col-sm-10">
            <form:input path="requiredDate" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="shipAddress" class="col-sm-2 control-label">Ship Address:</label>
        <div class="col-sm-10">
            <form:input path="shipAddress" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="shipCity" class="col-sm-2 control-label">Ship City:</label>
        <div class="col-sm-10">
            <form:input path="shipCity" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="shipCountry" class="col-sm-2 control-label">Ship Country:</label>
        <div class="col-sm-10">
            <form:input path="shipCountry" cssClass="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-primary" value="Save Order"/>
            <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                Add Details
            </button>--%>
        </div>
    </div>
</form:form>
<%--
<form:form commandName="orderDetails" cssClass="form-horizontal">
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
                        <label for="unitPrice" class="col-sm-2 control-label">Unit Price:</label>
                        <div class="col-sm-10">
                            <form:input path="unitPrice" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-2 control-label">Quantity:</label>
                        <div class="col-sm-10">
                            <form:input path="quantity" cssClass="form-control"/>
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
</form:form>--%>
