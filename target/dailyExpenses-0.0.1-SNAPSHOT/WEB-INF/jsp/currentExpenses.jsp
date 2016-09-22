<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Current expenses are:
	<table>
		<TH>Id</th>
		<TH>Name</th>
		<TH>Date</th>
		<TH>Price</th>
		<TH>Pcs</th>
		<TH>Total price</th>
		<TH>Description</th>

		<c:forEach items="${expenseList}" var="anExpense">
			<tr>
				<td><c:out value="${anExpense.id}" /></td>
				<td><c:out value="${anExpense.name}" /></td>
				<td><c:out value="${anExpense.getStringDate()}" /></td>
				<td><c:out value="${anExpense.singleCost}" /></td>
				<td><c:out value="${anExpense.pcs}" /></td>
				<td><c:out value="${anExpense.singleCost * anExpense.pcs}" /></td>
				<td><c:out value="${anExpense.description}" /></td>
			</tr>	
		</c:forEach>
	</table>


</body>
</html>