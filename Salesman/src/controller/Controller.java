package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import model.Toy;

/**
 * 
 * @author 214475 This class will handle everything that happens in the GUI.
 *
 */
public class Controller {
	/**
	 * This is a toy object for inputting data.
	 */
	Toy myToy = new Toy();

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
	 * This is the delete button.
	 */
	@FXML // fx:id="btnDelete"
	private Button btnDelete; // Value injected by FXMLLoader

	/**
	 * This is the text field that will show the inspection date/time.
	 */
	@FXML // fx:id="txtTime"
	private TextField txtTime; // Value injected by FXMLLoader

	/**
	 * An editable text field that will display a fading error message when a value
	 * isn't entered properly.
	 */
	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader

	@FXML
	final void handleSetLanguageEnglish(final ActionEvent event) {
		setFieldsWithTranslations("en", "US");
	}

	@FXML
	final void handleSetLanguageSpanish(final ActionEvent event) {
		setFieldsWithTranslations("es", "MX");
	}

	private void setFieldsWithTranslations(final String language, final String region) {
		Locale myLocale = new Locale(language, region);

		ResourceBundle rb = ResourceBundle.getBundle("Translation", myLocale);
		btnDelete.setText(rb.getString("delete"));
	}

	/**
	 * This is a fading animation that can be called whenever it is needed.
	 */
	private FadeTransition fade = new FadeTransition();

	//This method displays a fading error message. The text of the message can be passed into the method as a parameter.
	private void playErrorMessage(final String pErrorMessage) {
		errorMessage.setText(pErrorMessage);
		fade.stop();
		errorMessage.setOpacity(1);
		fade.play();
	}

	@FXML // This initialization adds the location items to the combo boxes and sets the properties of the fading error animation.
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
		handleSetLanguageEnglish(null);
	}

	@FXML //This method will attempt to save a toy to the database.
	final void handleSave(final ActionEvent event) throws SQLException {
		boolean error = false;

		//Set toy-only properties.
		myToy.setInspectionDateTime(LocalDateTime.now());
		try {
			if (!txtToyID.getText().isBlank()) {
				myToy.setToyID(Integer.parseInt(txtToyID.getText()));
			} else {
				playErrorMessage("Please enter a valid toy ID.");
				error = true;
			}
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

		//Set circuit1 properties.
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

		//Set circuit2 properties.
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
		if (!(myToy.getToyID() > 0)) {
			playErrorMessage("Please enter a valid toy ID.");
			error = true;
		}

		// If there are no errors, save the toy and clear the text fields.
		if (!error) {
			myToy.save();
			txtToyID.clear();
			txtVoltage1.clear();
			txtResistance1.clear();
			txtLocation1.getSelectionModel().clearSelection();
			txtVoltage2.clear();
			txtResistance2.clear();
			txtLocation2.getSelectionModel().clearSelection();
			playErrorMessage("Saved toy " + myToy.getToyID());
			btnDelete.setDisable(false);
		} else {
			error = false;
		}
	}

	@FXML //This method will attempt to delete a toy.
	final void handleDelete(final ActionEvent event) throws SQLException {
		try {
			//Ask the user if they are sure they want to delete the toy.
			Alert myAlert = new Alert(AlertType.CONFIRMATION);
			myAlert.setTitle("Confirm Delete");
			myAlert.setHeaderText("Are you sure?");
			myAlert.setContentText("Are you sure you want to delete toyID: " + txtToyID.getText());
			Optional<ButtonType> answer = myAlert.showAndWait();
			if (answer.isPresent() && answer.get().equals(ButtonType.OK)) {
				//If they verify the user verifies that they want to delete the toy, delete it.
				myToy.setToyID(Integer.parseInt(txtToyID.getText()));
				myToy.delete();
				System.out.println("Toy deleted.");
				Alert deleted = new Alert(AlertType.INFORMATION);
				deleted.setTitle("Deleted");
				deleted.setContentText("ToyID " + myToy.getToyID() + " deleted.");
				deleted.showAndWait();
				handleClear(null);
				btnDelete.setDisable(true);
			} else {
				Alert cancelled = new Alert(AlertType.INFORMATION);
				cancelled.setTitle("Delete cancelled");
				cancelled.setContentText("ToyID " + txtToyID.getText() + " not deleted.");
				cancelled.showAndWait();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//This clears the text fields after deleting a toy.
		txtToyID.clear();
		txtVoltage1.clear();
		txtResistance1.clear();
		txtLocation1.getSelectionModel().clearSelection();
		txtVoltage2.clear();
		txtResistance2.clear();
		txtLocation2.getSelectionModel().clearSelection();

	}

	@FXML //This clears all of the input fields except for the inspector.
	final void handleClear(final ActionEvent event) {
		txtToyID.clear();
		txtVoltage1.clear();
		txtResistance1.clear();
		txtLocation1.getSelectionModel().clearSelection();
		txtVoltage2.clear();
		txtResistance2.clear();
		txtLocation2.getSelectionModel().clearSelection();
	}

	@FXML //This will attempt to load a toy from the database and display its information.
	final void handleLoad(final ActionEvent event) throws NumberFormatException, SQLException {
		myToy = new Toy();
		try {
			myToy.load(Integer.parseInt(txtToyID.getText()));
			// Load view
			txtInspector.setText(myToy.getInspector());
			txtResistance1.setText(Double.toString(myToy.getCircuit1().getResistance()));
			txtResistance2.setText(Double.toString(myToy.getCircuit2().getResistance()));
			txtVoltage1.setText(Double.toString(myToy.getCircuit1().getVoltage()));
			txtVoltage2.setText(Double.toString(myToy.getCircuit2().getVoltage()));
			txtLocation1.getSelectionModel().select(myToy.getCircuit1().getManufactureLocation());
			txtLocation2.getSelectionModel().select(myToy.getCircuit2().getManufactureLocation());
			txtTime.setText(myToy.getInspectionDateTime().toString());
		} catch (Exception e) {
			//If there is an error in loading the toy, tell the user it does not exist.
			playErrorMessage("Toy " + txtToyID.getText() + " does not exist.");
		}
	}
}
