/**
 * 
 */
package model;

import java.time.LocalDateTime;

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
	public final void save() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public final void delete() {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public final void load(final int... id) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}
