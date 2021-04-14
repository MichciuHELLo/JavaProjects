/*
 * 														BLACK JACK GAME
 * 
 * 											Console version of Black Jack deck game.
 * 			This program includes Menu and also saves amount of your money with which you will continue in the next game.
 * 			If you will lose everything you will get a loan which will be also saved.
 * 			Of course you can pay off your loan.
 * 
 * 			While game you will get randomized cards from 52 cards deck.
 * 			You can HIT to get another card or STAND to stay with your hand.
 * 			Your goal is to get higher sum of your cards then diler's hand but not higher then 21!
 * 
 * 			Points: 
 *  			ASE: 1 or 10
 *  			2: 2
 *   			3: 3
 *     			4: 4
 *    			5: 5
 *   			6: 6
 *     			7: 7
 *     			8: 2
 *   			9: 3
 *     			10, Jack, Queen, King: 10
 *     
 *     		Rules: https://en.wikipedia.org/wiki/Blackjack
 *     
 *     @Author: Michał_Grzelak
 */



package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


class Money{
	private static int money;

	public static int getMoney(File fileMoney) throws FileNotFoundException {
		// getting a amount of money that Player has
		
		Scanner readMoney = new Scanner(fileMoney);
		money = readMoney.nextInt();
		readMoney.close();
		
		return money;
	}

	public static void setMoney(int money, File fileMoney) throws FileNotFoundException {
		// saving a amount of money that Player won/lost
		
		PrintWriter writerMoney = new PrintWriter(fileMoney);
		writerMoney.print(money);
		writerMoney.close();
	}
}

class Loan{
	private static int loan;

	public static int getLoan(File fileLoan) throws FileNotFoundException {
		// getting a amount of loan that Player has
		
		Scanner readLoan = new Scanner(fileLoan);
		loan = readLoan.nextInt();
		readLoan.close();
		
		return loan;
	}

	public static void setLoan(int loan, File fileLoan) throws FileNotFoundException {
		// saving a amount of loan that Player has
		
		PrintWriter writerLoan = new PrintWriter(fileLoan);
		writerLoan.print(loan);
		writerLoan.close();
	}
}


public class BlackJack {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {		
		
		ArrayList<String> cards = new ArrayList<>();
		ArrayList<String> colors = new ArrayList<>();
		ArrayList<String> allCards = new ArrayList<>();
		
		ArrayList<String> playersHand = new ArrayList<>();
		ArrayList<String> dilersHand = new ArrayList<>();		
		
		File fileMoney = new File("money.txt");
		File fileLoan = new File("loan.txt");
		
		int money = Money.getMoney(fileMoney);
		int startingMoney = money;
		
		if(Money.getMoney(fileMoney) == 0) {
			
			int loan = Loan.getLoan(fileLoan);
			loan += 1000;
			
			Loan.setLoan(loan, fileLoan);
			
			money = 1000;
			
			Money.setMoney(money, fileMoney);
			
			System.out.println("You just got a 1000$ loan because you had nothing on your account!");
			System.out.println("I hope you will pay it back...\n\n");
		}
		
		Scanner scan = new Scanner(System.in);
		
		int playersHandSum = 0;
		int dilersHandSum = 0;
		String choice;
		String action;
		String strBet = "1000000";
		Integer intBet = 1000000;
		String strAmount = "1000000";
		Integer intAmount = 1000000;
		
		fillCards(cards);
		fillColors(colors);
		
		do {
			System.out.println("\n\n\nYou have " + Money.getMoney(fileMoney) + "$ in your pocket. And " + Loan.getLoan(fileLoan) + "$ loan");
			System.out.println("\n\nDO YOU WANT TO PLAY? ");
			System.out.println("- Insert 1 or 'yes' to play.");
			System.out.println("- Insert 2 to pay back your loan.");
			System.out.println("- Insert anything to run away with " + money + "$");
			System.out.print("Your choice: ");
			choice = scan.next();
			choice.toLowerCase();
			
			if(choice.equals("1") || choice.equals("yes")) {
				
				System.out.println("\nGood choice!");
				System.out.println("How high will be your bet?");
				do {
					System.out.println("Your money: " + money + "$");	
					boolean ifGoodBet = false;
					while(ifGoodBet == false) {
					System.out.print("Your bet: ");
						
						ifGoodBet = false;
						int ifGoodBetInt = 0;
						
						strBet = scan.next();
						
						for(int i=0; i<strBet.length(); i++) {
							if((int) strBet.charAt(i) < 48 || (int) strBet.charAt(i) > 57) {
								System.out.println("\n\n!!! WRONG INSERT !!! - You can insert only a positive number !\n");
								i = strBet.length()-1;
								ifGoodBetInt++;
							}
						}
						if(ifGoodBetInt == 0) {
							ifGoodBet = true;
						}
					}
					
					intBet = Integer.valueOf(strBet);				
				
					if(intBet > money) {
						System.err.println("\nYou can't bet more money then you have!");
					}
				}while(intBet > money);
				
				allCards.clear();
				playersHand.clear();
				dilersHand.clear();
				
				fillAllCards(cards, colors, allCards);	
								
				randPlayersHand(allCards, playersHand);
				randPlayersHand(allCards, playersHand);
				randDilersHand(allCards, dilersHand);
				
				displayPlayersHand(playersHand);
				playersHandSum = playerSum(playersHand);
				System.out.println("SUM: " + playersHandSum);
				
				displayDilersHand(dilersHand);
				dilersHandSum = playerSum(dilersHand);
				System.out.println("SUM: " + dilersHandSum);
				
				if(playersHandSum==21) {
					System.err.println("\n\nYou win! - !!! BLACK JACK !!!");
					money += (int) (intBet*1.5+intBet);
					Money.setMoney(money, fileMoney);
				}
				else {
					do {
						do {
							System.out.println("\n1 - Hit");
							System.out.println("2 - Stand");
							System.out.print("What do you want to do: ");
							action = scan.next();
							if(!action.equals("1") && !action.equals("2")) {
								System.out.println("\n!!! WRONG INSERT !!! - Try again !");
							}
						}while(!action.equals("1") && !action.equals("2"));
						if(action.equals("1")) {
							randPlayersHand(allCards, playersHand);
							
							displayPlayersHand(playersHand);
							playersHandSum = playerSum(playersHand);
							System.out.println("SUM: " + playersHandSum);
							
							displayDilersHand(dilersHand);
							dilersHandSum = playerSum(dilersHand);
							System.out.println("SUM: " + dilersHandSum);
						}
					}while(action.equals("1") && playersHandSum < 21);
					
					if(playersHandSum>21) {
						System.out.println("\n\nYOU LOST! - DILER WINS!");
						money -= intBet;
						Money.setMoney(money, fileMoney);
					}
					else if(playersHandSum==21) {
						System.out.println("\n\nYOU WIN!");
						money += intBet;
						Money.setMoney(money, fileMoney);
					}
					else {
						while(dilersHandSum <= playersHandSum && dilersHandSum < 21) {
							displayPlayersHand(playersHand);
							playersHandSum = playerSum(playersHand);
							System.out.println("SUM: " + playersHandSum);
							
							randDilersHand(allCards, dilersHand);
							displayDilersHand(dilersHand);
							dilersHandSum = playerSum(dilersHand);
							System.out.println("SUM: " + dilersHandSum);
						}
						if(dilersHandSum>21) {
							System.out.println("\n\nYOU WIN!");
							money += intBet;
							Money.setMoney(money, fileMoney);
						}
						else if(dilersHandSum>playersHandSum || dilersHandSum==21) {
							System.out.println("\n\nYOU LOST! - DILER WINS!");
							money -= intBet;
							Money.setMoney(money, fileMoney);
						}
					}
				}
			}
			else if(choice.equals("2")) {
				if(Loan.getLoan(fileLoan) > 0) {
					System.out.println("\n\nYou are here because you wanned to pay back your loan..");
					System.out.println("\nYou have " + Money.getMoney(fileMoney) + "$ in your pocket. And " + Loan.getLoan(fileLoan) + "$ loan");
					
					do {
						boolean ifGoodAmount = false;
						while(ifGoodAmount == false) {
							System.out.print("Amount of money you want to pay off: ");
								
							ifGoodAmount = false;
							int ifGoodAmountInt = 0;
								
							strAmount = scan.next();
							
							for(int i=0; i<strAmount.length(); i++) {
								if((int) strAmount.charAt(i) < 48 || (int) strAmount.charAt(i) > 57) {
									System.out.println("\n\n!!! WRONG INSERT !!! - You can insert only a positive number !\n");
									i = strAmount.length()-1;
									ifGoodAmountInt++;
								}
							}
							if(ifGoodAmountInt == 0) {
								ifGoodAmount = true;
							}
						}
						
						intAmount = Integer.valueOf(strAmount);				
					
						if(intAmount > money) {
							System.out.println("\nYou insered more money then you have!");
						}
						else if(intAmount > Loan.getLoan(fileLoan)) {
							System.out.println("\nYou are trying to pay off more then you have to!");
						}
					}while(intAmount > money || intAmount > Loan.getLoan(fileLoan));
					money -= intAmount;
					int loan = Loan.getLoan(fileLoan);
					loan -= intAmount;
					Money.setMoney(money, fileMoney);
					Loan.setLoan(loan, fileLoan);
				}
				else {
					System.out.println("\n\nYou have nothing to pay off! :)");
				}
			}
		}while(choice.equals("1") && money > 0 || choice.equals("yes") && money > 0);
		
		if(money <= 0) {
			System.out.println("\n\nYou are out! You have no more money!");
		}
		
		System.out.println("---------------------------------------");
		System.out.println("\nThank you for playing");
		int balance = money - startingMoney;
		System.out.print("YOUR BALANCE IS EQUAL: ");
		if(balance>0) System.out.print("+");
		System.out.println(balance + "$!");
		System.out.println("See you next time ;)");
		scan.close();
		
		Money.setMoney(money, fileMoney);
	}
	
	public static void fillCards(ArrayList<String> cards) {
		// adding all figures to an Array
		
		cards.add("TWO");
		cards.add("THREE");
		cards.add("FOUR");
		cards.add("FIVE");
		cards.add("SIX");
		cards.add("SEVEN");
		cards.add("EIGHT");
		cards.add("NINE");
		cards.add("TEN");
		cards.add("JACK");
		cards.add("QUEEN");
		cards.add("KING");
		cards.add("ASE");
	}
	
	public static void fillColors(ArrayList<String> colors) {
		// adding all colors to an Array
		
		colors.add("Spades");
		colors.add("Hearts");
		colors.add("Clubs");
		colors.add("Diamonds");
	}
	
	public static void fillAllCards(ArrayList<String> cards, ArrayList<String> colors, ArrayList<String> allCards) {
		// adding all cards to an Array
		
		for(int i=0; i<cards.size(); i++) {
			for(int j=0; j<colors.size(); j++) {
				allCards.add(cards.get(i));
				allCards.add(colors.get(j));
			}
		}
	}
	
	public static void randPlayersHand(ArrayList<String> allCards, ArrayList<String> playersHand) {
		// randomizing player's Hand
		// Player can't get two times the same card
		
		boolean condition = false;
		int rand;
		do {
			rand = (int) (Math.random()*allCards.size());
			if(rand%2==0) {
				condition = true;
			}
		}while(!condition);
		playersHand.add(allCards.get(rand));
		playersHand.add(allCards.get(rand+1));
		allCards.remove(rand+1);
		allCards.remove(rand);
	}

	public static void randDilersHand(ArrayList<String> allCards, ArrayList<String> dilersHand) {
		// randomizing diller's Hand
		// Diller can't get two times the same card
		
		boolean condition = false;
		int rand;
		do {
			rand = (int) (Math.random()*allCards.size());
			if(rand%2==0) {
				condition = true;
			}
		}while(!condition);
		dilersHand.add(allCards.get(rand));
		dilersHand.add(allCards.get(rand+1));
		allCards.remove(rand+1);
		allCards.remove(rand);
	}
	
	public static void displayPlayersHand(ArrayList<String> playersHand) throws InterruptedException {
		// show Player's hand
		
		System.out.print("\n\n\n --Your hand-- ");
		for(int i=0; i<playersHand.size(); i++) {
			if(i%2==0) {
				System.out.println();
				TimeUnit.SECONDS.sleep(1);
			}			
			System.out.print(playersHand.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void displayDilersHand(ArrayList<String> dilersHand) throws InterruptedException {
		// show Diller's hand
		
		System.out.print("\n --Diler's hand-- ");
		for(int i=0; i<dilersHand.size(); i++) {
			if(i%2==0) {
				System.out.println();
				TimeUnit.SECONDS.sleep(1);
			}			
			System.out.print(dilersHand.get(i) + " ");
		}
		System.out.println();
	}
	
	public static int dilerSum(ArrayList<String> dilersHand) {
		// summing Diller's points
		
		int sum = 0;
		for(int index=0; index<dilersHand.size(); index++) {
			if(dilersHand.get(index) == "TWO") {
				//2
				sum+=2;
			}
			else if(dilersHand.get(index) == "THREE") {
				//3
				sum+=3;
			}
			else if(dilersHand.get(index) == "FOUR") {
				//4
				sum+=4;
			}
			else if(dilersHand.get(index) == "FIVE") {
				//5
				sum+=5;
			}
			else if(dilersHand.get(index) == "SIX") {
				//6
				sum+=6;
			}
			else if(dilersHand.get(index) == "SEVEN") {
				//7
				sum+=7;
			}
			else if(dilersHand.get(index) == "EIGHT") {
				//8
				sum+=8;
			}
			else if(dilersHand.get(index) == "NINE") {
				//9
				sum+=9;
			}
			else if(dilersHand.get(index) == "TEN" || dilersHand.get(index) == "JACK" || dilersHand.get(index) == "QUEEN" || dilersHand.get(index) == "KING") {
				//10 J Q K
				sum+=10;
			}
			else if(dilersHand.get(index) == "ASE") {
				//ASE
				if(sum+11>21) {
					sum+=1;
				}
				else {
					sum+=11;
				}
			}
		}
		
		return sum;
	}
	
	public static int playerSum(ArrayList<String> playersHand) {
		// summing Player's points
		
		int sum = 0;
		
		for(int index=0; index<playersHand.size(); index++) {
			if(playersHand.get(index) == "TWO") {
				//2
				sum+=2;
			}
			else if(playersHand.get(index) == "THREE") {
				//3
				sum+=3;
			}
			else if(playersHand.get(index) == "FOUR") {
				//4
				sum+=4;
			}
			else if(playersHand.get(index) == "FIVE") {
				//5
				sum+=5;
			}
			else if(playersHand.get(index) == "SIX") {
				//6
				sum+=6;
			}
			else if(playersHand.get(index) == "SEVEN") {
				//7
				sum+=7;
			}
			else if(playersHand.get(index) == "EIGHT") {
				//8
				sum+=8;
			}
			else if(playersHand.get(index) == "NINE") {
				//9
				sum+=9;
			}
			else if(playersHand.get(index) == "TEN" || playersHand.get(index) == "JACK" || playersHand.get(index) == "QUEEN" || playersHand.get(index) == "KING") {
				//10 J Q K
				sum+=10;
			}
			else if(playersHand.get(index) == "ASE") {
				//ASE
				if(sum+11>21) {
					sum+=1;
				}
				else {
					sum+=11;
				}
			}
		}
		return sum;
	}

	public static void displayAllCards(ArrayList<String> allCards) {
		// test method to show all available cards 
		
		for(int i=0; i<allCards.size(); i++) {
			if(i%8==0) {
				System.out.println();
			}
			System.out.print(allCards.get(i) + " ");
		}
		System.out.println("\n------------------------" + allCards.size() + "------------------------\n");
	}
}
