package czyUmieszPotegowac;

import java.util.Scanner;

class CzyUmieszPotegowac {

	public static void main(String[] args) {
		potegi();
	}
	
	static void potegi() {
		Scanner scan = new Scanner(System.in);
		int n, a, b;
		
		//number of tests
		n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			//base
			a = scan.nextInt();
			//index
			b = scan.nextInt();
			
			System.out.println(Math.pow(a, b));
			int result = (int) Math.pow(a, b);
			Integer NumberOfResult = new Integer(result);
			int lengthOfResult = NumberOfResult.toString().length();
			
			System.out.println(NumberOfResult);
			System.out.println(NumberOfResult.toString().charAt(lengthOfResult-1));
			
			
			Integer NumberOfA = new Integer(a);
			int lengthOfA = NumberOfA.toString().length();
			int aa = NumberOfA.toString().charAt(lengthOfA-1);
			
			Integer NumberOfB = new Integer(b);
			int lengthOfB = NumberOfB.toString().length();
			int bb = NumberOfB.toString().charAt(lengthOfB-1);
			
			System.out.println("aa: " + aa);
			System.out.println("bb: " + bb);
			
			
					
			
			
		}
		scan.close();
	}
}
