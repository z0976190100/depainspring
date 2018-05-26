<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <title>DEPS</title>
</head>
<body style="font-family:'Roboto Slab'">

<c:if test="${not empty requestScope.user}">
    <c:set var="username" value="${requestScope.user}" scope="application"/>
</c:if>

<c:set var="deppList" value="${requestScope.departmentsList}" />

<h3>welcome, ${username}</h3>

<form action="/quit" method="post"><input type="submit" value="Quit"/></form>

<hr/>

<h1>DEPARTMENTS</h1>

<span></span>

<table border="2" cellpadding="5">
    <tr bgcolor="#999966">
        <th>Title</th>
        <th>Employees</th>
        <th colspan="3">Actions</th>
    </tr>

            <c:if test="${empty deppList}">
    <tr>
        <td colspan="5">
            <c:out value="No Departments yet... Bad..."/>
        </td>
    </tr>
    </c:if>

    <c:forEach var="depp" items="${deppList}">
        <tr>
            <td><c:out value="${depp.title}"/></td>
            <td>
           <c:out value="${depp.employeeNumber}"/>
            </td>
            <td bgcolor="#99ff33">
                <form action="/employees/${depp.id}" method="get">
                    <input name="command" type="hidden" value="employeesList"/>
                    <input name="departmentId" type="hidden" value="${depp.id}"/>
                    <input name="departmentTitle" type="hidden" value="${depp.title}"/>
                    <input type="submit" value="Employees list"/>
                </form>
            </td>
            <td bgcolor="#99ff33">
                <form action="/departments/department_update_page" method="get">
                    <input name="command" type="hidden" value="departmentUpdate"/>
                    <input name="departmentId" type="hidden" value="${depp.id}"/>
                    <input name="departmentTitle" type="hidden" value="${depp.title}"/>
                    <input type="submit" value="Rename"/>
                </form>
            </td>
            <td bgcolor="#cc3300">
                <form action="/departments/delete/${depp.id}" method="post">
                    <input name="command" type="hidden" value="departmentDelete"/>
                    <%--<input name="departmentId" type="hidden" value="${depp.id}"/>--%>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<hr/>
<c:if test="${(requestScope.responseMessages.get(\"EMPTY_FIELD_MESSAGE\") != null)}" >
    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"EMPTY_FIELD_MESSAGE\")}"/></p>
</c:if>
<c:if test="${(requestScope.responseMessages.get(\"DEPTITLE_SAVE_PROBLEM_MESSAGE\") != null)}" >
    <p style="color:red"><c:out value="${requestScope.responseMessages.get(\"DEPTITLE_SAVE_PROBLEM_MESSAGE\")}"/></p>
</c:if>
<c:if test="${(requestScope.responseMessages.get(\"NEW_DEP_SAVE_SUCCESS_MESSAGE\") != null)}" >
    <p style="color:green"><c:out value="${requestScope.responseMessages.get(\"NEW_DEP_SAVE_SUCCESS_MESSAGE\")}"/></p>
</c:if>
<c:if test="${(requestScope.responseMessages.get(\"DEP_RECORD_UPDATE_SUCCESS_MESSAGE\") != null)}" >
    <p style="color:green"><c:out value="${requestScope.responseMessages.get(\"DEP_RECORD_UPDATE_SUCCESS_MESSAGE\")}"/></p>
</c:if>
<table>
    <tr>
        <td>
            <form action="/departments" method="post">
                <input name="command" type="hidden" value="departmentAdd"/>
                <input name="newDepartmentTitle" placeholder="New DEPARTMENT Title"
                       value="${requestScope.depTitleInputValue}"/>
                <input type="submit" value="Add new Department"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>