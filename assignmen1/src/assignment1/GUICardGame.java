package assignment1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class GUICardGame {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private LogicCurrentGame currentGame;

	GUICardGame(){
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	

	/**
	 * Open the window.
	 */
	public void open(LogicCurrentGame currentGame) {
		Display display = Display.getDefault();		
		createContents(display, currentGame);
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
	protected void createContents(Display display, LogicCurrentGame currentGame) {
		
		// Setting up menu bar at top of screen
		Menu menuBar = new GUIMenuBar(display, shell).getMenuBar();
		shell.setMenuBar(menuBar);
		
		// Retrieving and setting images for cards
		Image backOfCard = new Image(display, currentGame.getBackOfCards());
		String[] cardImageArray = currentGame.getDeckArray();
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setImage(backOfCard);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton.setImage(new Image(display, cardImageArray[0]));
				btnNewButton.getImage();
			}
		});
		
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_1, true, true);
		btnNewButton_1.setImage(backOfCard);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_1.setImage(new Image(display, cardImageArray[1]));
				btnNewButton_1.getImage();
			}
		});
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_2, true, true);
		btnNewButton_2.setImage(backOfCard);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_2.setImage(new Image(display, cardImageArray[2]));
				btnNewButton_2.getImage();
			}
		});
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_3, true, true);
		btnNewButton_3.setImage(backOfCard);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_3.setImage(new Image(display, cardImageArray[3]));
				btnNewButton_3.getImage();
			}
		});
		
		Button btnNewButton_4 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_4, true, true);
		btnNewButton_4.setImage(backOfCard);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_4.setImage(new Image(display, cardImageArray[4]));
				btnNewButton_4.getImage();
			}
		});
		
		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_5, true, true);
		btnNewButton_5.setImage(backOfCard);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_5.setImage(new Image(display, cardImageArray[5]));
				btnNewButton_5.getImage();
			}
		});
		
		Button btnNewButton_6 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_6, true, true);
		btnNewButton_6.setImage(backOfCard);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_6.setImage(new Image(display, cardImageArray[6]));
				btnNewButton_6.getImage();
			}
		});
				
		Button btnNewButton_7 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_7, true, true);
		btnNewButton_7.setImage(backOfCard);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_7.setImage(new Image(display, cardImageArray[7]));
				btnNewButton_7.getImage();
			}
		});
		
		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_8, true, true);
		btnNewButton_8.setImage(backOfCard);
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_8.setImage(new Image(display, cardImageArray[8]));
				btnNewButton_8.getImage();
			}
		});
		
		Button btnNewButton_9 = new Button(shell, SWT.NONE);
		formToolkit.adapt(btnNewButton_9, true, true);
		btnNewButton_9.setImage(backOfCard);
		btnNewButton_9.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				btnNewButton_9.setImage(new Image(display, cardImageArray[9]));
				btnNewButton_9.getImage();
			}
		});

	}
}
