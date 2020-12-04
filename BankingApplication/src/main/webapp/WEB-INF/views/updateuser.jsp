<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new User</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<form:form action="updateuser" method="post" modelAttribute="updateUsertBean">
	<form:hidden path="uId"/>
	<table>
		<tr>
			<td>Enter UserName</td>
			<td><form:input path="username"  readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><form:input path="password" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter Role</td>
			<td><form:input path="roles"/><form:errors path="roles" class="error"/> </td>
		</tr>
		<tr>
			<td>Enter Phone</td>
			<td><form:input path="phone" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter Address</td>
			<td><form:input path="address" /><form:errors path="address" class="error"/></td>
		</tr>
		<tr>
			<td>Enter Email</td>
			<td><form:input path="email" readonly="true"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="update User"></td>
		</tr>
	</table>
</form:form>
</body>
</html>