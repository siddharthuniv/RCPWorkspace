package com.examples.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CalculatorLayoutExample {
  private Shell _shell;
  
  public CalculatorLayoutExample(Display display) {
    _shell = new Shell(display);
    _shell.setText("Calculator layout example");
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
    GridLayout gl = new GridLayout(4, true);
    gl.horizontalSpacing = 4;
    gl.verticalSpacing = 4;
    gl.marginBottom = 5;
    gl.marginTop = 5;
    
    _shell.setLayout(gl);
    
    String[] buttons = {
      "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"  
    };
    
    Text display = new Text(_shell, SWT.SINGLE);
    GridData gridData = new GridData();
    gridData.horizontalSpan = 4;
    gridData.horizontalAlignment = GridData.FILL;
    display.setLayoutData(gridData);
    
    for(int i = 0; i < buttons.length; i++) {
      if(i == 2) {
        Label lbl = new Label(_shell, SWT.CENTER);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
        lbl.setLayoutData(gd);
      } else {
        Button btn = new Button(_shell, SWT.PUSH);
        btn.setText(buttons[i]);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
        gd.widthHint = 50;
        gd.heightHint = 50;
        btn.setLayoutData(gd);
      }
    }
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    new CalculatorLayoutExample(display);
    display.dispose();
  }
}
