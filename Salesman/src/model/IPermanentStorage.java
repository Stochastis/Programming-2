package model;

import java.sql.SQLException;

/**
 * This interface defines the methods needed to save data to permanent storage.
 * 
 * @author cberkstresser
 * @version 1.2
 */
public interface IPermanentStorage {
	/**
	 * Saves the values stored in the class to permanent storage.
	 * 
	 * @throws SQLException
	 */
	void save() throws SQLException;

	/**
	 * Deletes the currently loaded values from permanent storage.
	 * 
	 * @throws SQLException
	 */
	void delete() throws SQLException;

	/**
	 * Loads a saved circuit from permanent storage.
	 * 
	 * @param id The unique identifier of the class item to load.
	 * @throws SQLException
	 */
	void load(int... id) throws SQLException;
}