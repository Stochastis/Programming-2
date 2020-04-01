/**
 * Sample Skeleton for 'View.fxml' Controller Class
 */

package controller;

import model.ExerciseAerobic;
import model.ExerciseStrength;
import model.Gender;
import model.Person;

import java.sql.SQLException;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import java.time.LocalDate;

public class Controller {

	ExerciseAerobic myExerciseAerobic = new ExerciseAerobic();

	ExerciseStrength myExerciseStrength = new ExerciseStrength();

	Person myPerson = new Person();

	@FXML // fx:id="tableExerciseAerobic"
	private TableView<ExerciseAerobic> tblExerciseAerobic; // Value injected by FXMLLoader

	@FXML // fx:id="tableExerciseStrength"
	private TableView<ExerciseStrength> tblExerciseStrength; // Value injected by FXMLLoader

	@FXML // fx:id="tcDate"
	private TableColumn<LocalDate, ExerciseAerobic> tcAerobicDate; // Value injected by FXMLLoader

	@FXML // fx:id="tcName"
	private TableColumn<String, ExerciseAerobic> tcAerobicName; // Value injected by FXMLLoader

	@FXML // fx:id="tcDuration"
	private TableColumn<Duration, ExerciseAerobic> tcAerobicDuration; // Value injected by FXMLLoader

	@FXML // fx:id="tcMadHR"
	private TableColumn<Integer, ExerciseAerobic> tcAerobicMaxHR; // Value injected by FXMLLoader

	@FXML // fx:id="tcAvgHR"
	private TableColumn<Integer, ExerciseAerobic> tcAerobicAvgHR; // Value injected by FXMLLoader

	@FXML // fx:id="tcDistance"
	private TableColumn<Double, ExerciseAerobic> tcAerobicDistance; // Value injected by FXMLLoader

	@FXML // fx:id="txtStudentID"
	private TextField txtStudentID; // Value injected by FXMLLoader

	@FXML // fx:id="txtFirstName"
	private TextField txtFirstName; // Value injected by FXMLLoader

	@FXML // fx:id="txtLastName"
	private TextField txtLastName; // Value injected by FXMLLoader

	@FXML // fx:id="txtHeight"
	private TextField txtHeight; // Value injected by FXMLLoader

	@FXML // fx:id="btnSave"
	private Button btnSave; // Value injected by FXMLLoader

	@FXML // fx:id="btnDelete"
	private Button btnDelete; // Value injected by FXMLLoader

	@FXML // fx:id="btnAddExercise"
	private Button btnAddExercise; // Value injected by FXMLLoader

	@FXML // fx:id="btnDeleteExercise"
	private Button btnDeleteExercise; // Value injected by FXMLLoader

	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader

	@FXML // fx:id="txtSearch"
	private TextField txtSearch; // Value injected by FXMLLoader

	@FXML // fx:id="txtWeight"
	private TextField txtWeight; // Value injected by FXMLLoader

	@FXML // fx:id="txtGender"
	private ChoiceBox<Gender> txtGender; // Value injected by FXMLLoader

	@FXML // fx:id="txtBirthdate"
	private DatePicker txtBirthdate; // Value injected by FXMLLoader

	@FXML // fx:id="group1"
	private ToggleGroup group1; // Value injected by FXMLLoader

	@FXML // fx:id="btnLoad"
	private Button btnLoad; // Value injected by FXMLLoader

	/**
	 * This is a fading animation that can be called whenever it is needed.
	 */
	private FadeTransition fade = new FadeTransition();

	/*
	 * This method displays a fading error message. The text of the message can be
	 * passed into the method as a parameter.
	 */
	private void playMessage(final String pMessage) {
		errorMessage.setText(pMessage);
		fade.stop();
		errorMessage.setOpacity(1);
		fade.play();
	}

	private void refresh(Person pPerson) throws SQLException {
		tblExerciseAerobic.getItems().setAll(ExerciseAerobic.getAll(pPerson));
		tcAerobicAvgHR.setCellValueFactory(new PropertyValueFactory<>("AverageHeartRate"));
		tcAerobicDistance.setCellValueFactory(new PropertyValueFactory<>("Distance"));
		tcAerobicMaxHR.setCellValueFactory(new PropertyValueFactory<>("MaxHeartRate"));
		tcAerobicName.setCellValueFactory(new PropertyValueFactory<>("ExerciseName"));
		tcAerobicDate.setCellValueFactory(new PropertyValueFactory<>("ExerciseDate"));
		tcAerobicDuration.setCellValueFactory(new PropertyValueFactory<>("ExerciseSeconds"));
	}

	@FXML
	private void initialize() throws SQLException {
		txtGender.getItems().add(Gender.MALE);
		txtGender.getItems().add(Gender.FEMALE);
		txtGender.getItems().add(Gender.UNSPECIFIED);
		fade.setDuration(Duration.millis(5000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(1000);
		fade.setNode(errorMessage);
		fade.setCycleCount(1);
	}

	@FXML
	final void handleSave(final ActionEvent event) throws SQLException {
		myPerson = new Person();
		if (!(txtBirthdate.getValue() == null) && !(txtFirstName.getText().isBlank())
				&& !(txtGender.getSelectionModel().isEmpty()) && !(txtHeight.getText().isBlank())
				&& !(txtLastName.getText().isBlank()) && !(txtStudentID.getText().isBlank())) {
			myPerson.setBirthdate(txtBirthdate.getValue());
			myPerson.setFirstName(txtFirstName.getText());
			myPerson.setGender((Gender) txtGender.getSelectionModel().getSelectedItem());
			myPerson.setHeight(Double.parseDouble(txtHeight.getText()));
			myPerson.setLastName(txtLastName.getText());
			myPerson.setStudentID(Integer.parseInt(txtStudentID.getText()));
			myPerson.setWeight(Double.parseDouble(txtWeight.getText()));
			myPerson.save();
			playMessage("Person Saved");
			refresh(myPerson);
		} else {
			playMessage("Please Make Sure All Fields Have Something Before Saving");
		}
	}

	@FXML
	void handleLoad(ActionEvent event) throws SQLException {
		myPerson = new Person();
		myPerson.setStudentID(Integer.parseInt(txtStudentID.getText()));
		myPerson.load(myPerson.getStudentID());

		txtBirthdate.setValue(myPerson.getBirthdate());
		txtFirstName.setText(myPerson.getFirstName());
		txtGender.setValue(myPerson.getGender());
		txtHeight.setText(Double.toString(myPerson.getHeight()));
		txtLastName.setText(myPerson.getLastName());
		txtWeight.setText(Double.toString(myPerson.getWeight()));

		refresh(myPerson);
	}

	@FXML
	final void handleDelete(final ActionEvent event) throws SQLException {
		myPerson = new Person();
		myPerson.setStudentID(Integer.parseInt(txtStudentID.getText()));
		if (myPerson == null) {
			playMessage("Please Select A Book To Delete");
		} else {
			myPerson.delete();
			playMessage("Person Deleted");
			txtBirthdate.setValue(null);
			txtFirstName.setText("");
			txtGender.setValue(null);
			txtHeight.setText("");
			txtLastName.setText("");
			txtStudentID.setText("");
			txtWeight.setText("");
			refresh(myPerson);
		}
	}
}
