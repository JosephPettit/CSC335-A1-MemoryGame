package assignment1;

import org.eclipse.swt.SWT;

public class GameController {
	

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUICardGame window = new GUICardGame();
			LogicGameOptions gameOptions = new GUIGameOptions(window.shell, SWT.None).open();
			LogicCurrentGame currentGame = new LogicCurrentGame(gameOptions);
			GUIPlayerName player;
			
			for(int i = 1; i < currentGame.getPlayers(); i++) {
				player = new GUIPlayerName(window.shell, SWT.None);
				currentGame.addPlayer(player.open());
			}
			window.open(currentGame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
