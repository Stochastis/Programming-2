/**
 * 
 */
package model;

import java.time.LocalDateTime;

/**
 * @author 214475
 *
 */
public class Toy implements IToy {
	private int toyID;
	private String inspector;
	private LocalDateTime inspectionDateTime;
	private Circuit circuit1, circuit2;

	@Override
	public int getToyID() {
		return toyID;
	}

	@Override
	public String getInspector() {
		return inspector;
	}

	@Override
	public LocalDateTime getInspectionDateTime() {
		return inspectionDateTime;
	}

	@Override
	public Circuit getCircuit1() {
		return circuit1;
	}

	@Override
	public Circuit getCircuit2() {
		return circuit2;
	}

	@Override
	public void setToyID(int pToyID) {
		toyID = pToyID;
	}

	@Override
	public void setInspector(String pInspector) {
		inspector = pInspector;
	}

	@Override
	public void setInspectionDateTime(LocalDateTime pInspectionDateTime) {
		inspectionDateTime = pInspectionDateTime;
	}

	@Override
	public void setCircuit1(Circuit pCircuit1) {
		circuit1 = pCircuit1;
	}

	@Override
	public void setCircuit2(Circuit pCircuit2) {
		circuit2 = pCircuit2;
	}

}
