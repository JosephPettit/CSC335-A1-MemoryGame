package assignment1;

import java.util.LinkedList;
import java.util.Queue;

public class LogicCurrentGame {

	private int players;
	private int totalScore;
	private boolean singleFlip;
	private String backOfCards;
	private String[] deckArray;
	private Queue<LogicPlayer> currentPlayers;
	private LogicPlayer activePlayer;

	LogicCurrentGame(LogicGameOptions selections) {
		CardImages images = new CardImages(selections.getDeck());
		this.players = selections.getPlayers();
		this.singleFlip = selections.getSingleFlip();
		this.backOfCards = images.getBackOfCards();
		this.deckArray = images.getImagesArray();
		this.currentPlayers = new LinkedList<LogicPlayer>();

	}

	public void addPlayer(LogicPlayer player) {

		currentPlayers.add(player);
		
		if(activePlayer == null) {
			activePlayer = currentPlayers.poll();
		}
	}

	public boolean isFirstSelected() {
		return (activePlayer.getPlayerSelection1() != -1);
	}

	public boolean isSecondSelected() {
		return (activePlayer.getPlayerSelection2() != -1);
	}

	public boolean matchLocated() {
		if (deckArray[activePlayer.getPlayerSelection1()].equals(deckArray[activePlayer.getPlayerSelection2()])) {
			activePlayer.incrementScore();
			return true;
		}
		return false;
	}

	public void endRoundWin() {
		if (singleFlip) {
			switchPlayer();
		} else {
			activePlayer.endRound();
		}
		totalScore ++;
	}

	public void endRoundLoss() {
		switchPlayer();
	}

	public int getTotalGameScore() {
		return totalScore;
	}
	
	public String getWinner() {
		String winner = activePlayer.getUserName();
		for(LogicPlayer player : currentPlayers) {
			if(player.getScore() > activePlayer.getScore()) {
				winner = player.getUserName();
			}
		}
		return winner;
	}
	
	public int getPlayers() {
		return players;
	}
	
	public int getScore() {
		return activePlayer.getScore();
	}

	public String getPlayer() {
		return activePlayer.getUserName();
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

	public void setPlayerSelection1(int selection) {
		activePlayer.setPlayerSelection1(selection);
	}

	public int getPlayerSelection1() {
		return activePlayer.getPlayerSelection1();
	}

	public void setPlayerSelection2(int selection) {
		activePlayer.setPlayerSelection2(selection);
	}

	public int getPlayerSelection2() {
		return activePlayer.getPlayerSelection2();
	}

	private void switchPlayer() {
		activePlayer.endRound();
		currentPlayers.offer(activePlayer);
		activePlayer = currentPlayers.poll();
	}
}
