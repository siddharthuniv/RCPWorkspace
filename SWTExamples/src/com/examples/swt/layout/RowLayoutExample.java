package com.examples.swt.layout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class RowLayoutExample {
	private Shell _shell;
	public RowLayoutExample(Display display) {
		_shell = new Shell(display);
		_shell.setText("Row Layout Example");
		
		initUI();
		
		_shell.pack();
		_shell.setLocation(500, 500);
		
		_shell.open();
		
		while(!_shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void initUI() {
	  RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
	  rowLayout.marginTop = 10;
	  rowLayout.marginBottom = 10;
	  rowLayout.marginLeft = 5;
	  rowLayout.marginRight = 5;
	  rowLayout.spacing = 10;
	  
	  _shell.setLayout(rowLayout);
	  
	  Button button1 = new Button(_shell, SWT.PUSH);
	  button1.setText("Button1");
	  button1.setLayoutData(new RowData(80, 30));
	  
	  Button button2 = new Button(_shell, SWT.PUSH);
	  button2.setText("Button2");
	  button2.setLayoutData(new RowData(80, 30));
	  
	  Button button3 = new Button(_shell, SWT.PUSH);
	  button3.setText("Button3");
	  button3.setLayoutData(new RowData(80, 30));
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		new RowLayoutExample(display);
		display.dispose();
	}
}
