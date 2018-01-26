<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Tweet's details</title>
</head>
<body>

<h2>Tweet's details</h2>

<table>
    <tr>
        <th>text</th>
        <th>created</th>
        <th>username</th>
    </tr>
    <tr>
        <td><c:out value="${post.text}"/></td>
        <td><c:out value="${post.created}"/></td>
        <td><c:out value="${post.user.username}"/></td>
    </tr>
</table>

<h2>Comments</h2>

<table>
    <tr>
        <th>text</th>
        <th>created</th>
        <th>username</th>
    </tr>
    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.text}</td>
            <td>${comment.created}</td>
            <td>${comment.user.username}</td>
        </tr>
    </c:forEach>
</table>

<h3>Add new comment</h3>

<f:form method="post" modelAttribute="comment">
    <div>
        text: <f:textarea path="text"/><f:errors path="text" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Add comment"/>
    </div>
</f:form>

</body>
</html>
