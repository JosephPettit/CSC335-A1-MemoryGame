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
			
			for(int i = 0; i < currentGame.getPlayers(); i++) {
				currentGame.addPlayer(new LogicPlayer(new GUIPlayerName(window.shell, SWT.None).open(i+1)));
			}
			window.open(currentGame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
