/*												TASK
 * 											  Gluttons
 * 
 * 		We need to count how many packs of cookies we have to buy to make sure that there will be enough cookies to feed Gluttons for 24 hrs.
 * 		We know how many Gluttons there are.
 * 		We know how many cookies in a pack is.
 * 		We know how long it takes to eat a cookie by every Glutton.
 * 
 * 		Gluttons eats cookies all the time. If he finish one cookie he starts to eat another one immediately.
 * 		If Glutton knows that he has no time to eat another cookie because it is the end of the day he can't start eating.
 * 		
 * 
 * 		Examples:
 * 					2 - Gluttons 
 * 					10 - cookies in a pack
 * 					3600 - time of eating cookie by first Glutton in seconds
 * 					1800 - time of eating cookie by second Glutton in seconds
 * 					Answer: 8 - we need to buy 8 packs of cookies
 * 
 * 					----------------------------------------------------------
 * 
 * 					3 - Gluttons 
 * 					123 - cookies in a pack
 * 					32999 - time of eating cookie by first Glutton in seconds
 * 					10101 - time of eating cookie by second Glutton in seconds
 * 					Answer: 2 - we need to buy 8 packs of cookies
 * 
 * 		
 * 		Author: @Michał_Grzelak
 */


package obżartuchy;

import java.util.Scanner;

public class Glutton {

	public static void main(String[] args) {
		cookies();
	}

		public static void cookies() {
			
			int secsInDay = 86400;																					// seconds in day
			double needCookies = 0;
			
			Scanner scan = new Scanner(System.in);
			System.out.print("How many tests you want to have: ");
			int tests = scan.nextInt();																				// quantity of tests
			
			for(int i=0; i<tests; i++) {
				System.out.print("How many Gluttons there are: ");
				int gluttons = scan.nextInt();																		// quantity of Gluttons
				
				System.out.print("How many cookies are in one pack: ");
				int inPack = scan.nextInt();																		// cookies in one pack
				
				for(int j=1; j<=gluttons; j++) {
					System.out.print("How long it take to eat one cookie by Glutton number " + "" + j + ": ");
					int eatingTime = scan.nextInt();																// time of consumption
					needCookies += Math.floor(secsInDay / eatingTime) ;												// sum of all cookies we need
				}
				System.out.println("Gluttons will eat " + (int) needCookies + " cookies.");							// printing a sum of all cookies we need
				double needPacks =  Math.ceil((double) needCookies / inPack);										// rounding up number of needed packs of cookies
				System.out.println("So we need " + (int) needPacks + " packs of cookies \n");						// printing a sum of all packs of cookies we need
			}
			scan.close();
		}
}
