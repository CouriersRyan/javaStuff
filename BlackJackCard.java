package cards;

public class BlackJackCard extends PlayingCard {
	public BlackJackCard(int value, int suit){
		super(value, suit);
	}
	
	@Override 
	public int getValue(){
		if(isFace() && super.getValue() != 1){
			return 10;
		}else{return super.getValue();}
	}
}