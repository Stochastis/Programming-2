/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * @author 214475
 *
 */
public class Toy implements IToy, IPermanentStorage {
	/**
	 * This is the unique identification number.
	 */
	private int toyID;
	/**
	 * 
	 */
	private String inspector;
	/**
	 * This will store the date and time of when the inspector entered data.
	 */
	private LocalDateTime inspectionDateTime;
	/**
	 * 
	 */
	private Circuit circuit1 = new Circuit(1);
	/**
	 * 
	 */
	private Circuit circuit2 = new Circuit(2);

	@Override
	public final int getToyID() {
		return toyID;
	}

	@Override
	public final String getInspector() {
		return inspector;
	}

	@Override
	public final LocalDateTime getInspectionDateTime() {
		return inspectionDateTime;
	}

	@Override
	public final Circuit getCircuit1() {
		return circuit1;
	}

	@Override
	public final Circuit getCircuit2() {
		return circuit2;
	}

	@Override
	public final void setToyID(final int pToyID) {
		toyID = pToyID;
		circuit1.setToyID(pToyID);
		circuit2.setToyID(pToyID);
	}

	@Override
	public final void setInspector(final String pInspector) {
		inspector = pInspector;
	}

	@Override
	public final void setInspectionDateTime(final LocalDateTime pInspectionDateTime) {
		inspectionDateTime = pInspectionDateTime;
	}

	@Override
	public final void setCircuit1(final Circuit pCircuit1) {
		circuit1 = pCircuit1;
	}

	@Override
	public final void setCircuit2(final Circuit pCircuit2) {
		circuit2 = pCircuit2;
	}

	@Override
	public final void save() throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		// ToyID, Inspector, InspectionDateTime
		params.add(new Parameter<Integer>(toyID));
		params.add(new Parameter<String>(inspector));
		params.add(new Parameter<LocalDateTime>(inspectionDateTime));

		db.executeSql("usp_SaveToy", params);

		circuit1.save();
		circuit2.save();
	}

	@Override
	public final void delete() throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(toyID));

		db.executeSql("usp_DeleteToy", params);
	}

	@Override
	public final void load(final int... id) throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(id[0]));

		// db.executeSql("usp_LoadToy", params);

		ResultSet rsToy = db.getResultSet("usp_LoadToy", params);
		if (rsToy.next()) {
			toyID = rsToy.getInt("ToyID");
			circuit1.load(toyID, 1);
			circuit2.load(toyID, 2);
		}
	}
}
