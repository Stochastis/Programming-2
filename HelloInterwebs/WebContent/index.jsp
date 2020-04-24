<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Circuit Calculator</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>

	<h1>This will calculate amperage given voltage and resistance are
		known.</h1>
	<form method=post>
		<label for="txtVotlage">Voltage</label><input name="txtVoltage"
			type="number" min="0.01" step="0.01" required
			value="${myCircuit.getVoltage()}" /> <label for="txtResistance">Resistance</label><input
			name="txtResistance" type="number" min="0.01" step="0.01" required
			value="${myCircuit.getResistance()}" /> <input type="submit"
			value="Calculate Amperage" name="cadSubmit" />
		<c:if test="${myCircuit.getResistance() != 0}">
			<c:out value="The amperage is ${myCircuit.getAmperage()} amps" />
		</c:if>
	</form>
</body>
</html>
