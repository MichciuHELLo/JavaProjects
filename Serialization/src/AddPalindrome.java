import java.util.Scanner;

public class AddPalindrome {

		public AddPalindrome(String outputFileName) {
			System.out.print("How many palindroms would you like to add: ");
			
			Scanner scan = new Scanner(System.in);
			int amount = scan.nextInt();
			
			for(int i=0; i<=amount; i++) {
				System.out.print("Give me a palindrome: ");
				String pali = scan.nextLine();
				if(Palindrome.isPalindrome(pali) == true) {
					new WritePalindrome(new Palindrome(pali), outputFileName);
				}
			}
			scan.close();
		}
	
	public static void main(String[] args) {
		new AddPalindrome("setPalindrome.ser");
	}
}
