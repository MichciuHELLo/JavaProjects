/*						TASK
		In first line C, 1 ≤ C ≤ 50 means quantity of tests.
		In next C lines insert chain of big letters.
		Every test has at least one letter
		Length of the test max 200 chars.
		
		Examples:
		OPSS	=	OPSS
		ABCDEF	=	ABCDEF
		ABBCCCDDDDEEEEEFGGHIIJKKKL	=	ABBC3D4E5FGGHIIJK3L
		AAAAAAAAAABBBBBBBBBBBBBBBB	=	A10B16
		
		Author: @Michał_Grzelak
*/

package flamaster;

import java.util.Scanner;

public class Flamaster {

	public static void main(String[] args) {
		try {
			flamaster();
		}
		catch(Throwable e){
			System.out.println(" Something went wrong.");
			return;
		}
	}
	
	public static void flamaster()	{
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();															// insert quantity of tests
		
		for(int i=0; i<=c; i++) {														// loop of tests
			int count = 1;																// variable counting quantity of same letters
			String line = scan.next();													// line = testing chain of letters
			line = line.toUpperCase();

				for(int j=0; j<line.length(); j++) {									// loop of line
					if(j == line.length()-1 || line.charAt(j) != line.charAt(j+1)) {	// if testing letter is the last one or the next letter isn't the same, prepare to display
						if(count < 3) {													// -
							for(int k=0; k<count; k++) {								//	|
								System.out.print(line.charAt(j));						//	|
							}															//	|
							count = 1;													//	 - condition of the task
						}																//	|
						else {															//	|
							System.out.print(line.charAt(j) + "" + count);				//	|
							count = 1;													//	|
						}																// -
					}
					else {
						count++;
					}
				}
			System.out.println("");
		}
		scan.close();
	}
}
