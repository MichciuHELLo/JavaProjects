/*								 TASK
 * 						Greatest common divisor
 * 
 * 			Find the greatest common divisor of two numbers
 * 
 * 			
 * 			Examples: 		1 4 = 1
 * 							4 1 = 1
 * 							12 48 = 12
 * 							48 100 = 4
 * 							123456 654321 = 3
 * 
 * 			Author: @Michał_Grzelak
 */




package najwiekszyWspolnyDzielnik;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(System.in);
			int t = scan.nextInt();														// insert quantity of tests
			
			for(int i=0; i<t; i++) {
				int a = scan.nextInt();													// insert first number
				int b = scan.nextInt();													// insert second number
				nwd(a, b);
			}
			scan.close();
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	public static void nwd(int a, int b) {
		int max = 0;
		if(a>b) {																		// looking for bigger number
			max = a;
		}
		else {
			max = b;
		}
		
		int divisor = 1;
		for(int i=1; i<=max; i++ ) {													//looking for the greatest common divisor
			if(a%i == 0 && b%i == 0) {													//if you can divide both number by i it means that it's -
				divisor = i;															//- a common divisor
			}
		}
		System.out.println(divisor);
	}
}
