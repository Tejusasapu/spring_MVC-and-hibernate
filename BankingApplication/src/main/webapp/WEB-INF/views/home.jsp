<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HCL BANKING APPLICATION</title>
<style type="text/css">
a {
	align-content: center;
}
</style>
</head>
<body>
<marquee>
<h3 style="color: aqua;"> <i>HCL ONLINE BANKING APPLICATION</i></h3>
</marquee>
<h2>Hi, ${sessionScope.user.roles[0]}</h2>  <br>

<c:if test="${sessionScope.user.roles[0] == 'Admin'}">
	<a href="showaccounts">showAllAccounts</a><br>
	<a href="transfer">Transfer Money</a><br>
	<a href="withdraw">Withdraw</a><br>
	<a href="deposit">deposit</a><br>
	<a href="addaccount"> Add New BankAccount </a> <br>
	<a href="showallusers">showAllUsers</a><br>
	<a href="addusers"> Add new User </a> <br>
	<a href="logout"> Logout </a>
</c:if>

<c:if test="${sessionScope.user.roles[0] == 'Manager'}">
	
	<a href="transfer">Transfer Money</a><br>
	<a href="withdraw">Withdraw</a><br>
	<a href="deposit">deposit</a><br>
	<a href="logout"> Logout </a>
</c:if>

<c:if test="${sessionScope.user.roles[0] == 'Clerk'}">
	<a href="showaccounts">showAllAccounts</a><br>
	<a href="showalltransactions">allTransactions</a><br>
	<a href="logout"> Logout </a>
</c:if>
</body>
</html>