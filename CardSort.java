package cards;

public class CardSort {
	public static void main(String agrs[]){
		CardDeck test = new CardDeck();
		test.shuffle();
		System.out.println(test);
		System.out.println("----------------------");
		test.sortCards();
		System.out.println(test);
		
	}
}
