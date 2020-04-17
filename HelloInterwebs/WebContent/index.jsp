<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Circuit Calculator</title>
</head>
<body>
	<h1>This will calculate amperage given voltage and resistance are
		known.</h1>
	<form>
		<label for=txtVotlage>Voltage</label><input name=txtVoltage
			type=number min=0.01 step=0.01 required> <label
			for=txtResistance>Resistance</label><input name=txtResistance
			type=number min=0.01 step=0.01 required> <input type=submit
			value="Calculate Amperage" name=cadSubmit>

		<%
			if (request.getParameter("cadSubmit") != null) {
				double voltage = Double.parseDouble(request.getParameter("txtVoltage"));
				double resistance = Double.parseDouble(request.getParameter("txtResistance"));

				double amperage = voltage / resistance;

				out.println("The amperage is " + amperage);
			}
		%>
	</form>
</body>
</html>