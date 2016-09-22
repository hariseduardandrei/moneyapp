<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add expense</title>
</head>
<body>
	You are now adding a new expense.
	<br>
	<br>
	<form action="/addedExpense" method="POST">
		Please add name:<br> <input type="text" name="name"><br>
		Please add date:<br> <input type="date" name="date"><br>
		Please add cost:<br> <input type="number" name="singleCost"><br>
		Please add number of purchases:<br> <input type="number"
			name="pcs"><br> Please add description:<br>
		<textarea name="description" rows="4" cols="50"></textarea>
		<br> <br> <br>
		<button type="submit">Add</button>
	</form>

</body>
</html>