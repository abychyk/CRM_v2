<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<h1>Product Listing</h1>
<c:if test="${not empty products}">
    <table class="table table-bordered table-responsive table-hover table-striped">
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Code</th>
            <th>Default Price</th>
            <th>Actions</th>
            <%--<security:authorize access="hasRole('ROLE_CEO')">
                <th>Actions</th>
            </security:authorize>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.productCode}</td>
                <td>${product.defaultPrice}</td>
                <td>
                    <a href="<c:url value="/products/buy/${product.id}"/>" class="glyphicon glyphicon-plus"></a>
                </td>
                <%--<td>
                    <a href="<c:url value="/company/${hostCompany.id}/products/remove/${product.id}"/>" class="glyphicon glyphicon-remove"></a>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
