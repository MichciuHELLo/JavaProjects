import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVConvert {

	static class CSV{
		
		private String inName;
		private char inSeparator;
		private String outName;
		private char outSeparator;
		
		public CSV(String inName, char inSeparator, String outName, char outSeparator) {
			this.inName = inName;
			this.inSeparator = inSeparator;
			this.outName = outName;
			this.outSeparator = outSeparator;
		}
		
		static void file1ToArray(String inName, ArrayList<String>arrayFile1) throws FileNotFoundException {
			File file1 = new File(inName);
			
			Scanner readFile = new Scanner(file1);
			while(readFile.hasNext()) {
				arrayFile1.add(readFile.nextLine());
			}
			readFile.close();
		}
		
		static void displayArray1(ArrayList<String>arrayFile1) {
			System.out.println("\n" + arrayFile1 + "\n");
		}

		static void displayFile1(String inName) throws FileNotFoundException {
			File file1 = new File(inName);
			
			System.out.println("---- FILE 1 ----");
			System.out.println("File name: " + inName + "\n");
			
			Scanner readFile = new Scanner(file1);
			while(readFile.hasNext()) {
				System.out.println(readFile.nextLine());
			}
			readFile.close();
			
			System.out.println("\n--------------------");
		}
		
		static void convertSeparators(char inSeparator, char outSeparator, ArrayList<String>arrayFile1, ArrayList<String>arrayFile2) {
			for(Object line : arrayFile1) {
				arrayFile2.add(line.toString().replace(inSeparator, outSeparator));
			}
		}
		
		static void displayArray2(ArrayList<String>arrayFile2) {
			System.out.println("\n" + arrayFile2 + "\n");
		}
		
		static void writeToFile2(ArrayList<String>arrayFile2, String outName) throws IOException {
			File file2 = new File(outName);
			file2.createNewFile();
			
			PrintWriter writer = new PrintWriter(file2);
			for(Object line : arrayFile2) {
				writer.println(line);
			}
			writer.close();
		}
		
		static void displayFile2(String outName) throws FileNotFoundException {
			File file2 = new File(outName);
			
			System.out.println("\n\n---- FILE 2 ----");
			System.out.println("File name: " + outName + "\n");
			
			Scanner readFile = new Scanner(file2);
			while(readFile.hasNext()) {
				System.out.println(readFile.nextLine());
			}
			readFile.close();
			
			System.out.println("\n--------------------");
		}
	
		static String getValue(int row, int column, ArrayList<String>arrayFile2) {
			
			System.out.println("\nChosen row: " + row);
			System.out.println("Chosen column: " + column);
			
			if(arrayFile2.toArray()[row].equals("")) {
				//System.out.println("Line number " + row + " is empty");
				String result = "Line number " + row + " is empty.";
				return result;
			}
			else {
				String word = (String) arrayFile2.toArray()[row];
				char letter = word.charAt(column);
				String result = "Letter: " + letter;
				return result;
			}
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> arrayFile1 = new ArrayList<>();
		ArrayList<String> arrayFile2 = new ArrayList<>();
		
		final String inName = "Litwo.csv";												// parameter of testing file
		final String outName = "Wynik.csv";												// parameter of saving file
		final char inSeparator = 'z';													// parameter of separator to change
		final char outSeparator = '?';													// parameter of final separator
		
		CSV csv = new CSV("cos.csv", ';', "sss", ',');
		CSV.file1ToArray(inName, arrayFile1);											// pasting file 1 to an array
		
		// CSV.displayArray1(arrayFile1);												// display array of file 1
		
		CSV.displayFile1(inName);														// display file 1
		CSV.convertSeparators(inSeparator, outSeparator ,arrayFile1, arrayFile2);		// converting separators in file 1 and pasting changes to array2
		
		// CSV.displayArray2(arrayFile2);												// display array with changed separators
		
		CSV.writeToFile2(arrayFile2, outName);											// adding whole array to file 2
		CSV.displayFile2(outName);														// display file 2
		
																					// picking one character from changed array
		int row = (int) (Math.random()*arrayFile2.size());								// choosing the element of an array
		String chosenWord =  (String) arrayFile2.toArray()[row];
		int column = (int) (Math.random()*chosenWord.length());							// choosing the character of a chosen element
		System.out.println(CSV.getValue(row,column, arrayFile2));						// display chosen character
		
	}
}
