package com.examples.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FormLayoutExample {
  private Shell _shell;
  
  public FormLayoutExample(Display display) {
      _shell = new Shell(display);
      _shell.setText("Flow layout example");
      
      initUI();
      
      _shell.setSize(640, 480);
      _shell.setLocation(300, 400);
      
      _shell.open();
      while(!_shell.isDisposed()) {
        if(!display.readAndDispatch()) {
          display.sleep();
        }
      }
  }
  
  private void initUI() {
    FormLayout layout = new FormLayout();
    _shell.setLayout(layout);
    
    Button okButton = new Button(_shell, SWT.PUSH);
    okButton.setText("Ok");
    
    Button cancelButton = new Button(_shell, SWT.PUSH);
    cancelButton.setText("Cancel");
    
    FormData cancelData = new FormData(80, 30);
    cancelData.right = new FormAttachment(98);
    cancelData.bottom = new FormAttachment(95);
    cancelButton.setLayoutData(cancelData);
    
    FormData okData = new FormData(80, 30);
    okData.right = new FormAttachment(cancelButton, -5, SWT.LEFT);
    okData.bottom = new FormAttachment(cancelButton, 0, SWT.BOTTOM);
    okButton.setLayoutData(okData);
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    new FormLayoutExample(display);
    display.dispose();
  }
}
