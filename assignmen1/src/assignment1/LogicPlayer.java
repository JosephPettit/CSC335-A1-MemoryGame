package assignment1;

public class LogicPlayer {
	private final String userName;
	private int score; 
	private int playerSelection1;
	private int playerSelection2;
	
	LogicPlayer(String userName) {
		this.userName = userName;
		this.score = 0;
		this.playerSelection1 = -1;
		this.playerSelection2 = -1;
	}
	
	public void endRound() {
		this.playerSelection1 = -1;
		this.playerSelection2 = -1;
	}
	
	public void incrementScore() {
		this.score ++;
	}

	public String getUserName() {
		return userName;
	}

	public int getScore() {
		return score;
	}

	public int getPlayerSelection1() {
		return playerSelection1;
	}

	public void setPlayerSelection1(int playerSelection1) {
		this.playerSelection1 = playerSelection1;
	}

	public int getPlayerSelection2() {
		return playerSelection2;
	}

	public void setPlayerSelection2(int playerSelection2) {
		this.playerSelection2 = playerSelection2;
	}


	
}
