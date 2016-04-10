<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="!isAuthenticated()">

<a  class="title" href="<c:url value="/"/>">Offers</a>

<c:url var="logoutUrl" value="/login" />
  <form class="login" action="${logoutUrl}" method="post">
    <input type="submit" value="Log in" /> <input type="hidden"
      name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<c:url var="logoutUrl" value="/logout" />
  <form class="login" action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" /> <input type="hidden"
      name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</sec:authorize>