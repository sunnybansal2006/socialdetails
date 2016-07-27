 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Details List page</title>
</head>
<body>
<h1>Details List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="150px">name</th><th width="25px">email</th><th width="25px">mobilenumber</th><th width="50px">sex</th><th width="25px">location</th>
</tr>
</thead>
<tbody>
<c:forEach var="update" items="${updateList}">
<tr>

<td>${update.name}</td>
<td>${update.email}</td>
<td>${update.mobilenumber}</td>
<td>${update.sex}</td>
<td>${update.location}</td>

<td>
<a href="${pageContext.request.contextPath}/update/edit/${update.id}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/update/delete/${update.id}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html> 