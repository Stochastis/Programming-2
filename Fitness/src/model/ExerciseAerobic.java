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
	private int maxHeartRate;
	private int averageHeartRate;
	private double distance;

	@Override
	void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName) {
		// TODO Auto-generated method stub

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
	public void setMaxHeartRate(int maxHeartRate) {
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
	public void setAverageHeartRate(int averageHeartRate) {
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
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	void save() {
		// TODO Auto-generated method stub

	}

	@Override
	void delete() {
		// TODO Auto-generated method stub

	}

	public static List<ExerciseAerobic> getAll(Person pPerson) throws SQLException {
		Database db = new Database("db.cberkstresser.name", "Exercise");
		List<ExerciseAerobic> allExercises = new ArrayList<>();
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(pPerson.getStudentID()));

		ResultSet rsExerciseAerobic = db.getResultSet("usp_GetAerobicExercisesByPerson", params);

		while (rsExerciseAerobic.next()) {
			ExerciseAerobic e = new ExerciseAerobic();
			e.setExerciseDate(rsExerciseAerobic.getDate("ExerciseDate").toLocalDate());
			e.setExerciseDuration(Duration.ofSeconds(rsExerciseAerobic.getInt("ExerciseSeconds")));
			System.out.println(Duration.ofSeconds(rsExerciseAerobic.getInt("ExerciseSeconds")));
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
