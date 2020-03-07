package application;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author 214475
 *
 */
public class Main extends Application {
	// static Controller myControllerHandle;
	@Override
	public final void start(final Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/View.fxml"));
			// FXMLLoader loader = new
			// FXMLLoader(getClass().getResource("/view/View.fxml"));
			// Parent root = loader.load();
			// myControllerHandle = (Controller) loader.getController();
			// myControllerHandle.tcAuthor;
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		launch(args);
	}
}
