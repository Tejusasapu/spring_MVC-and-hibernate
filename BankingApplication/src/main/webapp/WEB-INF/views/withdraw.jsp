<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HCL Internal Bank Application</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<form:form action="withdraw" method="post" modelAttribute="withdrawbean">
	<table>
		<tr>
			<td>Enter Account:</td>
			<td><form:input path="accountId"/><form:errors path="accountId" class="error"/></td>
		</tr>
		
		<tr>
			<td>Enter Amount:</td>
			<td><form:input path="amount"/><form:errors path="amount" class="error"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="withdraw"></td>
		</tr>
	</table>
</form:form>
</body>
</html>