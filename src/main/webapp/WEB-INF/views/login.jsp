

<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <title>login page</title>
</head>
<body style="font-family:'Roboto Slab'">

<h2>login to start</h2>

<hr/>

<form:form name="login" method="POST" action="/login">
    Login:<br/>
    <input type="email" name="username" placeholder="my@email.dot.com" value="" required /><br/>
    Password:<br/>
    <input type="password" name="password" value="" required /><br/>
    <input type="submit" value="Start">
</form:form>

<c:if test="${(param.error) != null}">
<p>auth error</p>
</c:if>
<c:if test="${(requestScope.responseMessages.get(\"LOGIN_PASSWORD_PROBLEM_MESSAGE\") != null)}" >
    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"LOGIN_PASSWORD_PROBLEM_MESSAGE\")}"/></p>
</c:if>

</body>
</html>
