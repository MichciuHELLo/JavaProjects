import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadPalindrome {

	public ReadPalindrome(String fileName) throws ClassNotFoundException {
		Palindrome pal = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			pal = (Palindrome) ois.readObject();
			ois.close();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println(pal.toString());
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		new ReadPalindrome("palindrome.ser");
	}

}
