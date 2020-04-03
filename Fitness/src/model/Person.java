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
	private int studentID;
	private List<Exercise> exercises = new ArrayList<>();
	private String firstName, lastName;
	private double height, weight;
	private Gender gender;
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
	public void setStudentID(int studentID) {
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
	public void setExercises(List<Exercise> exercises) {
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
	public void setFirstName(String firstName) {
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
	public void setLastName(String lastName) {
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
	public void setHeight(double height) {
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
	public void setWeight(double weight) {
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
	public void setGender(Gender gender) {
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
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getAge() {
		return 0;
	}

	public void addExercise(Exercise pExercise) {

	}

	public void removeExercise(int IndexToRemove) {

	}

	public void load(int pStudentID) throws SQLException {
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

	public void save() throws SQLException {
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

	public void delete() throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(studentID));

		db.executeSql("usp_DeletePerson", params);
	}

	public void clearAllExercises() {
		exercises.clear();
	}

	public List<Exercise> getStrengthExercises() {
		return exercises.stream().filter(x -> x instanceof ExerciseStrength).collect(Collectors.toList());
	}

	public List<Exercise> getAerobicExercises() {
		return exercises.stream().filter(x -> x instanceof ExerciseAerobic).collect(Collectors.toList());
	}
}
