package cards;

import java.util.Scanner;

public class GuessingNumberGame {
	public static void main(String[] args){
		CardDeck deck = new CardDeck();
		Scanner input = new Scanner(System.in);
		deck.shuffle();
		boolean running = true;
		PlayingCard current =  deck.drawCard();
		System.out.println(current);
		while(running){
			
			System.out.println("Higher(1) or Lower(0)");
			int choice = -1;
			do{
				if(input.hasNextInt()){
					choice = input.nextInt();
				}
			}while(!(choice == 0 || choice == 1));
			int prev = current.getValue();
			current = deck.drawCard();
			System.out.println(current);
			if(!((choice == 1 && prev < current.getValue()) || (choice == 0 && prev > current.getValue()))){
				System.out.println("Game Over");
				running = false;
			}
		}
	}
}
