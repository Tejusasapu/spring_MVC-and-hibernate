<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hcl bookstore app</title>
<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body>
<table>
    <thead>
        <tr>
            <th>AccountId</th>
            <th>Name</th>
            <th>AadharNumber</th>
            <th>PanNumber</th>
            <th>AccountType</th>
            <th>phone</th>
            <th>email</th>
            <th>address</th>
            <th>update</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td>${account.accountId}</td>
                <td>${account.name}</td>
                <td>${account.aadharNumber}</td>
                <td>${account.panNumber}</td>
                <td>${account.accountType}</td>
                <td>${account.phone}</td>
                <td>${account.email}</td>
                <td>${account.address}</td>
                <c:if test="${sessionScope.user.roles[0] == 'Admin'}">
                <td><a href="updateaccount?id=${account.accountId}">update Account</a></td>
                <td><a href="deleteaccount?id=${account.accountId}">delete Account</a></td>
                </c:if>
                
                <c:if test="${sessionScope.user.roles[0] == 'Clerk'}">
                 <td><a href="showtransactions?id=${account.accountId}">show transactions</a></td>
                 </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="home">home</a>
</body>
</html>