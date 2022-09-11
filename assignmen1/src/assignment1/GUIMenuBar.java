package assignment1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class GUIMenuBar {
	
	private Menu menuBar;
	
	GUIMenuBar(Display display, Shell shell){
		
		menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		MenuItem gameOptions = new MenuItem(fileMenu, SWT.PUSH);
		gameOptions.setText("Set game options");
		gameOptions.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
			}
			
		});
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("E&xit");
		exitItem.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
	}

	public Menu getMenuBar() {
		return menuBar;
	}
	
	
}
