/**
 * This package includes the business logic for the program.
 */
package model;

/**
 * @author Caleb This class contains three variables: voltage, amperage, and
 *         resistance. This class also contains mutator, accessor, and
 *         calculation methods.
 *
 */
public class Circuit implements ICircuit {

	/**
	 * This variable stores the voltage value.
	 */
	private double voltage;
	/**
	 * This variable stores the amperage value.
	 */
	private double amperage;
	/**
	 * This variable stores the resistance value.
	 */
	private double resistance;

	/**
	 * @param args These arguments will not be used in this program.
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public final double getVoltage() {
		return voltage;
		// TODO Auto-generated method stub
	}

	@Override
	public final double getAmperage() {
		return amperage;
		// TODO Auto-generated method stub
	}

	@Override
	public final double getResistance() {
		return resistance;
		// TODO Auto-generated method stub
	}

	@Override
	public final void setVoltage(final double pVoltage) {
		voltage = pVoltage;
		// TODO Auto-generated method stub

	}

	@Override
	public final void setAmperage(final double pAmperage) {
		amperage = pAmperage;
		// TODO Auto-generated method stub

	}

	@Override
	public final void setResistance(final double pResistance) {
		resistance = pResistance;
		// TODO Auto-generated method stub

	}

	@Override
	public final void calculateVoltage() {
		voltage = amperage * resistance;
		// TODO Auto-generated method stub

	}

	@Override
	public final void calculateAmperage() {
		amperage = voltage / resistance;
		// TODO Auto-generated method stub

	}

	@Override
	public final void calculateResistance() {
		resistance = voltage / amperage;
		// TODO Auto-generated method stub

	}

}
