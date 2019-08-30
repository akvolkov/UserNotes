<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 30.08.2019
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table border="1">
        <tr>
            <td>Id</td>
            <td>${note.id}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td>${note.title}</td>
        </tr>
        <tr>
            <td>Author</td>
            <td>${note.author}</td>
        </tr>
        <tr>
            <td>description</td>
            <td>${note.description}</td>
        </tr>
    </table>
</body>
</html>
