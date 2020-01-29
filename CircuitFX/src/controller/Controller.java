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

	/**
	 * 
	 */
	private Circuit myCircuit = new Circuit();

	@FXML
	final void handleClick(final ActionEvent event) {

		if ((amperageTextField.getText().isBlank())
				&& (!(resistanceTextField.getText().isBlank()) && (!(voltageTextField.getText().isBlank())))) {
			boolean error = true;

			while (!error) {
				try {
					myCircuit.setResistance(Double.parseDouble(resistanceTextField.getText()));
					myCircuit.setVoltage(Double.parseDouble(voltageTextField.getText()));
					if ((myCircuit.getResistance() <= 0) || (myCircuit.getVoltage() <= 0)) {
						Alert myAlert = new Alert(AlertType.INFORMATION);
						myAlert.setTitle("Error");
						myAlert.setContentText("Please enter positive values.");
						myAlert.showAndWait();
						break;
					}
					myCircuit.calculateAmperage();
					error = false;
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Results");
					myAlert.setContentText("This circuit has an amperage of " + myCircuit.getAmperage());
					myAlert.showAndWait();
				} catch (Exception e) {
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Error");
					myAlert.setContentText("Please make sure that the values you entered are valid.");
					myAlert.showAndWait();
					break;
				}
			}

		} else if ((resistanceTextField.getText().isBlank())
				&& (!(amperageTextField.getText().isBlank()) && (!(voltageTextField.getText().isBlank())))) {
			boolean error = true;

			while (!error) {
				try {
					myCircuit.setAmperage(Double.parseDouble(amperageTextField.getText()));
					myCircuit.setVoltage(Double.parseDouble(voltageTextField.getText()));
					if ((myCircuit.getAmperage() <= 0) || (myCircuit.getVoltage() <= 0)) {
						Alert myAlert = new Alert(AlertType.INFORMATION);
						myAlert.setTitle("Error");
						myAlert.setContentText("Please enter positive values.");
						myAlert.showAndWait();
						break;
					}
					myCircuit.calculateResistance();
					error = false;
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Results");
					myAlert.setContentText("This circuit has an resistance of " + myCircuit.getResistance());
					myAlert.showAndWait();
				} catch (Exception e) {
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Error");
					myAlert.setContentText("Please make sure that the values you entered are valid.");
					myAlert.showAndWait();
					break;
				}
			}
		} else if ((voltageTextField.getText().isBlank())
				&& (!(amperageTextField.getText().isBlank()) && (!(resistanceTextField.getText().isBlank())))) {
			boolean error = true;

			while (!error) {
				try {
					myCircuit.setResistance(Double.parseDouble(resistanceTextField.getText()));
					myCircuit.setAmperage(Double.parseDouble(amperageTextField.getText()));
					if ((myCircuit.getAmperage() <= 0) || (myCircuit.getResistance() <= 0)) {
						Alert myAlert = new Alert(AlertType.INFORMATION);
						myAlert.setTitle("Error");
						myAlert.setContentText("Please enter positive values.");
						myAlert.showAndWait();
						break;
					}
					myCircuit.calculateVoltage();
					error = false;
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Results");
					myAlert.setContentText("This circuit has an voltage of " + myCircuit.getVoltage());
					myAlert.showAndWait();
				} catch (Exception e) {
					Alert myAlert = new Alert(AlertType.INFORMATION);
					myAlert.setTitle("Error");
					myAlert.setContentText("Please make sure that the values you entered are valid.");
					myAlert.showAndWait();
					break;
				}
			}
		} else {
			Alert myAlert = new Alert(AlertType.INFORMATION);
			myAlert.setTitle("Error");
			myAlert.setContentText("Please enter values in two of the three boxes.");
			myAlert.showAndWait();
		}

	}

	@FXML
	final void handleClear(final ActionEvent event) {
		amperageTextField.clear();
		resistanceTextField.clear();
		voltageTextField.clear();
		amperageTextField.requestFocus();
	}
}
