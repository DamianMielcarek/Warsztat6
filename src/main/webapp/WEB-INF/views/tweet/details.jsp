<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <td><c:out value="${tweet.text}"/></td>
        <td><c:out value="${tweet.created}"/></td>
        <td><c:out value="${tweet.user.username}"/></td>
    </tr>
</table>

</body>
</html>
