/**
 * 
 */
package model;

import java.time.Duration;
import java.time.LocalDate;

/**
 * @author Caleb
 *
 */
public abstract class Exercise {
	private int studentID;
	private LocalDate exerciseDate;
	private String exerciseName;
	private Duration exerciseDuration;

	abstract void load(int pStudentID, LocalDate pExerciseDate, String pExerciseName);

	abstract void save();

	abstract void delete();

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
	 * @return the exerciseDate
	 */
	public LocalDate getExerciseDate() {
		return exerciseDate;
	}

	/**
	 * @param exerciseDate the exerciseDate to set
	 */
	public void setExerciseDate(LocalDate exerciseDate) {
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
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	/**
	 * @return the exerciseDuration
	 */
	public Duration getExerciseDuration() {
		return exerciseDuration;
	}

	public long getExerciseSeconds() {
		return exerciseDuration.toSeconds();
	}

	public long getExerciseMinutes() {
		return exerciseDuration.toMinutes();
	}

	/**
	 * @param exerciseDuration the exerciseDuration to set
	 */
	public void setExerciseDuration(Duration exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}
}
