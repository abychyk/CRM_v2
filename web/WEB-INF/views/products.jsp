<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<c:if test="${not empty products}">
    <h1>Products of company: ${products.get(0).company.name}</h1>
    <table class="table table-bordered table-responsive table-hover table-striped">
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Code</th>
            <th>Default Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.productCode}</td>
                <td>${product.defaultPrice}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        Add Product
    </button>
    <form:form commandName="product" cssClass="form-horizontal">
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Product Name:</label>
                            <div class="col-sm-10">
                                <form:input path="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="productCode" class="col-sm-2 control-label">Product Code:</label>
                            <div class="col-sm-10">
                                <form:input path="productCode" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="defaultPrice" class="col-sm-2 control-label">Default Price:</label>
                            <div class="col-sm-10">
                                <form:input path="defaultPrice" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-sm-2 control-label">Description:</label>
                            <div class="col-sm-10">
                                <form:textarea path="description" cssClass="form-control"/>
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
