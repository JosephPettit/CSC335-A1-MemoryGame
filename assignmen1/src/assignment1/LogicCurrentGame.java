package assignment1;

import java.util.LinkedList;

public class LogicCurrentGame {
	
	private int players; 
	private boolean singleFlip;
	private String backOfCards;
	private String[] deckArray;
	private LinkedList<String> currentPlayers;
	
	LogicCurrentGame(LogicGameOptions selections) {
		CardImages images = new CardImages(selections.getDeck());
		this.players = selections.getPlayers();
		this.singleFlip = selections.getSingleFlip();
		this.backOfCards = images.getBackOfCards();
		this.deckArray = images.getImagesArray();
		
	}

	public int getPlayers() {
		return players;
	}

	public boolean isSingleFlip() {
		return singleFlip;
	}

	public String getBackOfCards() {
		return backOfCards;
	}

	public String[] getDeckArray() {
		return deckArray;
	}

	public LinkedList<String> getCurrentPlayers() {
		return currentPlayers;
	}
	
	
	

}
