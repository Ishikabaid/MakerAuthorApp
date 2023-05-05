<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<div class="w-50 ml-0 mr-0 mx-auto">
<c:if test="${param.error!=null }">
	<i>You have invalid username/password!</i>
</c:if>

<h3 class="mt-5 col-md-10 text-center">Welcome User</h3>
<c:url var="url" value="/authuser"></c:url>
<form:form action="${url}" method="Post">
    <div class="mb-2 mt-3 col-md-10">
	Email:<input type='text' name='email' class="form-control" placeholder="Enter registered Email"/><br/>
	  </div>
	   <div class="mb-3 col-md-10">
	Password:<input type='password' name='password' class="form-control" placeholder="Enter Password"/><br/>
	  </div>
	   <div class="col-md-10 text-center">
	<input name="submit" type="submit" value="Login" class="btn btn-primary"/>
	</div>
</form:form>
</div>

</body>
</html>