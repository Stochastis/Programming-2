/**
 * 
 */
package model;

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
	private double voltage, amperage, resistance;
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
		return amperage;
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
