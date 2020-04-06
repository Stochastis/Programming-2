/**
 * 
 */
package model;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Caleb
 *
 */
public abstract class Exercise {
	/**
	 * The students Identification Number.
	 */
	private int studentID;
	/**
	 * The date of the exercise.
	 */
	private LocalDate exerciseDate;
	/**
	 * The name of the exercise.
	 */
	private String exerciseName;
	/**
	 * How long the exercise lasted.
	 */
	private Duration exerciseDuration;

	abstract void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName);

	abstract void save(Person pPerson, boolean pBoolean) throws SQLException;

	abstract void delete(Person pPerson) throws SQLException;

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
	 * @return the exerciseDate
	 */
	public LocalDate getExerciseDate() {
		return exerciseDate;
	}

	/**
	 * @param exerciseDate the exerciseDate to set
	 */
	public void setExerciseDate(final LocalDate exerciseDate) {
		this.exerciseDate = exerciseDate;
	}

	/**
	 * @return the exerciseName
	 */
	public String getExerciseName() {
		return exerciseName;
	}

	/**
	 * @param exerciseName the exerciseName to set
	 */
	public void setExerciseName(final String exerciseName) {
		this.exerciseName = exerciseName;
	}

	/**
	 * @return the exerciseDuration
	 */
	public Duration getExerciseDuration() {
		return exerciseDuration;
	}

	/**
	 * Method for returning the duration of the exercise in seconds.
	 * 
	 * @return Returns the duration of the exercise in seconds.
	 */
	public final long getExerciseSeconds() {
		return exerciseDuration.toSeconds();
	}

	/**
	 * Method for returning the duration of the exercise in minutes.
	 * 
	 * @return Returns the duration of the exercise in seconds.
	 */
	public final long getExerciseMinutes() {
		return exerciseDuration.toMinutes();
	}

	/**
	 * @param exerciseDuration the exerciseDuration to set
	 */
	public void setExerciseDuration(final Duration exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}
}
