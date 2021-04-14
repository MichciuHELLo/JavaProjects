package dwieCyfrySilni;

import java.util.Scanner;

class DwieCyfrySilni {

	public static void main(String[] args) {
		silnia();
	}

	static void silnia(){
		Scanner scan = new Scanner(System.in);
		
		//number of tests
		int D = scan.nextInt();
		for(int i=0; i<D; i++) {
			//Factorial number
			int n = scan.nextInt();
			if(n>=0 && n<4) {
				long lb = 1;
				for(int j=1; j<=n; j++) {
					lb *= j;
				}
				System.out.println("0 " + lb);
			}
			else if(n>=4 && n<10) {
				int lb = 1;
				for(int j=1; j<=n; j++) {
					lb *= j;
				}
				
				//change integer to string
				Integer y = new Integer(lb);
				int x = y.toString().length();
				System.out.println(y.toString().charAt(x-2) + " " + y.toString().charAt(x-1));
			}
			else{
				System.out.println("0 0");
			}
		}
		scan.close();
	}
}
