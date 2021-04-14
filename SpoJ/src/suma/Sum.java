/*											TASK
 * 										  	SUM
 * 
 * 		A program that asks for an integer and prints the sum of all inserted numbers.
 * 
 * 
 * 		Author: @Michał_Grzelak
 */


package suma;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		int sum = 0;
		
		while(num != 0) {										// asks for a new number until user will enter 0
			num = scan.nextInt();
			sum += num;
			System.out.println(sum);							// prints sum
		}
		System.out.println("That's it.");
		scan.close();
		
	}

}
