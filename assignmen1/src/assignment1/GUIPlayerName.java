package assignment1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GUIPlayerName extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private String playerName;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GUIPlayerName(Shell parent, int style) {
		super(parent, SWT.DIALOG_TRIM |SWT.PRIMARY_MODAL);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public String open(int playerNumber) {
		createContents(playerNumber);
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return playerName;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents(int playerNumber) {
		shell = new Shell(getParent(), getStyle());
		shell.setMaximumSize(new Point(136, 139));
		shell.setSize(286, 140);
		shell.setText(getText());
		shell.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("Enter Player " + playerNumber + "'s Name:");
		new Label(shell, SWT.NONE);
		
		text = new Text(shell, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 248;
		text.setLayoutData(gd_text);
		text.setText("Player " + playerNumber);
		text.forceFocus();
		text.selectAll();
		
		Button btnOkay = new Button(shell, SWT.RIGHT);
		btnOkay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				playerName = text.getText();
				shell.dispose();
			}
		});
		btnOkay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnOkay.setText("Submit");
		
		shell.addListener(SWT.Close, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				System.exit(1);
			}
			
		});
	}

}
