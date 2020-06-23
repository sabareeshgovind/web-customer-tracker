<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Customers</title>
<link type ="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>


<div id="wrapper">
<div id="header">
<h2>CRM-Customer Relationship Manager</h2>
</div>
</div>

<div id="container">
<div id ="content">

<input type="button" value="Add Customer" 
onClick="window.location.href='showFormForAdd';return false;" class ="add-button"/>

<!-- Add html table -->
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Action</th>
</tr>

<c:forEach var="tempCustomer" items = "${customers}">

<!-- construct an "update" link with customer id -->
<c:url var="updateLink" value="/customer/showFormForUpdate">
<c:param name="customerId" value="${tempCustomer.id}" />
</c:url>	

<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerId" value="${tempCustomer.id}" />
</c:url>	

<tr>
<td>${tempCustomer.firstName}</td>
<td>${tempCustomer.lastName}</td>
<td>${tempCustomer.email}</td>
<td>
<!-- display the update link -->
<a href="${updateLink}">Update</a>
<a href="${deleteLink}">Delete</a>
</td>
</tr>

</c:forEach>

</table>




</div>
</div>

</body>
</html>