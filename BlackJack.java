package cards;

import java.util.Scanner;

public class BlackJack {
	static final int MAX_HAND = 11;
	public static void main(String[] args){
		CardDeck deck = new CardDeck();
		Scanner input = new Scanner(System.in);
		deck.shuffle();
		boolean running = true;
		PlayingCard[] player = new BlackJackCard[MAX_HAND];
		PlayingCard[] com = new BlackJackCard[MAX_HAND];
		boolean playing = true;
		double money = 200;
		double bet;
		int playerSize = 0;
		int comSize = 0;
		int playerTotal = 0;
		int comTotal = 0;
		System.out.printf("Money: $%.2f \n", money);
		while(running && !deck.isEmpty() && money > 0 && playing){
			System.out.println("--------New Round--------");
			playerSize = 0;
			playerTotal = 0;
			//Start of Player's Turn
			System.out.println("---Player's Turn---");
			System.out.printf("Make a Bet:(Must be great than $0 and no more than $%.2f) \n", money);
			bet = Double.parseDouble(input.nextLine());
			if(bet > money){
				bet = money;
				System.out.println("You bet more than you have, so now you bet everything.");
			}
			if(bet <= 0){
				bet = money;
				System.out.println("You bet less than allowed, so now you bet everything.");
			}
			PlayingCard drawnCard = deck.drawCard();
			player[playerSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
			playerTotal += player[playerSize - 1].getValue();
			drawnCard = deck.drawCard();
			player[playerSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
			playerTotal += player[playerSize - 1].getValue();
			printCards(player, playerSize);
			System.out.println("Total: " + playerTotal);
			System.out.println("Draw(1) or Stay(0)");
			int choice = 0;
			choice = Integer.parseInt(input.nextLine());
			while(choice == 1){
				drawnCard = deck.drawCard();
				player[playerSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
				printCards(player, playerSize);
				playerTotal += player[playerSize - 1].getValue();
				System.out.println("Total: " + playerTotal);
				if(playerTotal >= 21){
					break;
					//end of player's turn, computer plays.
				}
				System.out.println("Draw(1) or Stay(0)");
				choice = 0;
				choice = Integer.parseInt(input.nextLine());
			}
			//Start of Computer's Turn
			comSize = 0;
			comTotal = 0;
			System.out.println("---Computer's Turn---");
			drawnCard = deck.drawCard();
			com[comSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
			comTotal += com[comSize - 1].getValue();
			drawnCard = deck.drawCard();
			com[comSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
			comTotal += com[comSize - 1].getValue();
			while(comTotal < 17){
				drawnCard = deck.drawCard();
				com[comSize++] = new BlackJackCard(drawnCard.getValue(), drawnCard.getSuitInt());
				comTotal += com[comSize - 1].getValue();
			}
			printCards(com, comSize);
			System.out.println("Computer Total: " + comTotal);
			if(comTotal <= 21 && playerTotal <= 21){
				if(comTotal == playerTotal){
					System.out.println("---Tie---");
				}
				if(comTotal > playerTotal){
					System.out.println("---Computer Wins---");
					money -= bet;
				}
				if(playerTotal > comTotal){
					System.out.println("---Player Wins---");
					money += bet;
				}
			}else if(playerTotal <= 21){
				System.out.println("---Player Wins---");
				money += bet;
			}else if(comTotal <= 21){
				System.out.println("---Computer Wins---");
				money -= bet;
			}else{
				System.out.println("---Tie---");
			}
			System.out.printf("Money: $%.2f \n", money);
			deck.shuffle();
			deck.resetSize();
			if(money < 0.01){
				System.out.println("You are broke, don't gamble.");
			}
			System.out.println("Do you want to quit? (True or False)");
			playing = !(Boolean.parseBoolean(input.nextLine()));
		}
	}
	
	public static void printCards(PlayingCard[] a, int size){
		for(int i = 0; i < size; i++){
			System.out.println(a[i]);
		}
	}
}
