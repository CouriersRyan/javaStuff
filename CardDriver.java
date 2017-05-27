package cards;

import java.util.Scanner;

public class CardDriver {
	public static void main(String[] args){
		/*PlayingCard test = new PlayingCard(1, PlayingCard.CLUBS);
		System.out.println(test);
		System.out.println(test.isFace());
		CardDeck deck = new CardDeck();
		System.out.println(deck.getCard(11, "spades"));
		System.out.println(deck.getCard(test));
		System.out.println("=============");
		deck.shuffle();
		System.out.println(deck);
		System.out.println("=============");
		for(int i = 0; i < 52; i++){
			System.out.println(deck.drawCard());
		}*/
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number:");
		String word = input.nextLine();
		/*int n = 0;
		if(input.hasNextInt()){
			n = input.nextInt();
		}
		System.out.println(n);*/
		System.out.println(word);
		String s = input.nextLine();
		System.out.println(s);
		double n1 = 5.2;
		System.out.println((int)n1);
	}
}