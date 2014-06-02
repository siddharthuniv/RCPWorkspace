package com.examples.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CheckButtonExample {
  private Shell _shell;
  private Button _cb;
  
  public CheckButtonExample(Display display) {
    _shell = new Shell(display);
    _shell.setText("Check Button");
    
    initUI();
    
    _shell.setSize(250, 200);
    _shell.setLocation(300, 300);
    
    _shell.open();
    
    
    while(!_shell.isDisposed()) {
      if(!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }
  
  private void initUI() {
    _cb = new Button(_shell, SWT.CHECK);
    _cb.setText("Show Title");
    _cb.setSelection(true);
    _cb.setLocation(50, 50);
    _cb.pack();
    
    _cb.addSelectionListener(new SelectionAdapter() {
      
      @Override
      public void widgetSelected(SelectionEvent e) {
        if(_cb.getSelection()) {
          _shell.setText("Check Button");
        } else {
          _shell.setText("");
        }
      }
    });
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    new CheckButtonExample(display);
    display.dispose();
  }
}
