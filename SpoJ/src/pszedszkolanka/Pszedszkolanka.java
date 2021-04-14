/*									TASK
 * 		Kindergarten teacher the next day will have one of two groups of kids 
 * 		She has to bring to kindergarten good amount of candies to feed every kid 
 * 		She has to give away everything and every kid has to get same amount of sweets
 * 
 * 		Examples:
 * 		Number of kids in groups: 12 15 = 60 candies
 * 		Number of kids in groups: 11 22 = 22 candies
 * 
 * 		Author: @Michał_Grzelak
 */

package pszedszkolanka;

import java.util.Scanner;

public class Pszedszkolanka {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Scanner scan = new Scanner(System.in);
		int N = 0;
		N = scan.nextInt();															// insert number of tests
		
		try {
			for(int i=0; i<N; i++) {
				int a=0, b=0;
				a = scan.nextInt(); b = scan.nextInt();								// insert quantity of kids in the groups
				
				int grA = a;
				int grB = b;
				
				while (a!=b) {														// keep looking until finding common denominator 
					if(a<b) {
						a+=grA;
					}
					else if(a>b) {
						b+=grB;
					}
				}
				System.out.println(a);												// print the answer 
			}
		}
		catch(Exception e) {
			System.out.println(" Something went wrong.");
		}
		finally {
			scan.close();
		}
	}
}
