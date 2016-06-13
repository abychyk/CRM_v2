<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<h1>Buy Menu</h1>
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
            <td><a href="<spring:url value="/buy/${product.id}"/>">${product.name}</a></td>
            <td>${product.description}</td>
            <td>${product.productCode}</td>
            <td>${product.defaultPrice}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>