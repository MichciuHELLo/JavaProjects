
public class PalindromCreat {

	public static void main(String[] args) {
		
		
		try {
			StringBuilder str = new StringBuilder("kahgdbkankajak");
				StringChallenge(str);
		}
		catch(Throwable e) { }
	}
	
	public static void StringChallenge(StringBuilder str){
		str.toString().toLowerCase();
		int j = str.length()-1;
		String deleted = "";
		
		for(int i=0; i<str.length()/2; i++){
			if(str.length()<3) {
				System.out.print(tooSmall());
				break;
			}
			if(str.charAt(i) != str.charAt(j)) {
				deleted += str.charAt(i);
				str.deleteCharAt(i);
				i--;
			}
			j--;
		}
		if(str.length()>=3) {
			System.out.print(deletedChars(deleted));
		}
	}
	
	public static String tooSmall() {
		return "not posible";
	}
	
	public static String deletedChars(String deleted) {
		return deleted;
	}
}
