<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <title>deppage</title>

</head>
<body style="font-family:'Roboto Slab'">

<h3>welcome, ${applicationScope.username}</h3>

<form action="/quit" method="post"><input type="submit" value="Quit"/></form>

<hr/>

<c:set var="departmentTitle" value="${param.departmentTitle}" scope="page" />
<c:set var="departmentId" value="${param.departmentId}" scope="page" />
<c:set var="employeesList" value="${requestScope.employeesList}" />

<h1>DEPARTMENT of <c:out value="${departmentTitle}" /></h1>
<h3>EMPLOYEES</h3>
<form action="/employees/add_form" method="get" style="font-family:'Roboto Slab'">
    <input name="command" type="hidden" value="employeeAdd">
    <input name="departmentId" type="hidden" value="${departmentId}" />
    <input name="departmentTitle" type="hidden" value="${departmentTitle}" />
    <input type="submit" value="Add new Employee"/>
</form>
<br/>

<table border="2" cellpadding="5">
    <tr bgcolor="#999966">
        <th>First name</th>
        <th>Last name</th>
        <th>login</th>
        <th>pass</th>
        <th>date</th>
        <th colspan="3">Actions</th>
    </tr>
    <c:if test="${empty employeesList}">
        <tr>
            <td colspan="8">
        <c:out value="Noone to get fired yet... Sad...Add a looser."/>
            </td>
        </tr>
    </c:if>

<c:forEach var="employee" items="${employeesList}">

    <tr>
        <td><c:out value="${employee.firstName}" /></td>
        <td><c:out value="${employee.lastName}" /></td>
        <td><c:out value="${employee.login}" /></td>
        <td><c:out value="${employee.pass}" /></td>
        <td><c:out value="${employee.birthDate}" /></td>
        <td bgcolor="#99ff33">
            <form action="/employees/employee_update_page.jsp" method="post">
                <input name="command" type="hidden" value="employeeUpdate" />
                <input name="empid" type="hidden" value="${employee.id}" />
                <input name="empfname" type="hidden" value="${employee.firstName}" />
                <input name="emplname" type="hidden" value="${employee.lastName}" />
                <input name="emplogin" type="hidden" value="${employee.login}" />
                <input name="emppass" type="hidden" value="${employee.pass}" />
                <input name="birthDate" type="hidden" value="${employee.birthDate}" />
                <input name="departmentId" type="hidden" value="${departmentId}" />
                <input name="departmentTitle" type="hidden" value="${departmentTitle}" />
                <input type="submit" value="Edit" />
            </form>
        </td>

        <td bgcolor="#cc3300">
            <form action="/employeedelete" method="post">
                <input name="command" type="hidden" value="employeeDelete" />
                <input name="empid" type="hidden" value="${employee.id}" />
                <input name="departmentId" type="hidden" value="${departmentId}" />
                <input name="departmentTitle" type="hidden" value="${departmentTitle}"  />
                <input type="submit" value="Delete" />
            </form>
        </td>
    </tr>
</c:forEach>
</table>

<hr/>

<form action="/departments" method="GET">
    <input name="command" type="hidden" value="departmentList" />
    <input type="submit" value="<- Back to Main page"/>
</form>

</body>
</html>
