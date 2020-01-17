package ui;

import java.util.Scanner;

import bp.Circuit;
import bp.ICircuit;

/**
 * @author cross
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ICircuit myCircuit = new Circuit();
		int userChoice;

		System.out.println("purpose statement");
		System.out
				.println("Would you like to calculate \n" + "1) Voltage, \n" + "2) Amperage or \n" + "3) Resistance3?");
		userChoice = keyboard.nextInt();
		if (userChoice == 1) {
			System.out.println("Please enter amperage");
			myCircuit.setAmperage(keyboard.nextDouble());

			System.out.println("Please enter resistance");
			myCircuit.setResistance(keyboard.nextDouble());

			myCircuit.calculateVoltage();

			System.out.println("The voltage is " + myCircuit.getVoltage());
		}

		keyboard.close();

	}\\Comment

}
