/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package controller;

import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Toy;

/**
 * 
 * @author 214475 This class will handle everything that happens in the GUI.
 *
 */
public class Controller {

	@FXML
	final void handleSave(final ActionEvent event) {
		Toy myToy = new Toy();

		// Set toy-only properties.
		myToy.setToyID(txtToyID.getText());
		myToy.setInspector(txtInspector.getText());
		myToy.setInspectionDateTime(LocalDateTime.now());

		// set circuit1 properties.
		myToy.getCircuit1().setVoltage(txtVoltage1.getText());
		// TODO: ALL OTHER CIRCUIT1 PROPERTIES

		// set circuit2 properties.
		// TODO: ALL OTHER CIRCUIT 2 PROPERTIES

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
