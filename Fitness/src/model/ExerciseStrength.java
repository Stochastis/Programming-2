/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * @author Caleb
 *
 */
public class ExerciseStrength extends Exercise {
	private int sets;
	private int reps;
	private double weightLifted;

	@Override
	void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}

	/**
	 * @param sets the sets to set
	 */
	public void setSets(int sets) {
		this.sets = sets;
	}

	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}

	/**
	 * @param reps the reps to set
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}

	/**
	 * @return the weightLifted
	 */
	public double getWeightLifted() {
		return weightLifted;
	}

	/**
	 * @param weightLifted the weightLifted to set
	 */
	public void setWeightLifted(double weightLifted) {
		this.weightLifted = weightLifted;
	}

	@Override
	void save() {
		// TODO Auto-generated method stub

	}

	@Override
	void delete() {
		// TODO Auto-generated method stub

	}

	public static List<ExerciseStrength> getAll(Person pPerson) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<ExerciseStrength> allExercises = new ArrayList<>();
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));

		ResultSet rsExerciseStrength = db.getResultSet("usp_GetStrengthExercisesByPerson", params);

		while (rsExerciseStrength.next()) {
			ExerciseStrength e = new ExerciseStrength();
			e.setExerciseDate(rsExerciseStrength.getDate("ExerciseDate").toLocalDate());
			e.setExerciseDuration(Duration.ofSeconds(rsExerciseStrength.getInt("ExerciseSeconds")));
			e.setExerciseName(rsExerciseStrength.getString("ExerciseName"));
			e.setStudentID(rsExerciseStrength.getInt("StudentID"));
			e.reps = rsExerciseStrength.getInt("Reps");
			e.sets = rsExerciseStrength.getInt("Sets");
			e.weightLifted = rsExerciseStrength.getInt("WeightLifted");
			allExercises.add(e);
		}
		return allExercises;
	}
}
