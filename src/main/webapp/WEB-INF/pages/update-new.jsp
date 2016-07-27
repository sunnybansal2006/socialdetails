<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>New Update page</title>
</head>

<body>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<h1>New Update page</h1>
<form:form method="POST" commandName="update" action="${pageContext.request.contextPath}/update/create.html" >
<table>
<tbody>
<tr>
<td>Name:</td>
<td><form:input path="name" /></td>
<td><form:errors path="name" cssStyle="color: red;"/></td>
</tr>
<tr>

<td>Email Id:</td>
<td><form:input path="email" /></td>
<td><form:errors path="email" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Mobile Number:</td>
<td><form:input path="mobilenumber" /></td>
<td><form:errors path="mobilenumber" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Sex:</td>
<td><form:input path="sex" /></td>
<td><form:errors path="sex" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Location:</td>
<td><form:input path="location" /></td>
<td><form:errors path="location" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>