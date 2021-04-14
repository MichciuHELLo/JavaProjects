/*								TASK
 * 								PTROL
 * 	
 * 		We have to move every element in array to the left
 * 		First element in the array has to be moved at the back of the array
 * 
 * 
 * 		Examples:
 * 					1 2 3 4 5 6 7 = 2 3 4 5 6 7 1
 * 
 * 						   2 1 10 = 1 10 2
 * 
 * 		Author: @Michał_Grzelak
 */

package rol;

import java.util.Scanner;

public class Rol {

	public static void main(String[] args) {
		rol();
	}

	public static void rol() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("How many numbers will be in the array: "); int n = scan.nextInt();		// insert quantity of numbers in array
		
		int Arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.print(+ i+1 + ". Gimme number: "); Arr[i] = scan.nextInt();					// filling the array with numbers
		}
		
		System.out.print("\nOur array: ");
		for(int i=0; i<n; i++) {
			System.out.print(Arr[i] + " ");															// printing array
		}
		
		if(n>1) {
			int bufor = Arr[0];																		// -
			for(int i=0; i<n-1; i++) {																// 	|
				Arr[i] = Arr[i+1];																	// 	 - moving all of the elements to the left
			}																						// 	|
			Arr[Arr.length-1] = bufor;																// -
			
			System.out.print("\nOur array after change: ");
			for(int i=0; i<n; i++) {
				System.out.print(Arr[i] + " ");														// printing the result
			}	
		}
		scan.close();
	}
}
