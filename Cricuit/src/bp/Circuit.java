/**
 * This package includes the business logic for the program.
 */
package bp;

/**
 * @author Caleb This class contains three variables: voltage, amperage, and
 *         resistance. This class also contains mutator, accessor, and
 *         calculation methods.
 *
 */
public class Circuit implements ICircuit {

	double voltage;
	double amperage;
	double resistance;

	/**
	 * @param args These arguments will not be used in this program.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getVoltage() {
		return voltage;
		// TODO Auto-generated method stub
	}

	@Override
	public double getAmperage() {
		return amperage;
		// TODO Auto-generated method stub
	}

	@Override
	public double getResistance() {
		return resistance;
		// TODO Auto-generated method stub
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
