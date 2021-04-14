import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Simple class to write a palindrome into the file. 
 */
public class WritePalindrome {
	/**
	 * Writes the given palindrome into the given file.
	 */
	public WritePalindrome(Palindrome p, String fileName) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
			oos.writeObject(p);
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Tests the class.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		new WritePalindrome(new Palindrome("Kobyła ma mały bok."), "palindrome.ser");
	}
}
