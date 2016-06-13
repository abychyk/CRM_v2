<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 13.06.2016
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
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
                                <tr>
                                    <td>Address</td>
                                    <td>
                                        <c:forEach items="${company.addressSet}" var="address">
                                            ${address.zip}, ${address.country}, ${address.city}, ${address.street} ${address.buildingNumber}
                                            <br/>
                                        </c:forEach>
                                    </td>
                                </tr>
                                <td>Phone Number</td>
                                <td>${company.phone}</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="<c:url value="/company/${company.id}/products/"/>" class="btn btn-primary">Products</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>