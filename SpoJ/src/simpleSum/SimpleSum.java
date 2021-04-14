/*								TASK
 * 		Task is to add up all the integers given in the input. 
 * 
 * 		Example: 1 2 3 4 5 = 15
 * 
 * 		Author: @Michał_Grzelak
 */

package simpleSum;

import java.util.Scanner;

public class SimpleSum {

	public static void main(String[] args) throws java.lang.Exception{
		sum();
	}

	public static void sum() {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();												// insert number of tests
		
		int result = 0;														// initialization of variable of sum
			
		for(int i=0; i<T; i++) {
			result = 0;														// reset sum after every test
			int n = scan.nextInt();											// insert a quantity of numbers to sum
			for(int j=0; j<n; j++) {
				int number = scan.nextInt();								// insert of number to sum
				result += number;
			}
			System.out.println(result);
		}
		scan.close();
	}
}
