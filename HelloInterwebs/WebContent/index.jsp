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
	<form>
		<label for="txtVotlage">Voltage</label><input name="txtVoltage"
			type="number" min="0.01" step="0.01" required /> <label
			for="txtResistance">Resistance</label><input name="txtResistance"
			type="number" min="0.01" step="0.01" required /> <input
			type="submit" value="Calculate Amperage" name="cadSubmit" />

		<%
			if (request.getParameter("cadSubmit") != null) {
				Circuit myCircuit = new Circuit();

				myCircuit.setVoltage(Double.parseDouble(request.getParameter("txtVoltage")));
				myCircuit.setResistance(Double.parseDouble(request.getParameter("txtResistance")));

				out.println("The amperage is " + myCircuit.getAmperage());
			}
		%>
	</form>
</body>
</html>
