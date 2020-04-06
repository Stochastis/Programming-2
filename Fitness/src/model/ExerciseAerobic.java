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
public class ExerciseAerobic extends Exercise {
	/**
	 * The maximum heart rate of the person doing the exercise.
	 */
	private int maxHeartRate;
	/**
	 * The average heart rate of the person doing the exercise.
	 */
	private int averageHeartRate;
	/**
	 * The distance travelled during the exercise.
	 */
	private double distance;

	@Override
	void load(final int pStudentID, final LocalDate pExerciseDate, final String pExerciseName) {
	}

	/**
	 * @return the maxHeartRate
	 */
	public int getMaxHeartRate() {
		return maxHeartRate;
	}

	/**
	 * @param maxHeartRate the maxHeartRate to set
	 */
	public void setMaxHeartRate(final int maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}

	/**
	 * @return the averageHeartRate
	 */
	public int getAverageHeartRate() {
		return averageHeartRate;
	}

	/**
	 * @param averageHeartRate the averageHeartRate to set
	 */
	public void setAverageHeartRate(final int averageHeartRate) {
		this.averageHeartRate = averageHeartRate;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(final double distance) {
		this.distance = distance;
	}

	@Override
	public final void save(final Person pPerson, boolean pBoolean) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));
		params.add(new Parameter<LocalDate>(getExerciseDate()));
		params.add(new Parameter<String>(getExerciseName()));
		params.add(new Parameter<Long>(getExerciseSeconds()));
		params.add(new Parameter<Integer>(maxHeartRate));
		params.add(new Parameter<Integer>(averageHeartRate));
		params.add(new Parameter<Double>(distance, pBoolean));

		db.executeSql("usp_SaveExerciseAerobic", params);
	}

	@Override
	public final void delete(final Person pPerson) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));
		params.add(new Parameter<LocalDate>(getExerciseDate()));
		params.add(new Parameter<String>(getExerciseName()));

		db.executeSql("usp_DeleteExerciseAerobic", params);
	}

	/**
	 * Gets a list from the database of all Aerobic exercises associated with a
	 * student.
	 * 
	 * @param pPerson This is for the students ID.
	 * @return Returns the list of Aerobic exercises associated with the student.
	 * @throws SQLException
	 */
	public static List<ExerciseAerobic> getAll(final Person pPerson) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<ExerciseAerobic> allExercises = new ArrayList<>();
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));

		ResultSet rsExerciseAerobic = db.getResultSet("usp_GetAerobicExercisesByPerson", params);

		while (rsExerciseAerobic.next()) {
			ExerciseAerobic e = new ExerciseAerobic();
			e.setExerciseDate(rsExerciseAerobic.getDate("ExerciseDate").toLocalDate());
			e.setExerciseDuration(Duration.ofSeconds(rsExerciseAerobic.getInt("ExerciseSeconds")));
			e.setExerciseName(rsExerciseAerobic.getString("ExerciseName"));
			e.setStudentID(rsExerciseAerobic.getInt("StudentID"));
			e.averageHeartRate = rsExerciseAerobic.getInt("AverageHeartRate");
			e.distance = rsExerciseAerobic.getDouble("Distance");
			e.maxHeartRate = rsExerciseAerobic.getInt("MaxHeartRate");
			allExercises.add(e);
		}
		return allExercises;
	}
}
