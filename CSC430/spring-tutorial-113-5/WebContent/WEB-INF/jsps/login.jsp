<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>
<head>
<title>Login Page</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body onload='document.f.username.focus();'>
  <h3>Login with Username and Password</h3>
  <c:url  value="/login"  var="loginUrl"/>
  
  <c:if test="${param.error != null}">
  
    <p class="error">
      Login failed. Check that your username and password are correct.
    </p>
  
  </c:if>
  
  <form action="${loginUrl}"  method="post">
    <table class="formtable">
      <tr>
        <td>User:</td>
        <td><input type='text' name='username' value=''></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
      <tr>
        <td>Remember me:</td>
        <td><input type='checkbox' name='remember-me' checked="checked" /></td>
      </tr>
      <tr>
        <td colspan='2'><input name="submit" type="submit"
          value="Login" /></td>
      </tr>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </table>
  </form>
  
  <p><a href="<c:url value='/newaccount'/>">Create new account</a>
</body>
</html>