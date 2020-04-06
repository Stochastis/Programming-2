/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import db.Database;
import db.Parameter;

/**
 * @author Caleb
 *
 */
public class Person {
	/**
	 * The students unique Identification Number.
	 */
	private int studentID;
	/**
	 * The list of exercises associated with the student.
	 */
	private List<Exercise> exercises = new ArrayList<>();
	/**
	 * The first and last name of the student.
	 */
	private String firstName, lastName;
	/**
	 * The height (inches) and weight (pounds) of the student.
	 */
	private double height, weight;
	/**
	 * The gender of the student.
	 */
	private Gender gender;
	/**
	 * The birthdate of the student.
	 */
	private LocalDate birthdate;

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(final int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the exercises
	 */
	public List<Exercise> getExercises() {
		return exercises;
	}

	/**
	 * @param exercises the exercises to set
	 */
	public void setExercises(final List<Exercise> exercises) {
		this.exercises = exercises;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(final double height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(final double weight) {
		this.weight = weight;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(final LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * This method returns the age of the student.
	 * 
	 * @return Returns the age of the student.
	 */
	public final int getAge() {
		return 0;
	}

	/**
	 * Method for adding an exercise to the students list of exercises.
	 * 
	 * @param pExercise The exercise to be added to the list.
	 */
	public void addExercise(final Exercise pExercise) {

	}

	/**
	 * Method for loading the student from the databse into the program.
	 * 
	 * @param pStudentID The student's identification number.
	 * @throws SQLException
	 */
	public final void load(final int pStudentID) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(studentID));

		ResultSet rsPerson = db.getResultSet("usp_GetPerson", params);
		rsPerson.next();

		String genderString = rsPerson.getString("Gender").toUpperCase();
		// Debugging: Proper genderString here.
		if (genderString.equals("MALE") && genderString.equals("FEMALE")) {
			gender = Gender.UNSPECIFIED;
		} else {
			gender = Gender.valueOf(genderString);
		}
		birthdate = rsPerson.getDate("Birthdate").toLocalDate();
		firstName = rsPerson.getString("FirstName");
		lastName = rsPerson.getString("LastName");
		height = rsPerson.getDouble("Height");
		weight = rsPerson.getDouble("Weight");
	}

	/**
	 * Method for saving a new student into the database from the program.
	 * 
	 * @throws SQLException
	 */
	public final void save() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(studentID));
		params.add(new Parameter<String>(firstName));
		params.add(new Parameter<String>(lastName));
		params.add(new Parameter<Double>(height));
		params.add(new Parameter<Double>(weight));
		params.add(new Parameter<String>(gender.toString()));
		params.add(new Parameter<LocalDate>(birthdate));

		db.executeSql("usp_SavePerson", params);

	}

	/**
	 * Method from deleting a student from the database.
	 * 
	 * @throws SQLException
	 */
	public final void delete() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(studentID));

		db.executeSql("usp_DeletePerson", params);
	}

	/**
	 * Method for removing all exercises from a student's list.
	 */
	public final void clearAllExercises() {
		exercises.clear();
	}

	/**
	 * Method for retrieving a full list of Strength Exercises associated with the
	 * student.
	 * 
	 * @return Returns a full list of Strength Exercises associated with the
	 *         student.
	 */
	public final List<Exercise> getStrengthExercises() {
		return exercises.stream().filter(x -> x instanceof ExerciseStrength).collect(Collectors.toList());
	}

	/**
	 * Method for retrieving a full list of Aerobic Exercises associated with the
	 * student.
	 * 
	 * @return Returns a full list of Aerobic Exercises associated with the student.
	 */
	public final List<Exercise> getAerobicExercises() {
		return exercises.stream().filter(x -> x instanceof ExerciseAerobic).collect(Collectors.toList());
	}
}
