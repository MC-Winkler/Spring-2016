<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Rental Location Input Form</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/registerrental" commandName="rentalLocation">

<table>

<tr><td>Name: </td><td><sf:input path="name" name="name" type="text"/><br/><sf:errors path="name" cssClass="error"></sf:errors></td></tr>
<tr><td>Address 1: </td><td><sf:input path="address1" name="address1" type="text"/><br/><sf:errors path="address1" cssClass="error"></sf:errors></td></tr>
<tr><td>Address 2: </td><td><sf:input path="address2" name="address2"></sf:input><br/><sf:errors path="address2" cssClass="error"></sf:errors></td></tr>
<tr><td>City: </td><td><sf:input path="city" name="city"></sf:input><br/><sf:errors path="city" cssClass="error"></sf:errors></td></tr>
<tr><td>State: </td><td><sf:input path="state" name="state"></sf:input><br/><sf:errors path="state" cssClass="error"></sf:errors></td></tr>
<tr><td>Zip Code: </td><td><sf:input path="postalCode" name="postalCode"></sf:input><br/><sf:errors path="postalCode" cssClass="error"></sf:errors></td></tr>

<tr><td></td><td><input class="control" value="Add Rental Location" type="submit"/></td></tr>

</table>

</sf:form></body>
</html>