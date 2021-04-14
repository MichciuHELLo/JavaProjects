//import java.util.Scanner;

public class PalindromMain {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
		
		
//		//insert of checking word
//		System.out.print("Podaj słowo: ");
//		String palindrom = scan.nextLine();
//		
//		System.out.println("Czy " + palindrom + " to palindrom?");
//		System.out.println("Sprawdzam...");	
		
				
		//calling a classes
//		System.out.println(Sposob1("gowm"));
//		System.out.println(Sposob2("anna"));
//		System.out.println(Sposob3("tomas"));
		
	}
	
	public static boolean Sposob1(String palindrom){
		//	PIERWSZY SPOSÓB
		
		//changing checking word to lower case
		palindrom = palindrom.toLowerCase();
		
		int spr = 0;
		for(int i=0; i<palindrom.length()/2; i++) {
			if(palindrom.charAt(i) != palindrom.charAt(palindrom.length()-i-1)) {
				spr++;
				break;
			}
		}
		
		if(spr==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean Sposob2(String palindrom){
		//	DRUGI SPOSÓB
		
			//changing checking word to lower case
			palindrom = palindrom.toLowerCase();
			
			String test = "";
			
			//adding letters to "test" from "palindrom" back words
			for(int i=palindrom.length()-1; i>=0; i--) {
				test += palindrom.charAt(i);
			}	
			
			if(test.equals(palindrom)) {
				return true;
			}
			else {
				return false;
			}
	}
	
	public static boolean Sposob3(String palindrom) {
		//	TRZECI SPOSÓB
		
		StringBuilder text = new StringBuilder();
		text.append(palindrom.toLowerCase());
		
		if(text.reverse().toString().equals(palindrom.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}	
}
