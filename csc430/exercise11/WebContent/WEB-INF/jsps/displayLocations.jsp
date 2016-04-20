<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css"
  rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
  <table>
    <tr>
      <td>ID</td>
      <td>Name</td>
      <td>Address 1</td>
      <td>Address 2</td>
      <td>City</td>
      <td>State</td>
      <td>Zip code</td>
    </tr>
    <c:forEach var="rentalLocation" items="${rentalList}">
      <tr>
        <td><c:out value="${rentalLocation.rentalLocationId}"></c:out></td>
        <td><c:out value="${rentalLocation.name}"></c:out></td>
        <td><c:out value="${rentalLocation.address1}"></c:out></td>
        <td><c:out value="${rentalLocation.address2}"></c:out></td>
        <td><c:out value="${rentalLocation.city}"></c:out></td>
        <td><c:out value="${rentalLocation.state}"></c:out></td>
        <td><c:out value="${rentalLocation.postalCode}"></c:out></td>
      <tr>
    </c:forEach>
  </table>

  <a href="${pageContext.request.contextPath}/createrental">Add
    Rental Location</a>
<sec:authorize access="isAuthenticated()">

  <c:url var="logoutUrl" value="/logout" />
  <form action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" /> <input type="hidden"
      name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
 </sec:authorize>
</body>
</html>