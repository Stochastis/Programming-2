/**
 * This package will be used to interface, with ui's, with the bp package.
 */
package ui;

import java.util.Scanner;

import bp.Circuit;

/**
 * @author Caleb This is the main class.
 *
 */
public class Main {

	/**
	 * @param args These arguments will not be used for this program.
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Circuit myCircuit = new Circuit();
		String userInput;

		System.out.println("What would you like to calculate?");

		do {
			System.out.println("Press 1) for voltage, " + "2) for amperage, " + "or 3) for resitance.");
			userInput = keyboard.nextLine();
		} while (!(userInput.contentEquals("1")) && !(userInput.contentEquals("2")) && !(userInput.contentEquals("3")));

		if (userInput.contentEquals("1")) {
			System.out.println("What is the amperage of the circuit?");
			userInput = keyboard.next();
			myCircuit.setAmperage(Integer.parseInt(userInput));
			System.out.println("What is the resistance of the circuit?");
			userInput = keyboard.next();
			myCircuit.setResistance(Integer.parseInt(userInput));
			myCircuit.calculateVoltage();
			System.out.println("The voltage of this circuit is " + myCircuit.getVoltage());
		} else if (userInput.contentEquals("2")) {
			System.out.println("What is the voltage of the circuit?");
			userInput = keyboard.next();
			myCircuit.setVoltage(Integer.parseInt(userInput));
			System.out.println("What is the resistance of the circuit?");
			userInput = keyboard.next();
			myCircuit.setResistance(Integer.parseInt(userInput));
			myCircuit.calculateAmperage();
			System.out.println("The amperage of this circuit is " + myCircuit.getAmperage());
		} else if (userInput.contentEquals("3")) {
			System.out.println("What is the voltage of the circuit?");
			userInput = keyboard.next();
			myCircuit.setVoltage(Integer.parseInt(userInput));
			System.out.println("What is the amperage of the circuit?");
			userInput = keyboard.next();
			myCircuit.setAmperage(Integer.parseInt(userInput));
			myCircuit.calculateResistance();
			System.out.println("The resistance of this circuit is " + myCircuit.getResistance());
		}

		keyboard.close();
		// TODO Auto-generated method stub

	}

}
