<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>Login Page</h2>
    <c:url var="login" value="/login" />
    <form action="${login}" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
    <a href="registration">Add new user</a>
</body>
</html>
