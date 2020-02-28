/**
 * 
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.Parameter;

/**
 * @author 214475
 *
 */
public class Circuit implements ICircuit, IPermanentStorage {
	/**
	 * toyID will identify each toy individually. circuitID will identify each
	 * circuit individually.
	 */
	private int toyID, circuitID;
	/**
	 * voltage, amperage, and resistance will store the values of individual
	 * circuits.
	 */
	private double voltage, resistance;
	/**
	 * manufactureLocation will store where the circuits were created.
	 */
	private String manufactureLocation;

	/**
	 * 
	 * @param pCircuitID This parameter prevents a user from creating a circuit
	 *                   without an identification number.
	 */
	public Circuit(final int pCircuitID) {
		circuitID = pCircuitID;
	}

	@Override
	public final int getToyID() {
		return toyID;
	}

	@Override
	public final int getCircuitID() {
		return circuitID;
	}

	@Override
	public final double getVoltage() {
		return voltage;
	}

	@Override
	public final double getAmperage() {
		return voltage / resistance;
	}

	@Override
	public final double getResistance() {
		return resistance;
	}

	@Override
	public final String getManufactureLocation() {
		return manufactureLocation;
	}

	@Override
	public final void setToyID(final int pToyID) {
		toyID = pToyID;
	}

	@Override
	public final void setCircuitID(final int pCircuitID) {
		circuitID = pCircuitID;
	}

	@Override
	public final void setVoltage(final double pVoltage) {
		voltage = pVoltage;
	}

	@Override
	public final void setResistance(final double pResistance) {
		resistance = pResistance;
	}

	@Override
	public final void setManufactureLocation(final String pManufactureLocation) {
		manufactureLocation = pManufactureLocation;
	}

	@Override //This will save a circuit to the database.
	public final void save() throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		// ToyID, CircuitID, ManufactureLocation, Voltage, Amperage, Resistance
		params.add(new Parameter<Integer>(toyID));
		params.add(new Parameter<Integer>(circuitID));
		params.add(new Parameter<String>(manufactureLocation));
		params.add(new Parameter<Double>(voltage));
		params.add(new Parameter<Double>(getAmperage()));
		params.add(new Parameter<Double>(resistance));

		db.executeSql("usp_SaveCircuit", params);
	}

	@Override //This will delete a circuit from the database.
	public final void delete() throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(toyID));

		db.executeSql("usp_DeleteCircuit", params);
	}

	@Override //This will load a circuit from the database.
	public final void load(final int... id) throws SQLException {
		Database db = new Database("db.cberkstresser.name");
		List<Parameter<?>> params = new ArrayList<>();

		params.add(new Parameter<Integer>(id[0]));
		params.add(new Parameter<Integer>(id[1]));

		ResultSet rsCircuit = db.getResultSet("usp_LoadCircuit", params);
		if (rsCircuit.next()) {
			toyID = rsCircuit.getInt("ToyID");
			circuitID = rsCircuit.getInt("CircuitID");
			voltage = rsCircuit.getDouble("Voltage");
			resistance = rsCircuit.getDouble("Resistance");
			manufactureLocation = rsCircuit.getString("ManufactureLocation");
		}
	}
}
