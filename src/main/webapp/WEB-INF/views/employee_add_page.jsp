<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.04.2018
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <title>CHECK-IN</title>
</head>
<body style="font-family:'Roboto Slab'">

<h3>welcome, ${applicationScope.username}</h3>

<form action="/quit" method="post"><input type="submit" value="Quit"/></form>

<hr/>

<c:set var="departmentTitle" value="${param.departmentTitle}" scope="page"/>
<c:set var="departmentId" value="${param.departmentId}" scope="page"/>
<c:set var="newEmployee" value="" />

<h1>DEPARTMENT of <c:out value="${departmentTitle}" /></h1>
<hr/>

<form:form action="/employees" method="post" commandName="newEmployee">

    <input name="command" type="hidden" value="employeeAdd">
    <form:input path="department" type="hidden" value="${departmentId}"/>
    <input name="departmentTitle" type="hidden" value="${departmentTitle}"/>

    <table border=2 cellpadding=10>
        <th bgcolor="#999966" colspan=2>
            <c:choose>
                <c:when test="${(requestScope.responseMessages.get(\"NEW_EMPLOYEE_SAVE_SUCCESS_MESSAGE\") != null)}">
                    <p style="color:green">
                        <c:out value="${requestScope.responseMessages.get(\"NEW_EMPLOYEE_SAVE_SUCCESS_MESSAGE\")}"/>
                    </p>
                </c:when>
                <c:otherwise>
                    <p><sup>*</sup>EMPLOYEE CHECK-IN</p>
                </c:otherwise>
            </c:choose>
        </th>
        <tr>
            <td valign=top style="width:200px">
                <b>First Name<sup>*</sup></b>
                <br>
                <form:input  type="text"
                             path="firstName"
                       pattern="[A-Za-z]+"
                       title="First Name can contain letters only!"
                       size="15" maxlength="20"
                />
            </td>
            <td valign=top style="width:200px">
                <b>Last Name<sup>*</sup></b>
                <br>
                <form:input type="text"
                       path="lastName"
                       pattern="[A-Za-z]+"
                       title="Last Name can contain letters only!"
                            size="15" maxlength="20"
                        />
            </td>
        </tr>
        <tr>
            <td valign=top colspan="2">
                <b>Date of Birth<sup>*</sup></b>
                <br>
                <form:input type="date"
                       path="birthDate"
                       min="${requestScope.minDate}" max="${requestScope.maxDate}"
                       />
                <br></td>
        </tr>
        <tr>
            <td valign=top colspan="2">
                <b>E-mail (as login)<sup>*</sup></b>
                <br>
                <form:input type="text"
                       path="login"
                       placeholder="my@mail.dot.com"
                       size="25" maxlength="125"
                 />
                <br>
                <c:if test="${(requestScope.responseMessages.get(\"LOGIN_SAVE_PROBLEM_MESSAGE\") != null)}" >
                    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"LOGIN_SAVE_PROBLEM_MESSAGE\")}"/></p>
                </c:if>
                <c:if test="${(requestScope.responseMessages.get(\"INVALID_EMAIL_MESSAGE\") != null)}" >
                    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"INVALID_EMAIL_MESSAGE\")}"/></p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td valign=top>
                <b>Password<sup>*</sup></b>
                <br>
                <form:input type="password"
                       path="pass"
                       size="10"
                       maxlength="10"
                        />
            </td>
            <td valign=top>
                <b>Confirm Password<sup>*</sup></b>
                <br>
                <form:input type="password"
                            path="pass2"
                            size="10"
                            maxlength="10"
                />

                <br>
                <c:if test="${(requestScope.responseMessages.get(\"FAILED_PASS_CONFIRMATION_MESSAGE\") != null)}" >
                    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"FAILED_PASS_CONFIRMATION_MESSAGE\")}"/></p>
                </c:if>

            </td>
            <br>
        </tr>
        <tr>
            <td align=center bgcolor="#99ff33">
                <input type="submit" value="Submit">
            <td align=center bgcolor="#cc3300">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form:form>
<hr/>

<%--
<c:forEach var="mess" items="${MessageManager.responseMessages.split(\"#\")}">
    <h3><c:out value="${mess}"/></h3>
</c:forEach>
--%>

<form action="/employees" method="post">
    <input name="command" type="hidden" value="departmentList">
    <input name="departmentId" type="hidden" value="${departmentId}"/>
    <input name="departmentTitle" type="hidden" value="${departmentTitle}"/>
    <input type="submit" value="<- Back to Department page"/>

   <%-- <% responseMessages = ""; %>--%>

</form>
</body>
</html>
