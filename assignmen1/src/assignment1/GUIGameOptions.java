package assignment1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class GUIGameOptions extends Dialog {

	protected Object result;
	protected Shell shell;
	private String[] decks = CardImages.getDecknames();
	private LogicGameOptions gameOptions;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GUIGameOptions(Shell parent, int style) {
		super(parent, SWT.DIALOG_TRIM |SWT.PRIMARY_MODAL);
		setText("Game Options");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public LogicGameOptions open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return gameOptions;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setMinimumSize(new Point(340, 150));
		shell.setMaximumSize(new Point(340, 150));
		shell.setSize(340, 150);
		shell.setText(getText());
		shell.setLayout(null);
		
		shell.addListener(SWT.Close, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				System.exit(1);
			}
			
		});
		
		Group grpPlayers = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		grpPlayers.setBounds(13, 0, 281, 90);
		
		Label lblEnterNumberOf = new Label(grpPlayers, SWT.NONE);
		lblEnterNumberOf.setBounds(10, 20, 181, 15);
		lblEnterNumberOf.setText("Enter Number of Players:");
		
		Spinner spinner = new Spinner(grpPlayers, SWT.BORDER);
		spinner.setPageIncrement(1);
		spinner.setMinimum(2);
		spinner.setSelection(2);
		spinner.setBounds(228, 17, 47, 22);
		
		Label lblSelectDeckOf = new Label(grpPlayers, SWT.NONE);
		lblSelectDeckOf.setBounds(10, 51, 125, 15);
		lblSelectDeckOf.setText("Select Deck of Cards:");
		
		Combo combo = new Combo(grpPlayers, SWT.NONE);
		combo.setBounds(153, 43, 125, 23);
		combo.setItems(decks);
		combo.select(0);
		
		Label lblSingleFlipMode = new Label(grpPlayers, SWT.NONE);
		lblSingleFlipMode.setBounds(10, 72, 107, 15);
		lblSingleFlipMode.setText("Single Flip Mode:");
		
		Button btnActivated = new Button(grpPlayers, SWT.CHECK);
		btnActivated.setBounds(204, 71, 71, 16);
		btnActivated.setText("Activated");
		
		Button btnOkay = new Button(shell, SWT.NONE);
		btnOkay.setBounds(219, 96, 75, 25);
		btnOkay.setText("Okay");
		btnOkay.addListener(SWT.Selection,new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				gameOptions = new LogicGameOptions(spinner.getSelection(), combo.getSelectionIndex(), btnActivated.getSelection());
				gameOptions.displaySelection();
				shell.dispose();
			}
		});
		
		Button btnResetToDefaults = new Button(shell, SWT.NONE);
		btnResetToDefaults.setBounds(138, 96, 75, 25);
		btnResetToDefaults.setText("Defaults");
		btnResetToDefaults.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				gameOptions = new LogicGameOptions(2, 0, false);
				gameOptions.displaySelection();
				shell.dispose();
				
			}
			
		});

	}
}
