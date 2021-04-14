/*								TASK
 *						 Hilarious Adding Peter 
 * 
 * 			Peter has a goal to make a palindrome (121, 1111) from a given him number.
 * 			If a number that he gets isn't a palindrome he sum this number to the same number but back words
 * 
 * 			Example: Peter gets number 28 but it isn't a palindrome so he sum 28 to 82
 * 					  but 28 + 82 = 110 which isn't a palindrome also. So he sum 110 + 011
 * 					  110 + 11 = 121 <-- Peter's goal
 * 
 * 
 * 			@Author Michał_Grzelak
 */





package funnySumPiotr;

import java.util.Scanner;

public class FunnySumPiotr {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();														// insert quantity of tests
		
		for(int i=0; i<t; i++) {
			int n = scan.nextInt();													// insert testing number
			int count = 0;															// int initialization to count the number of sum operations 
			
			if(n<10) {																
				System.out.println(n + " " + count);								// prints the answer if inserted number is lower then 10
			}
			else {
				boolean palindrom = false;											// palindrom will be false until finding it true
				while(!palindrom) {
					String number  = String.valueOf(n);								// copy of searching int number into string
					String buforS = "";
					
					for(int j=number.length()-1; j>=0; j--) {
						buforS += number.charAt(j);									// writing a number back words into buforS
					}
					int buforI = Integer.parseInt(buforS);							// setting buforI as a integer copy of buforS
					if(buforS.equals(number)) {										// if buforS = number we found our palindrome
						System.out.println(buforS + " " + count + "\n");
						palindrom = true;
					}
					else {															// if buforS != number we do a sum like 28 + 82
						n += buforI;												// |
						count++;													// adding +1 to quantity of sum operations
					}
				}
			}
		}
		scan.close();
	}
}
