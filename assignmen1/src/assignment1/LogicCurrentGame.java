package assignment1;

import java.util.LinkedList;

public class LogicCurrentGame {
	
	private int players;
	private int playerSelection1 = -1;
	private int playerSelection2 = -1;
	private boolean singleFlip;
	private String backOfCards;
	private String[] deckArray;
	private LinkedList<LogicPlayer> currentPlayers;
	
	LogicCurrentGame(LogicGameOptions selections) {
		CardImages images = new CardImages(selections.getDeck());
		this.players = selections.getPlayers();
		this.singleFlip = selections.getSingleFlip();
		this.backOfCards = images.getBackOfCards();
		this.deckArray = images.getImagesArray();
		currentPlayers = new LinkedList<LogicPlayer>();

	}
	
	public boolean isFirstSelected() {
		return (playerSelection1 != -1);
	}
	
	public boolean isSecondSelected() {
		return (playerSelection2 != -1);
	}
	
	public int matchLocated(int playerSelection2) {
		if(deckArray[playerSelection1].equals(deckArray[playerSelection2])) {
			return playerSelection1;
		}
		return -1;
	}
	
	public void addPlayer(LogicPlayer player) {
		currentPlayers.add(player);
	}
	
	public void endRound() {
		playerSelection1 = -1;
		playerSelection2 = -1;
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

	public LinkedList<LogicPlayer> getCurrentPlayers() {
		return currentPlayers;
	}
	
	public void setPlayerSelection1(int selection) {
		this.playerSelection1 = selection;
	}

	public int getPlayerSelection1() {
		return playerSelection1;
	}

	public void setPlayerSelection2(int selection) {
		this.playerSelection2 = selection;
	}

	public int getPlayerSelection2() {
		return playerSelection2;
	}
}
