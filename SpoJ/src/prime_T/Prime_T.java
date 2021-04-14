package prime_T;

import java.util.Scanner;

class Prime_T {
	public static void main(String[] args) {
		prime();
	}
	
	public static void prime() {
		Scanner scan = new Scanner(System.in);
		
		//give me number of tests
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			//give me a number to check if it's prime number
			int number = scan.nextInt();
			int how_much = 0;
			boolean flag = true;
			if(number==1) {
				System.out.println("NIE");
			}
			else {
				for(int j=1; j<=number/2; j++) {
					if(number%j==0) {
						how_much++;
						if(how_much>1) {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					System.out.println("TAK");
				}
				else {
					System.out.println("NIE");
				}
			}
		}
		scan.close();
	}
}
