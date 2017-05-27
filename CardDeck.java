package cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	private final int CAPACITY = 52;
	private int size;
	private PlayingCard[] cards;
	public CardDeck(){
		size = CAPACITY;
		cards = new PlayingCard[CAPACITY];
		for(int j = 0; j <= 3; j++){
			for(int i = 1; i <= 13; i++){
				cards[(j * 13) + (i - 1)] = new PlayingCard(i, j);
			}
		}
	}
	
	public PlayingCard getCard(int value, String suit){
		for(int i = 0; i < cards.length; i++){
			if(cards[i].getValue() == value && cards[i].getSuit().equalsIgnoreCase(suit)){
				return cards[i];
			}
		}
		return null;
	}
	public PlayingCard getCard(PlayingCard card){
		if(card == null){
			return null;
		}
		for(int i = 0; i < cards.length; i++){
			//System.out.print(card + " ");
			//System.out.println(cards[i]);
			/*if(cards[i].getValue() == card.getValue() && cards[i].getSuit().equals(card.getSuit())){
				return cards[i];
			}*/
			if(cards[i].equals(card)){
				return cards[i];
			}
		}
		return null;
	}
	
	public String toString(){
		String temp = "";
		for(int i = 0; i < cards.length; i++){
			temp += cards[i] + "\n";
		}
		return temp;
	}
	
	public void shuffle(){
		List<PlayingCard> temp = Arrays.asList(cards);
		Collections.shuffle(temp);
		cards = (PlayingCard[])(temp.toArray());
	}
	
	public PlayingCard drawCard(){
		if(!isEmpty()){	
			return cards[--size];
		}
		return null;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void resetSize(){
		size = CAPACITY;
	}
	
	public void sortCards(){
		Arrays.sort(cards);
	}
}