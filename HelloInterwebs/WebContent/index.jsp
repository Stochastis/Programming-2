<%@page import="model.Circuit"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			type="number" min="0.01" step="0.01" required /> <label
			for="txtResistance">Resistance</label><input name="txtResistance"
			type="number" min="0.01" step="0.01" required /> <input
			type="submit" value="Calculate Amperage" name="cadSubmit" />


	</form>
	<%
		Circuit myCircuit = (Circuit) request.getAttribute("myCircuit");
		out.println("The amperage is " + myCircuit.getAmperage());
	%>
</body>
</html>
