<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Message</title>
</head>
<body>


<div>
    ${message.sent}
</div>
<div>
    <c:choose>
        <c:when test="${user.id == message.sender.id}">
            I wrote to:
            <a href="<c:url value="/user/show?id=${message.receiver.id}"/>">${message.receiver.username}</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value="/user/show?id=${message.sender.id}"/>">${message.sender.username}</a>
            wrote:
        </c:otherwise>
    </c:choose>
</div>
<div>
    ${message.content}
</div>


</body>
</html>