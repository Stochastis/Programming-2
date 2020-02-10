module salesman {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.xml;

	exports application to javafx.graphics;

	opens controller to javafx.fxml;

}