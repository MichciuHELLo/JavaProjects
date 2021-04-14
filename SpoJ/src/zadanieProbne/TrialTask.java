/*				TASK
 * 			 Trail Task
 * 
 * 	     	Simple adding 
 * 
 * 		Example: 2 + 3 = 5
 * 
 * 		Author: @Michał_Grzelak
 */

package zadanieProbne;

import java.util.Scanner;

public class TrialTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		System.out.println(task(A, B));
		
		scan.close();
	}

	public static int task(int A, int B) {
		return A+B;
	}
}
