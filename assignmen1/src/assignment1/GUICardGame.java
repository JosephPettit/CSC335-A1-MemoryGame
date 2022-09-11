package assignment1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.forms.widgets.FormToolkit;

import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Menu;

public class GUICardGame {

	protected Shell shell;
	private String[] cardImageArray;
	private Button[] buttonArray;
	private LogicCurrentGame currentGame;
	private Button btnNewButton;

	GUICardGame() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Concentraion Card Game");
		shell.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	/**
	 * Open the window.
	 */
	public void open(LogicCurrentGame currentGame) {
		Display display = Display.getDefault();
		this.currentGame = currentGame;
		cardImageArray = currentGame.getDeckArray();
		buttonArray = new Button[cardImageArray.length];
		createContents(display);
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public LogicGameOptions createGameOptionsWindow(Shell shell) {
		return new GUIGameOptions(shell, SWT.NONE).open();
	}

	/**
	 * Create contents of the window.
	 */
	private void createContents(Display display) {

		// Setting up menu bar at top of screen
		Menu menuBar = new GUIMenuBar(display, shell).getMenuBar();
		shell.setMenuBar(menuBar);

		// Retrieving and setting images for cards
		cardImageArray = currentGame.getDeckArray();

		btnNewButton = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton, 0);
		buttonArray[0] = btnNewButton;

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_1, 1);
		buttonArray[1] = btnNewButton_1;

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_2, 2);
		buttonArray[2] = btnNewButton_2;

		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_3, 3);
		buttonArray[3] = btnNewButton_3;

		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_4, 4);
		buttonArray[4] = btnNewButton_4;

		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_5, 5);
		buttonArray[5] = btnNewButton_5;

		Button btnNewButton_6 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_6, 6);
		buttonArray[6] = btnNewButton_6;

		Button btnNewButton_7 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_7, 7);
		buttonArray[7] = btnNewButton_7;

		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_8, 8);
		buttonArray[8] = btnNewButton_8;

		Button btnNewButton_9 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_9, 9);
		buttonArray[9] = btnNewButton_9;

	}

	private void createButton(Display display, Button button, int cardNumber) {
		Image backOfCard = new Image(display, currentGame.getBackOfCards());
		resetCard(button, backOfCard);

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				button.setImage(new Image(display, cardImageArray[cardNumber]));

				if (!currentGame.isFirstSelected() && cardNumber != currentGame.getPlayerSelection1()) {
					currentGame.setPlayerSelection1(cardNumber);
				}
				else if(!currentGame.isSecondSelected() && cardNumber != currentGame.getPlayerSelection2()) {
					currentGame.setPlayerSelection2(cardNumber);
				}
				
				
				if(currentGame.isFirstSelected() && currentGame.isSecondSelected()) {
					int matchedCard = currentGame.matchLocated(cardNumber);
					
					if(matchedCard == -1) {
						resetCard(buttonArray[currentGame.getPlayerSelection1()], backOfCard);
						resetCard(buttonArray[currentGame.getPlayerSelection2()], backOfCard);
					}
					else {
						
						removeCard(buttonArray[currentGame.getPlayerSelection1()]);
						removeCard(buttonArray[currentGame.getPlayerSelection2()]);
						
						if(currentGame.isSingleFlip()){
							currentGame.endRound();
						}
					}
				}

			}
		});
	}

	private void resetCard(Button button, Image backOfCard) {
		button.setImage(backOfCard);
	}
	
	private void removeCard(Button button) {
		button.setVisible(false);
	}

}
