<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>My tweets</title>
</head>
<body>


<a href="<c:url value="/message/showMessages"/>">My messages</a>

<h2>My tweets</h2>

<table>
    <tr>
        <th>text</th>
        <th>created</th>
    </tr>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>