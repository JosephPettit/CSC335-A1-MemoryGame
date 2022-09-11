package assignment1;

public class LogicGameOptions {
	private int players; 
	private int deck;
	private Boolean singleFlip;
	
	LogicGameOptions(int players, int deck, Boolean singleFlip) {
		this.players = players;
		this.deck = deck;
		this.singleFlip = singleFlip;
	}
		
	public void displaySelection() {
		System.out.println(players);
		System.out.println(deck);
		System.out.println(singleFlip);
	}

	public int getPlayers() {
		return players;
	}

	public int getDeck() {
		return deck;
	}

	public Boolean getSingleFlip() {
		return singleFlip;
	}
}
