/*										MY CALCULATOR
 * 
 * 	In this calculator you can make operations like Sum, Subtraction, Multiplication, Dividing
 * 	Modulo, Power, Square root and Cube root.
 * 
 * 
 * 	Author: @Michał_Grzelak
 * 
 */


package kalkulator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		menu();
	}

		
	static void menu(){
		
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		do {
			double a = 0; 
			double b = 0;
			
			System.out.println("Choose what you wanna do: ");									//	-
			System.out.println("1: Sum of two numbers.");										//	 |
			System.out.println("2: Subtraction of two numbers. ");								//	 |
			System.out.println("3: Multiplication of two numbers. ");							//	 |
			System.out.println("4: Dividing two numbers. ");									//	 |
			System.out.println("5: Modulo two numbers. ");										//	  -	Prints menu
			System.out.println("6: The power of two numbers. ");								//	 |
			System.out.println("7: Square root  of two numbers. ");								//	 |
			System.out.println("8: Cube root cube of two numbers.");							//	 |
			System.out.println("0: Leave the program.");										//	 |
			System.out.print("\nYour choice: ");												//	-
			
			
			try {
				choice = scan.nextInt();														// asking for choice of action
			}
			catch(InputMismatchException e){
				error();
			}
			
			switch(choice) {																	// switch with methods of all of the math operations
			case 1:
				System.out.print("Gimme two numbers: ");
				try {
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + sum(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 2:
				try {
					System.out.print("Gimme two numbers: ");
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + subtraction(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 3:
				try {
					System.out.print("Gimme two numbers: ");
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + multiplication(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 4:
				try {
					System.out.print("Gimme two numbers: ");
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + division(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 5:
				try {
					System.out.print("Gimme two numbers: ");
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + modulo(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
				
			case 6:
				try {
					System.out.print("Gimme two numbers: ");
					a = scan.nextInt();
					b = scan.nextInt();
					System.err.println("\nResult: " + pow(a, b) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 7:
				try {
					System.out.print("Gimme one numbers: ");
					a = scan.nextInt();
					System.err.println("\nResult: " + sqrt(a) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			case 8:
				try {
					System.out.print("Gimme one numbers: ");
					a = scan.nextInt();
					System.err.println("\nResult: " + cbrt(a) + "\n\n");
					break;
				}
				catch(InputMismatchException e){
					error();
					return;
				}
			default:
				if(choice != 0) {
					System.err.println("\nError - wrong insert! Try entering correct number again." + "\n\n");
					break;
				}
			}
		}while (choice != 0);
		System.err.println("\nThanks for using my calculator.");
		scan.close();
	}
		
	public static double sum(double a, double b) { return a+b; }								// method of sum
		
	public static double subtraction(double a, double b) { return a-b; }						// method of subtraction
		
	public static double multiplication(double a, double b) { return a*b; }						// method of multiplication
		
	public static double division(double a, double b) { return a/b;	}							// method of division
		
	public static double modulo(double a, double b) { return a%b; }								// method of modulo
		
	public static double pow(double a, double b) { return Math.pow(a, b); }						// method of power
	
	public static double sqrt(double a) { return Math.sqrt(a); } 								// method of square root
	
	public static double cbrt(double a) { return Math.sqrt(a); } 								// method of cube root
	
	public static void error( ) {																// method of error
		System.err.println("\nThis is not a number!");											//  this method is used when user will -
		System.err.println("Reset the calculator and try again.\n");							//  - insert char instead of integer
	}
}
