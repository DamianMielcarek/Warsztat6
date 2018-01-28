<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Messages</title>
    <style>

    </style>
</head>
<body>

<h2>${username} messages:</h2>

<h3>Received</h3>
<table>
    <c:forEach items="${receivedMessages}" var="message">
        <tr>
            <td>${message.sent}</td>


            <td><a href="<c:url value="/user/show?id=${message.sender.id}"/>">${message.sender.username}</a></td>

            <td>
                <c:if test="${message.seen == true}">
                    seen
                </c:if>
                <c:if test="${message.seen == false}">
                    NEW
                </c:if>
            </td>
            <td><a href="<c:url value="/message/show?id=${message.id}"/>">${message.content}</a></td>
        </tr>
    </c:forEach>
</table>

<h3>Sent</h3>
<table>
    <c:forEach items="${sentMessages}" var="message">
        <tr>
            <td>${message.sent}</td>
            <td><a href="<c:url value="/user/show?id=${message.receiver.id}"/>">${message.receiver.username}</a></td>
            <td><a href="<c:url value="/message/show?id=${message.id}"/>">${message.content}</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>