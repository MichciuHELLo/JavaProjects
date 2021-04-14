/*								 TASK
 * 					   	   		ARRAYS
 * 
 * 						Insert how big array will be
 * 	Insert numbers to the array and then print out everything back words
 * 
 * 			Examples: 
 * 					  in: 1 2 3 4 5 6   	out: 6 5 4 3 2 1
 * 
 * 			Author: @Michał_Grzelak
 */


package tablice;

import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		arr();
	}

	public static void arr() {
		
		Scanner scan = new Scanner(System.in);
				
		int t = scan.nextInt();														// insert quantity of tests
		
		for(int i=0; i<t; i++) {
			int n = scan.nextInt();													// insert how big array will be
			int []  ar = new int [n];
			
			for(int j=0; j<n; j++) {
				ar[j] = scan.nextInt();												// fill an array with an ints
			}
			
			for(int j=ar.length-1; j>=0; j--) {
				System.out.print(ar[j] + " ");										// print an array back words
			}
			System.out.println("");
		}
		scan.close();
	}
}
