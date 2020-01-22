module circuitfx {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;

	exports application to javafx.graphics;

	opens controller to javafx.fxml;

}