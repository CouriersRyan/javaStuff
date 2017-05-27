package cards;

public class PlayingCard implements Comparable<PlayingCard> {
	private int value;
	private int suit;
	public static final int SPADES = 0;
	public static final int HEARTS = 1;
	public static final int CLUBS = 2;
	public static final int DIAMONDS = 3;
	
	public PlayingCard( int value, int suit){
		setValue(value);
		setSuit(suit);
	}
	
	public void setValue(int value){
		if(value <= 13 && value >= 1){
			this.value = value;
		}else{
			System.out.println("Invalid number, this value will be set to one.");
			this.value = 1;
		}
	}
	
	public void setSuit(int suit){
		if(suit <= 3 && suit >= 0){
			this.suit = suit;
		}
	}
	
	public String toString(){
		String tempValue = value + "";		
		switch(value){
		case 1:
			tempValue = "Ace";
			break;
		case 11:
			tempValue = "Jack";
			break;
		case 12:
			tempValue = "Queen";
			break;
		case 13:
			tempValue = "King";
			break;
		}
		
		return tempValue + " of " + getSuit();
	}
	
	public boolean equals(Object o){
		if(o instanceof PlayingCard){
			return ((PlayingCard) o).value == this.value && ((PlayingCard) o).suit == this.suit;
		}else{
			return false;
		}
	}
	
	public int getValue(){
		return value;
	}
	public String getSuit(){
		String temp = "";
		switch(suit){
		case SPADES:
			temp = "Spades";
			break;
		case HEARTS:
			temp = "Hearts";
			break;
		case CLUBS:
			temp = "Clubs";
			break;
		case DIAMONDS:
			temp = "Diamonds";
			break;
		default:
			return "Error";
		}
		
		return temp;
	}
	public boolean isFace(){
		return !(value <= 10 && value >= 2);
	}
	
	public int getSuitInt(){ 
		return suit;
	}
	
	@Override
	public int compareTo(PlayingCard p){
		if(suit != p.suit){
			return -(Integer.compare(suit, p.suit));
		}else{
			return Integer.compare(value, p.value);
		}
	}
}
