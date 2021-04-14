import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;





public class ReadAllPalindromes {

	public ReadAllPalindromes(String outputFileName) throws ClassNotFoundException, IOException {
		HashSet<Object> set = new HashSet<>();	
		
		//FileInputStream fis = new FileInputStream(outputFileName);
		boolean flag = true;
		while (flag) {
			try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(outputFileName))) {
			    Object obj = input.readObject();
			    if (obj != null) {
			    	System.out.println(obj);
			    	set.add(obj);
			    } 
			    else {
			    	flag = false;
			    }
			    input.close();
			} 
			catch (Exception e) {
				flag = false;
				e.printStackTrace();
			}
		}
		System.out.println(set.size());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new ReadAllPalindromes("setPalindrome.ser");
	}
}
