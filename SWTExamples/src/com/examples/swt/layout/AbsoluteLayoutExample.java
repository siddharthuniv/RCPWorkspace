package com.examples.swt.layout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class AbsoluteLayoutExample {
	private Shell _shell;
	
	public AbsoluteLayoutExample(Display display) {
		_shell = new Shell(display);
		_shell.setText("Absolute Layout");
		
		initUI();
		
		_shell.setSize(250, 250);
		_shell.setLocation(300, 300);
		
		_shell.open();
		while(!_shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void initUI() {
		Button button1 = new Button(_shell, SWT.PUSH);
		button1.setText("Button1");
		button1.setBounds(0, 0, 50, 50);
		
		Button button2 = new Button(_shell, SWT.PUSH);
		button2.setText("Button2");
		button2.setBounds(50, 50, 100, 50);
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		new AbsoluteLayoutExample(display);
		display.dispose();
	}
}
