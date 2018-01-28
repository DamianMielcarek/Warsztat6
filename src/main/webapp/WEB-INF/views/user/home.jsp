<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>HOME</title>
</head>
<body>


<h2><a href="<c:url value="/user/me" />">User's site</a></h2>

<f:form action="/" method="post" modelAttribute="tweet">
    <div>
        text: <f:textarea path="text"/><f:errors path="text" cssClass="error"/>
        <f:hidden path="user.id" value="${user.id}"/><f:errors path="user.id" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="Add tweet"/>
    </div>
</f:form>


<h2>Tweets list</h2>

<table>
    <tr>
        <th>text</th>
        <th>created</th>
        <th>username</th>
        <th>details</th>
    </tr>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
            <td><a href="<c:url value="/user/show?id=${tweet.user.id}"/>">${tweet.user.username}</a></td>
            <td><a href="<c:url value="/tweet/details/${tweet.id}"/>">more</a></td>
        </tr>
    </c:forEach>
</table>

<p><a href="<c:url value="/user/logout" />">Log Out</a></p>


</body>
</html>