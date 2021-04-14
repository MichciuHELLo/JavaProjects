package hackerRank;

import java.util.*;

public class BittSet {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		BitSet B1 = new BitSet(N);
		BitSet B2 = new BitSet(N);
				
		for(int i=0; i<M; i++) {
			String ans = scan.next();
			int set = scan.nextInt();
			int index = scan.nextInt();
			
			switch(ans){
				case "AND":
					if(set==1)	B1.and(B2);
					if(set==2)	B2.and(B1);
					break;
				case "OR":
					if(set==1)	B1.or(B2);
					if(set==2)	B2.or(B1);
					break;	
				case "XOR":
					if(set==1)	B1.xor(B2);
					if(set==2)	B2.xor(B1);
					break;
				case "FLIP":
					if(set==1)	B1.flip(index);
					if(set==2)	B2.flip(index);
					break;
				case "SET":
					if(set==1)	B1.set(index);
					if(set==2)  B2.set(index);
					break;
			}
			System.out.print(B1.cardinality() + " ");
			System.out.println(B2.cardinality());
		}
		scan.close();
    }
}
