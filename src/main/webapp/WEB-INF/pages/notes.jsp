<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes</title>
</head>
<body>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
    <h2>Notes</h2>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Author</th>
            <th>Title</th>
            <th>action</th>
        </tr>
        <c:forEach var="note" items="${notesList}">
            <tr>
                <td>${note.id}</td>
                <td>${note.author}</td>
                <td>
                    <a href="/description/${note.id}">${note.title}</a>
                </td>
                <td>
                    <a href="/edit/${note.id}">edit</a>
                    <a href="/delete/${note.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/add" var="add"/>
    <a href="${add}">Add new note</a>
    <form action="/findByTitle" method="post">
        <label for="title">Title</label>
        <input type="text" name="title" id="title">
        <input type="submit" value="Find"/>
    </form>
</body>
</html>
