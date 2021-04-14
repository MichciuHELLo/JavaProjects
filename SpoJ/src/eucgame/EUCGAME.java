/*										TASK
 * 									Euklide's game
 *
 * 	There are two players (A and B) in the game. 
 * 	Initially, each of them has a certain non-zero number of identical tokens.
 *	If one player has fewer tokens than the other, he may make a move. 
 *	When making a move, the player takes as many tokens from his partner as he has. 
 *	These tokens are excluded from the rest of the game (the player making the move does not take them).
 *	The game ends when neither player can make a move 
 *	(in particular, the game may end immediately after the "deal" of tokens, without making any moves). 
 *	Result: The total number of tokens for both players after the game is over.
 * 
 * 		Examples: 
 * 					1 1		=	2
 *					2 4		=	4
 *					9 6		=	6
 * 
 * 		
 * 		Author: @Michał_Grzelak
 */

package eucgame;

import java.util.Scanner;

public class EUCGAME {

	public static void main(String[] args) {
		game();
	}

	public static void game() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Gimme quantity of games: "); int games = scan.nextInt();				// insert quantity of games
		for(int i=1; i<=games; i++) {
			System.out.println("\nGame number " + i + ".");
			System.out.print("How many coins has gamerA: "); int gamerA = scan.nextInt();		// how many tokens has player A
			System.out.print("How many coins has gamerB: "); int gamerB = scan.nextInt();		// how many tokens has player B
			
			int sum = gamerA + gamerB;															// sum of tokens of both players
			
			while(gamerA != gamerB) {															// looking for a answer until tokens of player A aren't equal to tokens of player B
				if(gamerA < gamerB) {															// if player A has fewer tokens then player B -
					sum -= gamerA;																// - we are excluding tokens equal tokens of player A from sum of tokens of both players -
					gamerB -= gamerA;															// - and from player B
				}
				else if(gamerA > gamerB) {														// same as player A but as player B
					sum -= gamerB;
					gamerA -= gamerB;
				}
			}
			System.out.println("GAME OVER! " + sum + " coins left.");
		}
		scan.close();
	}
	
}
