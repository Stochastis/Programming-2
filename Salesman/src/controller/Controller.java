/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package controller;

import java.time.LocalDateTime;

import org.w3c.dom.events.EventException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.Toy;

/**
 * 
 * @author 214475 This class will handle everything that happens in the GUI.
 *
 */
public class Controller {
	@FXML // fx:id="txtInspector"
	private TextField txtInspector; // Value injected by FXMLLoader

	@FXML // fx:id="txtToyID"
	private TextField txtToyID; // Value injected by FXMLLoader

	@FXML // fx:id="txtVoltage2"
	private TextField txtVoltage2; // Value injected by FXMLLoader

	@FXML // fx:id="txtResistance2"
	private TextField txtResistance2; // Value injected by FXMLLoader

	@FXML // fx:id="txtLocation2"
	private TextField txtLocation2; // Value injected by FXMLLoader

	@FXML // fx:id="txtVoltage1"
	private TextField txtVoltage1; // Value injected by FXMLLoader

	@FXML // fx:id="txtResistance1"
	private TextField txtResistance1; // Value injected by FXMLLoader

	@FXML // fx:id="txtLocation1"
	private TextField txtLocation1; // Value injected by FXMLLoader

	@FXML
	final void handleSave(final ActionEvent event) {
		boolean error = true;
		Toy myToy = new Toy();

		// Set toy-only properties.
		while (error) {
			try {
				myToy.setToyID(Integer.parseInt(txtToyID.getText()));
				error = false;
			} catch (Exception e) {
				Alert myAlert = new Alert(AlertType.INFORMATION);
				myAlert.setTitle("Error");
				myAlert.setContentText("Please make sure that you entered a valid toy ID.");
				myAlert.showAndWait();
				break;
			}
		}
		myToy.setInspector(txtInspector.getText());
		myToy.setInspectionDateTime(LocalDateTime.now());

		// set circuit1 properties.
		myToy.getCircuit1().setVoltage(Integer.parseInt(txtVoltage1.getText()));
		myToy.getCircuit1().setResistance(Integer.parseInt(txtResistance1.getText()));
		myToy.getCircuit1().setManufactureLocation(txtLocation1.getText());

		// set circuit2 properties.
		myToy.getCircuit2().setVoltage(Integer.parseInt(txtVoltage2.getText()));
		myToy.getCircuit2().setResistance(Integer.parseInt(txtResistance2.getText()));
		myToy.getCircuit2().setManufactureLocation(txtLocation2.getText());

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
