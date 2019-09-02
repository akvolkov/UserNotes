<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes</title>
</head>
<body>
    <div>
        <c:url var="logout" value="/logout" />
        <form action="${logout}" method="post">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
    <h2>Notes</h2>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Ava</th>
            <th>Author</th>
            <th>Title</th>
            <th>action</th>
        </tr>
        <c:forEach var="note" items="${notesList}">
            <tr>
                <td>${note.id}</td>
                <td><img src="${map.get(note.author)}" width="20" height="20"></td>
                <td>${note.author}</td>
                <td>
                    <a href="description/${note.id}">${note.title}</a>
                </td>
                <td>
                    <a href="edit/${note.id}">edit</a>
                    <a href="delete/${note.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2></h2>
    <a href="add">Add new note</a>
    <h2></h2>
    <c:url var="findByTitle" value="/findByTitle" />
    <form action="${findByTitle}" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <label for="title">Title</label>
        <input type="text" name="title" id="title">
        <input type="submit" value="Find"/>
    </form>
</body>
</html>
