package main;

import java.util.Scanner;

public class basicCalculator {

	/**
	 * Basic Calculator Program Algorithm:
	 *
	 * - Display welcome message for the calculator offering addition and subtraction.
	 *
	 * - Use a while loop for user inputs:
	 *     - Prompt the user to choose between addition (1) or subtraction (2).
	 *     - Read and process user's choice.
	 *
	 * - If the choice is addition:
	 *     - Prompt the user for numbers to add.
	 *     - Calculate the sum and display the result with two decimal places.
	 *
	 * - If the choice is subtraction:
	 *     - Prompt the user for numbers to subtract.
	 *     - Calculate the result and display it with two decimal places.
	 *     - Handle cases where there are not enough numbers for subtraction.
	 *
	 * - If the user's choice is not 1 or 2, display "Operation not supported."
	 *
	 * - Ask the user if they want to perform another operation (y/yes):
	 *     - Exit the loop if the answer is not "y" or "yes."
	 *
	 * - Display "Goodbye!" and close the scanner.
	 */


	public static void main(String[] args) {

		// Create a scanner for user input
		Scanner scanner = new Scanner(System.in);
		String choice;

		// Welcome message
		System.out.println("Welcome to Your Personal Calculator!");

		// Main loop for user interaction
		while (true) {

			// Prompt user to choose an operation
			System.out.println("Choose your math adventure: [1] Addition, [2] Subtraction, [3] Multiplication, [4] Division:");
			choice = scanner.nextLine();

			// Process user's choice
			if (choice.equals("1")) {
				// Addition
				calculate("Addition", "+", scanner);
			} else if (choice.equals("2")) {
				// Subtraction
				calculate("Subtraction", "-", scanner);
			} else if (choice.equals("3")) {
				// Multiplication
				calculate("Multiplication", "*", scanner);
			} else if (choice.equals("4")) {
				// Division
				calculate("Division", "/", scanner);
			} else {
				System.out.println("Sorry, that operation is not supported!");
			}

			// Ask if the user wants to continue
			System.out.print("Would you like to explore more? (y/yes): ");
			String again = scanner.nextLine().toLowerCase();

			// Exit loop if user doesn't want to continue
			if (!again.equals("y") && !again.equals("yes")) {
				System.out.println("Thanks for calculating with us. Goodbye!");
				break;
			}
		}

		// Close the scanner
		scanner.close();
	}

	/**
	 * Perform calculation based on the user's choice of operation.
	 *
	 * @param operation The name of the operation (e.g., Addition, Subtraction)
	 * @param symbol    The symbol of the operation (e.g., +, -, *, /)
	 * @param scanner   Scanner object for user input
	 */
	private static void calculate(String operation, String symbol, Scanner scanner) {
		System.out.print("Enter numbers to perform " + operation + ", separated by spaces: ");
		String[] input = scanner.nextLine().split(" ");
		int count = Integer.parseInt(input[0]);
		double result = 0.0;

		if (count >= 2) {
			result = Double.parseDouble(input[1]);

			for (int i = 2; i <= count; i++) {
				double num = Double.parseDouble(input[i]);
				switch (symbol) {
					case "+":
						result += num;
						break;
					case "-":
						result -= num;
						break;
					case "*":
						result *= num;
						break;
					case "/":
						if (num != 0) {
							result /= num;
						} else {
							System.out.println("Cannot divide by zero!");
							return;
						}
						break;
				}
			}

			System.out.println("Result of your " + operation.toLowerCase() + " adventure: " + String.format("%.2f", result));
		} else {
			System.out.println("Not enough numbers for " + operation.toLowerCase() + ".");
		}
	}
}
