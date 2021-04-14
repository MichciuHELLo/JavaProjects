
public class FibonacciMain {

	public static void main(String[] args) {
		Fibonacci(19, 10);
		
		System.out.println("\n");
		
		for(int i=0; i<10; i++) {
			System.out.print(FibRec(i) + " ");
		}
		
		System.out.println("\n");
		
		for(int i=0; i<10; i++) {
			System.out.print(potega(2, i) + " ");
		}
		
	}
		
	
	// Fibonaci tablice
	public static void Fibonacci(int n, int lb) {
		int tab[] = new int[n+2];
		
		tab[0] = 0;
		tab[1] = 1;
		
		for(int i=2; i<n; i++) {
			tab[i] = tab[i-1] + tab[i-2];
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(tab[i] + " ");
		}
		
		System.out.print("\n" + tab[lb]);
	}
		
	
	
	// Fibonaci rekurencja
	public static int FibRec(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		else {
			return FibRec(n-1)+FibRec(n-2);
		}
	}
	
	
	// Potegi rekurencja
	public static int potega(int x, int n) {
		if(n==0) {
			return 1;
		}
		else {
			return x*potega(x, n-1);
		}
	}
	
	
	
	
	
	
	/*
	// Fibonaci bufor
	public static void Fib(int liczba) {
		int bufor = 0;
		int wynik = 1;
		int buforWyniku;
		
		System.out.println("0. " + bufor);
		System.out.println("1. " + wynik);
		
		for(int i=0; i<liczba; i++) {
			buforWyniku = wynik;
			wynik = bufor + wynik;
			bufor = buforWyniku;
			System.out.println(i+2 + ". " + wynik);
		}
	}
	*/
}
