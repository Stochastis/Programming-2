/**
 * 
 */
package bp;

/**
 * @author cross
 *
 */
public class Circuit implements ICircuit {
	private double voltage;
	private double amperage;
	private double resistance;

	@Override
	public double getVoltage() {
		// TODO Auto-generated method stub
		return voltage;
	}

	@Override
	public double getAmperage() {
		// TODO Auto-generated method stub
		return amperage;
	}

	@Override
	public double getResistance() {
		// TODO Auto-generated method stub
		return resistance;
	}

	@Override
	public void setVoltage(double pVoltage) {
		voltage = pVoltage;
		// TODO Auto-generated method stub

	}

	@Override
	public void setAmperage(double pAmperage) {
		amperage = pAmperage;
		// TODO Auto-generated method stub

	}

	@Override
	public void setResistance(double pResistance) {
		resistance = pResistance;
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateVoltage() {
		voltage = amperage * resistance;
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateAmperage() {
		amperage = voltage / resistance;
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateResistance() {
		resistance = voltage / amperage;
		// TODO Auto-generated method stub

	}

}
