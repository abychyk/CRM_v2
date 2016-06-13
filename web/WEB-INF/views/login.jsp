<%--
  Created by IntelliJ IDEA.
  User: abychik
  Date: 11.06.2016
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/taglib.jsp"%>
<link href="<c:url value="/resources/styles/signin.css" />" rel="stylesheet"/>

<div class="container">

    <form class="form-signin" action="${loginUrl}" method="post" >
        <h2 class="form-signin-heading">Please login</h2>
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Invalid email or password</p>
                <p>Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
        <label for="username" class="sr-only">Email address</label>
        <input type="text" id="username" name="ssoId" class="form-control" placeholder="Email" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <%--<div class="checkbox">
            <label>
                <input type="checkbox" id="remember" name="_spring_security_remember-me" value="true"> Remember me
            </label>
        </div>--%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>

</div> <!-- /container -->
