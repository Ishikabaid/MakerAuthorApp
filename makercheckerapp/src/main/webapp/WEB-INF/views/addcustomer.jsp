<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Add Customer</title>
<style>
.error {
color: #EF1313;
font-style: italic;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand mx-5" href="showall">Home</a>
<c:url var="logout" value="/logout"></c:url>
<form:form action="logout" method ="post" class="form-inline my-2 my-lg-0" style="margin-left:1000px;">
    <input type="submit" value="logout" class="btn btn-dark">
</form:form>
</nav>
<div class="w-50 ml-0 mr-0 mx-auto">
<h3 class="mt-3 col-md-10 text-center">Add Customer</h3>
<form:form action="addCustomer" method="post" modelAttribute="customer">
<form:hidden path="customerId"/>
	<div class="mt-3 col-md-10">
	Customer Code:<form:input path="customerCode" class="form-control"/><form:errors path="customerCode" class="error"/>
	</div>
	<div class="col-md-10">
	Customer Name:<form:input path="customerName" class="form-control"/><form:errors path="customerName" class="error"/>
	</div>
	<div class="col-md-10">
	Address 1:<form:textarea path="customerAddress1" class="form-control"/><form:errors path="customerAddress1" class="error" />
	</div>
	<div class="col-md-10">
	Address 2:<form:textarea path="customerAddress2" class="form-control"/>
	</div>
	<div class="col-md-10">
	Pin Code:<form:input path="customerPincode" class="form-control"/><form:errors path="customerPincode" class="error"/>
	</div>
	<div class="col-md-10">
	Email Address:<form:input path="customerEmail" class="form-control"/><form:errors path="customerEmail" class="error"/>
	</div>
	<div class="col-md-10">
	Contact Number:<form:input path="contactNumber" class="form-control"/><form:errors path="contactNumber" class="error"/>
	</div>
	<div class="col-md-10">
	Contact Person:<form:input path="primaryContactPerson" class="form-control"/><form:errors path="primaryContactPerson" class="error"/>
    </div>
    <div class="col-md-10">
    Active/Inactive Flag:<form:input path="activeInactiveFlag" class="form-control"/><form:errors path="activeInactiveFlag" class="error"/><br/>
	</div>
	<div class="col-md-10 text-center">
	<input type ="submit" class="btn btn-success"/>
	</div>
</form:form>
</div>
</body>
</html>