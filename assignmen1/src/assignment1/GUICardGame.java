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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUICardGame {

	protected Shell shell;
	private String[] cardImageArray;
	private Button[] buttonArray;
	private LogicCurrentGame currentGame;
	private Button playAgain;
	private Label gameLabel;

	GUICardGame() {
		shell = new Shell();
		shell.setMaximumSize(new Point(620, 340));
		shell.setMinimumSize(new Point(620, 340));
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
		Image backOfCard = new Image(display, currentGame.getBackOfCards());
//		
//		playAgain = new Button(shell, SWT.None);
//		playAgain.setText("Restart Game");
////		playAgain.setVisible(false);
//		playAgain.addSelectionListener(new SelectionAdapter(){
//			public void widgetSelected(SelectionEvent event) {
//				shell.dispose();
//				GameController.main(null);
//			}
//		});

		Button btnNewButton = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton, backOfCard, 0);
		buttonArray[0] = btnNewButton;

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_1, backOfCard, 1);
		buttonArray[1] = btnNewButton_1;

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_2, backOfCard, 2);
		buttonArray[2] = btnNewButton_2;

		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_3, backOfCard, 3);
		buttonArray[3] = btnNewButton_3;

		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_4, backOfCard, 4);
		buttonArray[4] = btnNewButton_4;

		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_5, backOfCard, 5);
		buttonArray[5] = btnNewButton_5;

		Button btnNewButton_6 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_6, backOfCard, 6);
		buttonArray[6] = btnNewButton_6;

		Button btnNewButton_7 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_7, backOfCard, 7);
		buttonArray[7] = btnNewButton_7;

		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_8, backOfCard, 8);
		buttonArray[8] = btnNewButton_8;

		Button btnNewButton_9 = new Button(shell, SWT.NONE);
		createButton(display, btnNewButton_9, backOfCard, 9);
		buttonArray[9] = btnNewButton_9;
		

		gameLabel = new Label(shell, SWT.NONE);
		gameLabel.setText(currentGame.getPlayer() + " Score " + currentGame.getScore());
		gameLabel.setSize(500, 24);
		gameLabel.setFont(SWTResourceManager.getFont("Tempus Sans ITC", 16, SWT.BOLD));
			

		
	}

	private void createButton(Display display, Button button, Image backOfCard, int cardNumber) {
		resetCard(button, backOfCard);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				button.setImage(new Image(display, cardImageArray[cardNumber]));

				if (!currentGame.isFirstSelected() && cardNumber != currentGame.getPlayerSelection1()) {
					currentGame.setPlayerSelection1(cardNumber);
				}
				else if(!currentGame.isSecondSelected() && cardNumber != currentGame.getPlayerSelection1()) {
					currentGame.setPlayerSelection2(cardNumber);
				}
				
				
				if(currentGame.isFirstSelected() && currentGame.isSecondSelected()) {
					for(int i = 0; i < buttonArray.length; i++) {
						buttonArray[i].setEnabled(false);
					}
					
					if(currentGame.matchLocated()) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						removeCard(buttonArray[currentGame.getPlayerSelection1()]);
						removeCard(buttonArray[currentGame.getPlayerSelection2()]);
						currentGame.endRoundWin();
						
					}
					else {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						resetCard(buttonArray[currentGame.getPlayerSelection1()], backOfCard);
						resetCard(buttonArray[currentGame.getPlayerSelection2()], backOfCard);
						currentGame.endRoundLoss();
						
					}
					
					for(int i = 0; i < buttonArray.length; i++) {
						buttonArray[i].setEnabled(true);
					}
					
					gameLabel.setText(currentGame.getPlayer() + " Score " + currentGame.getScore());
					gameLabel.setSize(500, 24);
					
					if(currentGame.getTotalGameScore() == buttonArray.length / 2) {
						gameLabel.setLocation(50, 100);
						gameLabel.setSize(640, 30);
						gameLabel.setText("Congradulations, " + currentGame.getWinner() + " wins this game!");						
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
