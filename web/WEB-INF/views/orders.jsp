<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 14.06.2016
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<c:if test="${empty orders}">
    <h1>You have no orders</h1>
</c:if>
<c:if test="${not empty orders}">
    <h1>Order Listing</h1>
    <table class="table table-bordered table-responsive table-hover table-striped">
        <thead>
        <tr>
            <th>Order Date</th>
            <th>Required Date</th>
            <th>Ship Country</th>
            <th>Ship City</th>
            <th>Ship Address</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderDate}</td>
                <td>${order.requiredDate}</td>
                <td>${order.shipCountry}</td>
                <td>${order.shipCity}</td>
                <td>${order.shipAddress}</td>
                <td>
                    <a href="<c:url value="/orders/${order.id}"/>" class="glyphicon glyphicon-zoom-in"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${not empty orderDetails}">
        <h2>Order Detail</h2>
        <table class="table table-bordered table-responsive table-hover table-striped">
            <thead>
            <tr>
                <th>Unit Price</th>
                <th>Quantity</th>
                <th>Discount</th>
                <th>Product</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderDetails}" var="orderDetail">
                <tr>
                    <td>${orderDetail.unitPrice}</td>
                    <td>${orderDetail.quantity}</td>
                    <td>${orderDetail.discount}</td>
                    <td>${orderDetail.product.name}</td>
                    <%--<td>
                        <a href="<c:url value="/orders/${order.id}"/>" class="glyphicon glyphicon-zoom-in"></a>
                    </td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
