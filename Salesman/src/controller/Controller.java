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
	/**
	 * Text field for circuit 2's voltage.
	 */
	@FXML // fx:id="txtVoltage2"
	private TextField txtVoltage2; // Value injected by FXMLLoader

	/**
	 * Text field for the toy id.
	 */
	@FXML // fx:id="txtToyID"
	private TextField txtToyID; // Value injected by FXMLLoader

	/**
	 * Text field for circuit 1's voltage.
	 */
	@FXML // fx:id="txtVoltage1"
	private TextField txtVoltage1; // Value injected by FXMLLoader

	/**
	 * Combo box for circuit 1's location.
	 */
	@FXML // fx:id="txtLocation1"
	private ComboBox<String> txtLocation1; // Value injected by FXMLLoader

	/**
	 * Text field for circuit 1's resistance.
	 */
	@FXML // fx:id="txtResistance1"
	private TextField txtResistance1; // Value injected by FXMLLoader

	/**
	 * Text field for inspector's name.
	 */
	@FXML // fx:id="txtInspector"
	private TextField txtInspector; // Value injected by FXMLLoader

	/**
	 * Text field for circuit 2's resistance.
	 */
	@FXML // fx:id="txtResistance2"
	private TextField txtResistance2; // Value injected by FXMLLoader

	/**
	 * Combo box for circuit 2's location.
	 */
	@FXML // fx:id="txtLocation2"
	private ComboBox<String> txtLocation2; // Value injected by FXMLLoader

	/**
	 * An editable text field that will display a fading error message when a value
	 * isn't entered properly.
	 */
	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader

	/**
	 * This is a fading animation that can be called whenever it is needed.
	 */
	private FadeTransition fade = new FadeTransition();

	private void playErrorMessage(final String pErrorMessage) {
		errorMessage.setText(pErrorMessage);
		fade.stop();
		errorMessage.setOpacity(1);
		fade.play();
	}

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
		boolean error = false;

		// Set toy-only properties.
		try {
			myToy.setToyID(Integer.parseInt(txtToyID.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid toy ID.");
			error = true;
		}
		try {
			if (!txtInspector.getText().isBlank()) {
				myToy.setInspector(txtInspector.getText());
			} else {
				playErrorMessage("Please enter a valid Inspector.");
				error = true;
			}
		} catch (Exception e) {
			playErrorMessage("Please enter a valid Inspector.");
			error = true;
		}
		myToy.setInspectionDateTime(LocalDateTime.now());

		// set circuit1 properties.
		try {
			myToy.getCircuit1().setVoltage(Integer.parseInt(txtVoltage1.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid voltage for circuit 1.");
			error = true;
		}
		try {
			myToy.getCircuit1().setResistance(Integer.parseInt(txtResistance1.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid resistance for circuit 1.");
			error = true;
		}
		if (txtLocation1.getValue() == null) {
			playErrorMessage("Please select location for circuit 1.");
			error = true;
		} else {
			myToy.getCircuit1().setManufactureLocation((String) txtLocation1.getValue());
		}

		// set circuit2 properties.
		try {
			myToy.getCircuit2().setVoltage(Integer.parseInt(txtVoltage2.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid voltage for circuit 2.");
			error = true;
		}
		try {
			myToy.getCircuit2().setResistance(Integer.parseInt(txtResistance2.getText()));
		} catch (Exception e) {
			playErrorMessage("Please enter a valid resistance for circuit 2.");
			error = true;
		}
		if (txtLocation2.getValue() == null) {
			playErrorMessage("Please select location for circuit 2.");
			error = true;
		} else {
			myToy.getCircuit2().setManufactureLocation((String) txtLocation2.getValue());
		}

		// Clear fields if there are no errors that need fixed
		if (!error) {
			txtToyID.clear();
			txtVoltage1.clear();
			txtResistance1.clear();
			txtLocation1.getSelectionModel().clearSelection();
			txtVoltage2.clear();
			txtResistance2.clear();
			txtLocation2.getSelectionModel().clearSelection();
		} else {
			error = false;
		}

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
