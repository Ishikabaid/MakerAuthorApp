<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Customer Details</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand mx-5" href="showall">Home</a>
<c:url var="logout" value="/logout"></c:url>
<form:form action="logout" method ="post" class="form-inline my-2 my-lg-0" style="margin-left:1000px;">
    <input type="submit" value="logout" class="btn btn-dark">
</form:form>
</nav>

<h3 class="mt-3 d-flex justify-content-center">Customer Details</h3>
<div class="container w-50">
<div class="mt-5 d-flex justify-content-center border border-secondary ">
<p>
<b class="mx-1">Customer id : </b> ${customer.customerId}<br/>
<b class="mx-1">Customer code : </b> ${customer.customerCode} <br/>
<b class="mx-1">Customer name : </b> ${customer.customerName}<br/>
<b class="mx-1">Primary address : </b> ${customer.customerAddress1}<br/>
<b class="mx-1">Secondary address : </b> ${customer.customerAddress2}<br/>
<b class="mx-1">Pincode : </b> ${customer.customerPincode}<br/>
<b class="mx-1">Customer email : </b> ${customer.customerEmail}<br/>
<b class="mx-1">Contact Number : </b> ${customer.contactNumber}<br/>
<b class="mx-1">Contact Person : </b> ${customer.primaryContactPerson}<br/>
<b class="mx-1">Record Status : </b> ${customer.recordStatus}<br/>
<b class="mx-1">Active/Inactive : </b> ${customer.activeInactiveFlag}<br/>
<b class="mx-1">Create Date : </b> ${customer.createDate}<br/>
<b class="mx-1">Created By : </b> ${customer.createdBy}<br/>
<b class="mx-1">Modified Date : </b> ${customer.modifiedDate}<br/>
<b class="mx-1">Modified By : </b> ${customer.modifiedBy}<br/>
<b class="mx-1">Authorized Date : </b> ${customer.authorizedDate}<br/>
<b class="mx-1">Authorized By : </b> ${customer.authorizedBy}<br/>
</p>
</div>
</div>
</body>
</html>