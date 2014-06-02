package com.examples.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ComboExample {
  private Shell _shell;
  
  public ComboExample(Display display) {
    _shell = new Shell(display);
    _shell.setText("Combo Example");
    initUI();
    
    _shell.setSize(300, 200);
    _shell.setLocation(500, 500);
    
    _shell.open();
    
    while(!_shell.isDisposed()) {
      if(!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }
  
  private void initUI() {
    final Label label = new Label(_shell, SWT.LEFT);
    label.setText("...");
    
    label.setLocation(50, 100);
    label.pack();
    
    final Combo combo = new Combo(_shell, SWT.DROP_DOWN);
    combo.add("Ubuntu");
    combo.add("Fedora");
    combo.add("Mandriva");
    combo.add("Red Hat");
    combo.add("Mint");
    
    combo.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        label.setText(combo.getText());
        label.pack();
      }
    });
    
    combo.setLocation(50, 30);
    combo.pack();
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    new ComboExample(display);
    display.dispose();
  }
}
