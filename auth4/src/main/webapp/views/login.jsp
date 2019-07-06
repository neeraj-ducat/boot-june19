<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
<head>
<%@ include file="resources.jsp" %>
</head>
<body>
<div class="container">
<div class="row">
<c:if test="${param.error ne null}">
<h3 class="alert alert-danger">Either UserName or Password is invalid.</h3>
</c:if>
</div>
<div class="row">
<c:if test="${param.logout ne null}">
<h3 class="alert alert-success">You have successfully logged out.</h3>
</c:if>
</div>
<div class="row">
<form action="login" method="post" class="form form-horizontal">
<div class="form-group">
<label>UserName</label>
<input type="text" name="username" class="form-control">
</div>
<div class="form-group">
<label>Password</label>
<input type="password" name="password" class="form-control">
<input type="hidden" name="${_csrf.parameterName}" 
value="${_csrf.token}"/>
</div>
<div class="form-group">
<button type="submit" class="btn btn-primary">Login</button>
</div>
</form>
</div>
</div>
</body>
</html>