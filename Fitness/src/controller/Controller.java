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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.Duration;
import java.time.LocalDate;

/**
 * This is the controller for the gui.
 * 
 * @author Caleb
 *
 */
public class Controller {

	/**
	 * This is a new Aerobic Exercise for creating and deleting exercises.
	 */
	ExerciseAerobic myExerciseAerobic = new ExerciseAerobic();

	/**
	 * This is a new Aerobic Exercise for creating and deleting exercises.
	 */
	ExerciseStrength myExerciseStrength = new ExerciseStrength();

	/**
	 * This is a new Person for creating, deleting, and loading students.
	 */
	Person myPerson = new Person();

	/**
	 * 
	 */

	@FXML // fx:id="errorMessage"
	private Label errorMessage; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="lbMHRS"
	private Label lbMHRS; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="lbAHRR"
	private Label lbAHRR; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="lbDWL"
	private Label lbDWL; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tableExerciseAerobic"
	private TableView<ExerciseAerobic> tblExerciseAerobic; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tableExerciseStrength"
	private TableView<ExerciseStrength> tblExerciseStrength; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tpExercises"
	private TabPane tpExercises; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcDate"
	private TableColumn<LocalDate, ExerciseAerobic> tcAerobicDate; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcName"
	private TableColumn<String, ExerciseAerobic> tcAerobicName; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcDuration"
	private TableColumn<Duration, ExerciseAerobic> tcAerobicDuration; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcMadHR"
	private TableColumn<Integer, ExerciseAerobic> tcAerobicMaxHR; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcAvgHR"
	private TableColumn<Integer, ExerciseAerobic> tcAerobicAvgHR; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcDistance"
	private TableColumn<Double, ExerciseAerobic> tcAerobicDistance; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthDate"
	private TableColumn<LocalDate, ExerciseStrength> tcStrengthDate; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthName"
	private TableColumn<String, ExerciseStrength> tcStrengthName; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthDuration"
	private TableColumn<Duration, ExerciseStrength> tcStrengthDuration; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthSets"
	private TableColumn<Integer, ExerciseStrength> tcStrengthSets; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthReps"
	private TableColumn<Integer, ExerciseStrength> tcStrengthReps; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="tcStrengthWeight"
	private TableColumn<Double, ExerciseStrength> tcStrengthWeight; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtStudentID"
	private TextField txtStudentID; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtFirstName"
	private TextField txtFirstName; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtLastName"
	private TextField txtLastName; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtHeight"
	private TextField txtHeight; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseName"
	private TextField txtExerciseName; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseDuration"
	private TextField txtExerciseDuration; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseMHRS"
	private TextField txtExerciseMHRS; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseAHRR"
	private TextField txtExerciseAHRR; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseDWL"
	private TextField txtExerciseDWL; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtExerciseDate"
	private DatePicker txtExerciseDate; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnLoad"
	private Button btnLoad; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnNewStudent"
	private Button btnNewStudent; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnSave"
	private Button btnSavePerson; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnDelete"
	private Button btnDeletePerson; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnAddExercise"
	private Button btnAddExercise; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnDeleteExercise"
	private Button btnDeleteExercise; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtSearch"
	private TextField txtSearch; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtWeight"
	private TextField txtWeight; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtGender"
	private ChoiceBox<Gender> txtGender; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="txtBirthdate"
	private DatePicker txtBirthdate; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="group1"
	private ToggleGroup group1; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnAerobic"
	private RadioButton btnAerobic; // Value injected by FXMLLoader
	/**
	 * 
	 */

	@FXML // fx:id="btnStrength"
	private RadioButton btnStrength; // Value injected by FXMLLoader

	/**
	 * This is a fading animation that can be called whenever it is needed.
	 */
	private FadeTransition fade = new FadeTransition();

	/**
	 * This is a method used for clearing all fields in the program so a new student
	 * can be entered easily.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void clearFieldsAll() throws SQLException {
		myPerson = new Person();
		clearFieldsExercise();
		txtBirthdate.setValue(null);
		txtFirstName.clear();
		txtGender.setValue(null);
		txtHeight.clear();
		txtLastName.clear();
		txtStudentID.clear();
		txtWeight.clear();
		refresh(myPerson);
	}

	/**
	 * Clears all the fields for inputting an exercise.
	 */
	private void clearFieldsExercise() {
		txtExerciseAHRR.clear();
		txtExerciseDate.setValue(null);
		txtExerciseDuration.clear();
		txtExerciseDWL.clear();
		txtExerciseMHRS.clear();
		txtExerciseName.clear();
	}

	/*
	 * This method displays a fading message. The text of the message can be passed
	 * into the method as a parameter.
	 */
	private void playMessage(final String pMessage) {
		errorMessage.setText(pMessage);
		fade.stop();
		errorMessage.setOpacity(1);
		fade.play();
	}

	private void refresh(final Person pPerson) throws SQLException {
		tblExerciseAerobic.getItems().setAll(ExerciseAerobic.getAll(pPerson));
		tcAerobicAvgHR.setCellValueFactory(new PropertyValueFactory<>("AverageHeartRate"));
		tcAerobicDistance.setCellValueFactory(new PropertyValueFactory<>("Distance"));
		tcAerobicMaxHR.setCellValueFactory(new PropertyValueFactory<>("MaxHeartRate"));
		tcAerobicName.setCellValueFactory(new PropertyValueFactory<>("ExerciseName"));
		tcAerobicDate.setCellValueFactory(new PropertyValueFactory<>("ExerciseDate"));
		tcAerobicDuration.setCellValueFactory(new PropertyValueFactory<>("ExerciseSeconds"));

		tblExerciseStrength.getItems().setAll(ExerciseStrength.getAll(pPerson));
		tcStrengthReps.setCellValueFactory((new PropertyValueFactory<>("Reps")));
		tcStrengthSets.setCellValueFactory(new PropertyValueFactory<>("Sets"));
		tcStrengthWeight.setCellValueFactory(new PropertyValueFactory<>("WeightLifted"));
		tcStrengthName.setCellValueFactory(new PropertyValueFactory<>("ExerciseName"));
		tcStrengthDate.setCellValueFactory(new PropertyValueFactory<>("ExerciseDate"));
		tcStrengthDuration.setCellValueFactory(new PropertyValueFactory<>("ExerciseSeconds"));
	}

	@FXML
	private void initialize() throws SQLException {
		txtGender.getItems().add(Gender.MALE);
		txtGender.getItems().add(Gender.FEMALE);
		txtGender.getItems().add(Gender.UNSPECIFIED);
		fade.setDuration(new javafx.util.Duration(10000));
		fade.setFromValue(10);
		fade.setToValue(0);
		fade.setCycleCount(1000);
		fade.setNode(errorMessage);
		fade.setCycleCount(1);
	}

	@FXML
	final void handleSavePerson(final ActionEvent event) throws SQLException {
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
	final void handleLoad(final ActionEvent event) throws SQLException {
		if (txtStudentID.getText().isBlank()) {
			playMessage("Please Enter A Student ID Before Loading");
		} else {
			boolean error = false;
			try {
				myPerson = new Person();
				myPerson.setStudentID(Integer.parseInt(txtStudentID.getText()));
			} catch (Exception e) {
				playMessage("Please enter a number for the Student ID");
				error = true;
			}
			if (!error) {
				try {
					myPerson.load(myPerson.getStudentID());
					txtBirthdate.setValue(myPerson.getBirthdate());
					txtFirstName.setText(myPerson.getFirstName());
					txtGender.setValue(myPerson.getGender());
					txtHeight.setText(Double.toString(myPerson.getHeight()));
					txtLastName.setText(myPerson.getLastName());
					txtWeight.setText(Double.toString(myPerson.getWeight()));
					playMessage("Student Loaded");
					refresh(myPerson);
				} catch (Exception e) {
					playMessage("Student does not exist");
				}
			}
		}
	}

	@FXML
	final void handleDeletePerson(final ActionEvent event) throws SQLException {
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

	@FXML
	final void handleSelectAerobic(final ActionEvent event) {
		txtExerciseAHRR.setPromptText("Average Heart Rate");
		txtExerciseDWL.setPromptText("Distance (Miles)");
		txtExerciseMHRS.setPromptText("Max Heart Rate");
		lbAHRR.setText("Average Heart Rate:");
		lbDWL.setText("Distance (Miles):");
		lbMHRS.setText("Max Heart Rate:");
	}

	@FXML
	final void handleSelectStrength(final ActionEvent event) {
		txtExerciseAHRR.setPromptText("Reps");
		txtExerciseDWL.setPromptText("Weight Lifted (lbs)");
		txtExerciseMHRS.setPromptText("Sets");
		lbAHRR.setText("Reps:");
		lbDWL.setText("Weight Lifted (lbs):");
		lbMHRS.setText("Sets:");
	}

	@FXML
	final void handleAddExercise(final ActionEvent event) throws SQLException {
		if (btnAerobic.isSelected()) {
			ExerciseAerobic myExercise = new ExerciseAerobic();
			if (!(txtExerciseAHRR.getText().isBlank()) && !(txtExerciseDuration.getText().isBlank())
					&& !(txtExerciseDWL.getText().isBlank()) && !(txtExerciseDate.getValue() == null)
					&& !(txtExerciseMHRS.getText().isBlank()) && !(txtExerciseName.getText().isBlank())) {
				myExercise.setExerciseName(txtExerciseName.getText());
				myExercise.setExerciseDate(txtExerciseDate.getValue());

				boolean error = false;
				try {
					myExercise.setMaxHeartRate(Integer.parseInt(txtExerciseMHRS.getText()));
					myExercise.setAverageHeartRate(Integer.parseInt(txtExerciseAHRR.getText()));
					myExercise.setDistance(Double.parseDouble(txtExerciseDWL.getText()));
					myExercise
							.setExerciseDuration(Duration.ofSeconds((Long.parseLong((txtExerciseDuration.getText())))));
				} catch (Exception e) {
					playMessage("Please Enter Valid Values For Your Exercise");
					error = true;
				}

				if (!error) {

					// Check to see if there is a non-zero value in each field
					if (myExercise.getMaxHeartRate() > 0 && myExercise.getAverageHeartRate() > 0
							&& !(myExercise.getDistance() < 0) && myExercise.getExerciseSeconds() > 0) {

						// Check to see that MHR is greater than AHR
						if (myExercise.getMaxHeartRate() < myExercise.getAverageHeartRate()) {
							playMessage("Please Make Sure The Max Heart Rate Is Greater Than The Average Heart Rate");
						} else {

							// Check to see if the person moved or not
							if (myExercise.getDistance() == 0) {
								myExercise.save(myPerson, false);
							} else {
								myExercise.save(myPerson, true);
							}
							playMessage("Exercise Saved");
							refresh(myPerson);
							clearFieldsExercise();
						}
					} else {
						playMessage("Please Enter Positive Values For All Fields");
					}
				}
			} else {
				playMessage("Please Make Sure All Fields Have Something Before Saving");
			}
		} else {
			ExerciseStrength myExercise = new ExerciseStrength();
			if (!(txtExerciseAHRR.getText().isBlank()) && !(txtExerciseDuration.getText().isBlank())
					&& !(txtExerciseDWL.getText().isBlank()) && !(txtExerciseDate.getValue() == null)
					&& !(txtExerciseMHRS.getText().isBlank()) && !(txtExerciseName.getText().isBlank())) {
				myExercise.setExerciseName(txtExerciseName.getText());
				myExercise.setExerciseDate(txtExerciseDate.getValue());

				boolean error = false;
				try {
					myExercise.setReps((Integer.parseInt(txtExerciseAHRR.getText())));
					myExercise.setSets((Integer.parseInt(txtExerciseMHRS.getText())));
					myExercise.setWeightLifted((Double.parseDouble(txtExerciseDWL.getText())));
					myExercise
							.setExerciseDuration(Duration.ofSeconds((Long.parseLong((txtExerciseDuration.getText())))));
				} catch (Exception e) {
					playMessage("Please Enter Valid Values For Your Exercise");
					error = true;
				}

				if (!error) {
					if (myExercise.getReps() > 0 && myExercise.getSets() > 0 && myExercise.getWeightLifted() > 0
							&& myExercise.getExerciseSeconds() > 0) {
						myExercise.save(myPerson, true);
						playMessage("Exercise Saved");
						refresh(myPerson);
						clearFieldsExercise();
					} else {
						playMessage("Please Enter Positive Values For All Fields");
					}
				}
			} else {
				playMessage("Please Make Sure All Fields Have Something Before Saving");
			}
		}
	}

	@FXML
	final void handleDeleteExercise(final ActionEvent event) throws SQLException {
		if (tpExercises.getSelectionModel().getSelectedIndex() == 0) {
			ExerciseAerobic myExercise = new ExerciseAerobic();
			myExercise = tblExerciseAerobic.getSelectionModel().getSelectedItem();
			if (myExercise == null) {
				playMessage("Please Select A Book To Delete");
			} else {
				myExercise.delete(myPerson);
				playMessage("Exercise Deleted");
				refresh(myPerson);
			}
		} else {
			ExerciseStrength myExercise = new ExerciseStrength();
			myExercise = tblExerciseStrength.getSelectionModel().getSelectedItem();
			if (myExercise == null) {
				playMessage("Please Select An Exercise To Delete");
			} else {
				myExercise.delete(myPerson);
				playMessage("Exercise Deleted");
				refresh(myPerson);
			}
		}
	}
}
