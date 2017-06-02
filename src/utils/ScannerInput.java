package utils;

import java.util.Scanner;

/**
 * This class will retrieve inputs and ensure there are no errors in the inputs
 *
 * 
 */

public class ScannerInput {

    /**
     * makes sure  the user inputs an integer when this method is called by another method
     * Also works around the scanner input buffer bug
     *
     * @param prompt a String that will be displayed when called by a method
     */
    public static int validNextInt(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return input.nextInt();
            } catch (Exception e) {
                input.nextLine();//swallows the buffer contents
                System.err.println("\tEnter a number please ");
            }
        } while (true);

    }

    /**
     * Ensures the user inputs a double when this method is called by another method
     * Also works around the scanner input buffer bug
     *
     * @param prompt a String that will be displayed when called by a method
     */
    public static double validNextDouble(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return input.nextDouble();
            } catch (Exception e) {
                input.nextLine();//swallows the buffer contents
                System.err.println("\tEnter a number please ");
            }
        } while (true);

    }

	/**
     * makes sure there is a sting entered
     * Also works around the scanner input buffer bug
     *
     * @param prompt a String that will be displayed when called by a method
	 */
    public static String validNextString(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print(prompt);
            return input.nextLine().trim().toLowerCase();
        } while (true);
    }
}