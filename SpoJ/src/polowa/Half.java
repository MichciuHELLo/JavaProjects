package polowa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Half {

	public static void main(String[] args) {
		half();
	}

	public static void half(){
		Scanner scan = new Scanner(System.in);
		
		try {
			int words = scan.nextInt();
			
			for(int i=0; i<words; i++) {
				String word = scan.next();
				for(int j=0; j<word.length()/2; j++) {
					System.out.print(word.charAt(j));
				}
				System.out.println("");
			}
			scan.close();
		}
		catch(InputMismatchException e){
		}
	}
}
