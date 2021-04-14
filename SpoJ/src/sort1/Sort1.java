/*																TASK
 * 							 								   SORT 1
 * 		We have list of points on Cartesian system which we have to print out in sorted way relative to the distance from the sun (0,0).
 * 	 
 * 		Examples: 
 * 					Point: A 0 0
 *					Point: C 5 5
 *					Point: B 1 -1
 *	
 *			Answer:
 *					A 0 0
 *					B 1 -1
 *					C 5 5
 * 
 * 
 * 		Author: @Michał_Grzelak
 */


package sort1;

import java.util.ArrayList;
import java.util.Scanner;

public class Sort1 {

	public static void main(String[] args) {
		sort();
	}
		
	public static void sort() {
		ArrayList<String> coOrdinates = new ArrayList<>();
		ArrayList<Double> distance = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Give me how many tests you wanna make: "); int tests = scan.nextInt();						// insert quantity of tests
		
		for(int i=0; i<tests; i++) {
			System.out.print("Tell me how many points you wanna compare: "); int points = scan.nextInt();				// insert how many points there are on Cartesian system
			for(int j=0; j<points; j++) {
				System.out.print("Give me name of point: "); String letter = scan.next();								// insert name of point
				System.out.print("Give me X of point: "); String coOrd1 = scan.next();									// insert X of point
				System.out.print("Give me Y of point: "); String coOrd2 = scan.next();									// insert Y of point
				coOrdinates.add(letter);																				// adding name to ArrayList
				coOrdinates.add(coOrd1);																				// adding X to ArrayList
				coOrdinates.add(coOrd2);																				// adding Y to ArrayList
				
				distance.add(Math.sqrt(Math.pow(Integer.valueOf(coOrd1), 2) + Math.pow(Integer.valueOf(coOrd2), 2)));	// measuring and adding the distance of the point from 0, 0 to the list
			}
			
			System.out.print("\n\nOur points in a list: " + coOrdinates);												// printing coordinates
			System.out.print("\nDistances of points to the sun in a list: " + distance + "\n\n");						// printing measured distances
			
			double max = 1500;																							//
			double min = -1500;																							//
			int index = 0;																								//
																														//
			if(points>1) {																								//
				for(int j=0; j<points; j++) {																			//-
					for(int k=0; k<distance.size(); k++) {																// |
						if(distance.get(k) > min && distance.get(k) < max) {											//  - looking for the smallest distance from the list
							max = distance.get(k);																		// |
							index = k * 3;																				//- showing the counterpart in the second list  
						}																								//
					}																									//
					min = max;																							//
					max = 1500;																							//
					
					for(int k=0; k<3; k++) {																			//
						System.out.print(coOrdinates.get(index) + " ");													// printing the name of point and his coordinates
						index++;																						//
					}																									//
					System.out.print("\n");
				}
			}
			else {
				System.out.print(coOrdinates);																			// if we decided to insert only one point program is printing only the existing list -
			}																											// because there is nothing to compare the point with 
		}
		scan.close();
	}
}
