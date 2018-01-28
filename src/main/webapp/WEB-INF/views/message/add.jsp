<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>New message</title>
    <style type="text/css">
        .error {
            background-color: red;
            color: white;
        }
    </style>
</head>
<body>


<f:form action="add" method="post" modelAttribute="message">
    <div>
        New message: <f:input path="content"/><f:errors path="content" cssClass="error"/>
        <f:hidden value="${receiver.getId()}" path="receiver.id"/>
        <f:hidden value="${user.getId()}" path="sender.id"/>
    </div>
    <div>
        <input type="submit" value="Send"/>
    </div>
</f:form>


</body>
</html>