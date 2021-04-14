/*										TASK
 * 									StringMerge
 * 
 * 		Insert two words and print out every char alternately from wordA and wordB
 * 
 * 		Examples:
 * 					wordA: abs	wordB: sfd	= asbfsd
 * 					wordA: a	wordB: bb	= ab
 * 					wordA: ewr	wordB: w	= ew
 * 					wordA: wqeqweqweq	wordB: eqweqwe	= weqqewqewqewqe
 * 
 * 		Author: @Michał_Grzelak
 */


package stringMerge;

import java.util.Scanner;

public class StringMerge {

	public static void main(String[] args) {
		strMerge();
		
	}

	public static void strMerge() {
		Scanner scan = new Scanner(System.in);
		
		int tests = scan.nextInt();													// insert quantity of tests
		
		String q = scan.nextLine();
		
		for(int i=0; i<tests; i++) {
			String wordA = scan.nextLine();											// insert word A
			String wordB = scan.nextLine();											// insert word B
			
			int min = 0;															// -
			if(wordA.length() < wordB.length()) {									//	|
				min = wordA.length();												//	|
			}																		//	 - finding the smallest length of the words
			else {																	//	|
				min = wordB.length();												//	|
			}																		// -
			
			for(int j=0; j<min; j++) {
				System.out.print(wordA.charAt(j));									// printing chars from wordA and wordB alternately
				System.out.print(wordB.charAt(j));
			}
			System.out.println("\n");
		}
		scan.close();
	}
}
