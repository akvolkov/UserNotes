<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
    <h2>Add new user</h2>
    <c:url var="registration" value = "/registration"/>
    <form action="${registration}" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <div><label> User Name : <input type="text" name="login"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</body>
</html>
