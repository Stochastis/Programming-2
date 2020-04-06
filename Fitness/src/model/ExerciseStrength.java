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
	/**
	 * The number of sets of the exercise.
	 */
	private int sets;
	/**
	 * The repetitions per set of the exercise.
	 */
	private int reps;
	/**
	 * The weight lifted each repetition during the exercise.
	 */
	private double weightLifted;

	@Override
	void load(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
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
	public void setSets(final int sets) {
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
	public void setReps(final int reps) {
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
	public void setWeightLifted(final double weightLifted) {
		this.weightLifted = weightLifted;
	}

	@Override
	public final void save(final Person pPerson, boolean pBoolean) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));
		params.add(new Parameter<LocalDate>(getExerciseDate()));
		params.add(new Parameter<String>(getExerciseName()));
		params.add(new Parameter<Long>(getExerciseSeconds()));
		params.add(new Parameter<Integer>(reps));
		params.add(new Parameter<Integer>(sets));
		params.add(new Parameter<Double>(weightLifted));

		db.executeSql("usp_SaveExerciseStrength", params);
	}

	@Override
	public final void delete(final Person pPerson) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));
		params.add(new Parameter<LocalDate>(getExerciseDate()));
		params.add(new Parameter<String>(getExerciseName()));

		db.executeSql("usp_DeleteExerciseStrength", params);
	}

	/**
	 * Gets a list from the database of all the Strength Exercises associated with a
	 * student.
	 * 
	 * @param pPerson Used for the student ID.
	 * @return Returns the list of Strength Exercises associated with the student.
	 * @throws SQLException
	 */
	public static List<ExerciseStrength> getAll(final Person pPerson) throws SQLException {
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
