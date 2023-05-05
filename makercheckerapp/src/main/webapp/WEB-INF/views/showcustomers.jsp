<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.makercheckerapp.model.dao.entities.CustomerMaster"%>
<%@page import="com.makercheckerapp.model.dao.entities.CustomerTemp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
<script>
    $(document).ready( function () {
        $('#makertable').DataTable();
    } );
</script>
<title>Bank app</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand mx-5" href="#">Hey <sec:authentication property="principal.username"/>!</a>
<a class="navbar-brand ml-5" href="addCustomer">Add Customer</a>
<c:url var="logout" value="/logout"></c:url>
<form:form action="logout" method ="post" class="form-inline my-2 my-lg-0" style="margin-left:800px;">
    <input type="submit" value="logout" class="btn btn-dark">
</form:form>
</nav>

<div class="container mt-5">
<table id="makertable" border=1>
    <thead>
    <tr>
        <th>Customer Id</th>
        <th>Customer Code</th>
        <th>Customer Name</th>
        <th>Customer Address</th>
        <th>Customer Email</th>
        <th>Contact Number</th>
        <th>Status</th>
        <th>Update</th>
        <th>Delete</th>
        <th>View Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customerId} </td>
            <td>${customer.customerCode} </td>
            <td>${customer.customerName} </td>
            <td>${customer.customerAddress1} </td>
            <td>${customer.customerEmail} </td>
            <td>${customer.contactNumber} </td>
            <td>${customer.recordStatus} </td>
            <td><a href="updatecustomer?customerId=${customer.customerId}" class="btn btn-info">update</a></td>
            <td><a href="delete?customerId=${customer.customerId}" class="btn btn-danger">delete</a></td>
            <td><a href="showcustomer?customerCode=${customer.customerCode}" class="btn btn-success">view</a></td>
        </tr>
    </c:forEach>
     <c:forEach items="${customersmaster}" var="customer">
            <tr>
                <td>${customer.customerId} </td>
                <td>${customer.customerCode} </td>
                <td>${customer.customerName} </td>
                <td>${customer.customerAddress1} </td>
                <td>${customer.customerEmail} </td>
                <td>${customer.contactNumber} </td>
                <td>${customer.recordStatus} </td>
                <td><a href="updatecustomermaster?customerCode=${customer.customerCode}" class="btn btn-info">update</a></td>
                <td><a href="deletecustomermaster?customerCode=${customer.customerCode}" class="btn btn-danger">delete</a></td>
                <td><a href="showcustomermaster?customerCode=${customer.customerCode}" class="btn btn-success">view</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

</body>
</html>