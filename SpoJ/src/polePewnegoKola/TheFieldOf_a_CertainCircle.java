/*												TASK	
 * 									The field of a certain circle 
 * 
 * 		Find the area of a circle whose circle is the intersection of two identical spheres with radius r. 
 * 		The distance between the centers of the spheres is d. 
 * 		The input values of r and d are floating-point numbers. 
 * 		It can be assumed that 1 <= d <2 * r <= 2000. 
 * 
 * 
 * 												|\
 *  											| \
 *   										d	|  \
 *    										-	|   \  r
 *     										2	|    \
 *      										|     \
 *       										-------
 * 												  a^2
 * 
 * 		Examples:
 * 					r = 10, d = 10, The field of a certain circle = 235.62
 * 					r = 1000, d = 1500, The field of a certain circle = 1374446.79
 * 
 * 		
 * 		Author: @Michał_Grzelak
 */



package polePewnegoKola;

import java.util.Scanner;

public class TheFieldOf_a_CertainCircle {

	public static void main(String[] args) {
		Field();
	}

	public static void Field(){
		Scanner scan = new Scanner(System.in);
		
		double r = scan.nextDouble();											// insert radius
		double d = scan.nextDouble();											// insert the distance between the centers of the spheres
		
		double pi = 3.141592654;												// pi
		
		double aSquare = Math.pow(r, 2) - Math.pow(d/2, 2);						// @Pythagorean theorem
		
		System.out.println(pi * aSquare);										// Printing a field of a circle
		
		scan.close();
	}
	
}
