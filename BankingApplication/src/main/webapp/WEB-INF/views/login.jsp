<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<style>
.error {
	color: red;
}
</style>
</style>
</head>
<body>
<h1>Login</h1>

<form:form action="login" method="post" modelAttribute="userBean">
		<table>
			<tr>
				<td>Enter User Name:</td>
				<td><form:input path="username"/><form:errors path="username" class="error"/></td>
			</tr>
			
			<tr>
				<td>Enter password:</td>
				<td><form:input type="password" path="password"/><form:errors path="password" class="error"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="login"> </td>				
			</tr>
		</table>
	</form:form>
</form>

</body>
</html>