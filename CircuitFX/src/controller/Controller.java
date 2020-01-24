package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Circuit;

/**
 * 
 * @author 214475
 *
 */
public class Controller {

	/**
	 * 
	 */
	@FXML
	private TextField amperageTextField;

	/**
	 * 
	 */
	@FXML
	private TextField resistanceTextField;

	/**
	 * 
	 */
	@FXML
	private TextField voltageTextField;

	@FXML
	final void handleClick(final ActionEvent event) {

		Circuit myCircuit = new Circuit();

		if ((amperageTextField.getText().isBlank())
				&& (!(resistanceTextField.getText().isBlank()) && (!(voltageTextField.getText().isBlank())))) {
			myCircuit.setResistance(Double.parseDouble(resistanceTextField.getText()));
			myCircuit.setVoltage(Double.parseDouble(voltageTextField.getText()));
			myCircuit.calculateAmperage();

			Alert myAlert = new Alert(AlertType.INFORMATION);
			myAlert.setTitle("Results");
			myAlert.setContentText("This circuit has an amperage of " + myCircuit.getAmperage());
			myAlert.showAndWait();
		} else if ((resistanceTextField.getText().isBlank())
				&& (!(amperageTextField.getText().isBlank()) && (!(voltageTextField.getText().isBlank())))) {
			myCircuit.setAmperage(Double.parseDouble(amperageTextField.getText()));
			myCircuit.setVoltage(Double.parseDouble(voltageTextField.getText()));
			myCircuit.calculateResistance();

			Alert myAlert = new Alert(AlertType.INFORMATION);
			myAlert.setTitle("Results");
			myAlert.setContentText("This circuit has a resistance of " + myCircuit.getResistance());
			myAlert.showAndWait();
		} else if ((voltageTextField.getText().isBlank())
				&& (!(amperageTextField.getText().isBlank()) && (!(resistanceTextField.getText().isBlank())))) {
			myCircuit.setAmperage(Double.parseDouble(amperageTextField.getText()));
			myCircuit.setResistance(Double.parseDouble(resistanceTextField.getText()));
			myCircuit.calculateVoltage();

			Alert myAlert = new Alert(AlertType.INFORMATION);
			myAlert.setTitle("Results");
			myAlert.setContentText("This circuit has a voltage of " + myCircuit.getVoltage());
			myAlert.showAndWait();
		} else {
			Alert myAlert = new Alert(AlertType.INFORMATION);
			myAlert.setTitle("Error");
			myAlert.setContentText("Please enter values in two of the three boxes.");
			myAlert.showAndWait();
		}

	}

	@FXML
	void handleClear(ActionEvent event) {

	}
}
