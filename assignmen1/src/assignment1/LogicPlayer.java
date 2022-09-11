package assignment1;

public class LogicPlayer {
	private final String userName;
	private int score; 
	private boolean cardFlipped;
	
	
	LogicPlayer(String userName){
		this.userName = userName;
		score = 0; 
		cardFlipped = false;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public boolean isCardFlipped() {
		return cardFlipped;
	}


	public void setCardFlipped(boolean cardFlipped) {
		this.cardFlipped = cardFlipped;
	}


	public String getUserName() {
		return userName;
	}
	
	
}
