module salesman {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.xml;
	requires java.sql;
	requires mysql.connector.java;

	exports application to javafx.graphics;

	opens controller to javafx.fxml;

}