/**
 * 
 */
package model;

/**
 * @author 214475
 *
 */
public class Circuit implements ICircuit {
	private int toyID, circuitID;
	private double voltage, amperage, resistance;
	private String manufactureLocation;

	@Override
	public int getToyID() {
		return toyID;
	}

	@Override
	public int getCircuitID() {
		return circuitID;
	}

	@Override
	public double getVoltage() {
		return voltage;
	}

	@Override
	public double getAmperage() {
		return amperage;
	}

	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public String getManufactureLocation() {
		return manufactureLocation;
	}

	@Override
	public void setToyID(int pToyID) {
		toyID = pToyID;
	}

	@Override
	public void setCircuitID(int pCircuitID) {
		circuitID = pCircuitID;
	}

	@Override
	public void setVoltage(double pVoltage) {
		voltage = pVoltage;
	}

	@Override
	public void setResistance(double pResistance) {
		resistance = pResistance;
	}

	@Override
	public void setManufactureLocation(String pManufactureLocation) {
		manufactureLocation = pManufactureLocation;
	}

}
