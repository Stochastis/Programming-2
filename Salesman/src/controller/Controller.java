/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package controller;

import java.time.LocalDateTime;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import model.Toy;

/**
 * 
 * @author 214475 This class will handle everything that happens in the GUI.
 *
 */
public class Controller {
	@FXML // fx:id="txtVoltage2"
	private TextField txtVoltage2; // Value injected by FXMLLoader

	@FXML // fx:id="txtToyID"
	private TextField txtToyID; // Value injected by FXMLLoader

	@FXML // fx:id="txtVoltage1"
	private TextField txtVoltage1; // Value injected by FXMLLoader

	@FXML // fx:id="txtLocation1"
	private ComboBox<String> txtLocation1; // Value injected by FXMLLoader

	@FXML // fx:id="txtResistance1"
	private TextField txtResistance1; // Value injected by FXMLLoader

	@FXML // fx:id="txtInspector"
	private TextField txtInspector; // Value injected by FXMLLoader

	@FXML // fx:id="txtResistance2"
	private TextField txtResistance2; // Value injected by FXMLLoader

	@FXML // fx:id="txtLocation2"
	private ComboBox<String> txtLocation2; // Value injected by FXMLLoader

	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader

	FadeTransition fade = new FadeTransition();

	private void playErrorMessage(String pErrorMessage) {
		errorMessage.setText(pErrorMessage);
		errorMessage.setOpacity(1);
		fade.play();
	}
	// TODO: Implement this method.

	@FXML
	private void initialize() {
		txtLocation1.getItems().add("China");
		txtLocation1.getItems().add("Germany");
		txtLocation1.getItems().add("United States");
		txtLocation2.getItems().add("China");
		txtLocation2.getItems().add("Germany");
		txtLocation2.getItems().add("United States");
		fade.setDuration(Duration.millis(5000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(1000);
		fade.setNode(errorMessage);
		fade.setCycleCount(1);
	}

	@FXML
	final void handleSave(final ActionEvent event) {
		Toy myToy = new Toy();

		// Set toy-only properties.
		try {
			myToy.setToyID(Integer.parseInt(txtToyID.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid toy ID.");
		}

		try {
			if (!txtInspector.getText().isBlank()) {
				myToy.setInspector(txtInspector.getText());
			} else {
				playErrorMessage("Please enter a valid Inspector.");
			}
		} catch (Exception e) {
			playErrorMessage("Please enter a valid Inspector.");
		}

		myToy.setInspectionDateTime(LocalDateTime.now());

		// set circuit1 properties.
		myToy.getCircuit1().setVoltage(Integer.parseInt(txtVoltage1.getText()));
		myToy.getCircuit1().setResistance(Integer.parseInt(txtResistance1.getText()));
		myToy.getCircuit1().setManufactureLocation((String) txtLocation1.getValue());

		// set circuit2 properties.
		myToy.getCircuit2().setVoltage(Integer.parseInt(txtVoltage2.getText()));
		myToy.getCircuit2().setResistance(Integer.parseInt(txtResistance2.getText()));
		myToy.getCircuit2().setManufactureLocation((String) txtLocation2.getValue());

		// TODO: myToy.save();

		StringBuilder results = new StringBuilder();
		results.append("\n----------------------");
		results.append("\nToy Information");
		results.append("\nInspector Name: " + myToy.getInspector());
		results.append("\nInspection Date/Time: " + myToy.getInspectionDateTime());
		results.append("\nToyID: " + myToy.getToyID());
		results.append("\n----------------------");
		results.append("\nCircuit 1 Information");
		results.append("\nCircuit ID: " + myToy.getCircuit1().getCircuitID());
		results.append("\nVoltage: " + myToy.getCircuit1().getVoltage());
		results.append("\nAmperage: " + myToy.getCircuit1().getAmperage());
		results.append("\nResistance: " + myToy.getCircuit1().getResistance());
		results.append("\nLocation: " + myToy.getCircuit1().getManufactureLocation());
		results.append("\n----------------------");
		results.append("\nCircuit 2 Information");
		results.append("\nCircuit ID: " + myToy.getCircuit2().getCircuitID());
		results.append("\nVoltage: " + myToy.getCircuit2().getVoltage());
		results.append("\nAmperage: " + myToy.getCircuit2().getAmperage());
		results.append("\nResistance: " + myToy.getCircuit2().getResistance());
		results.append("\nLocation: " + myToy.getCircuit2().getManufactureLocation());
		System.out.println(results);
	}

}
