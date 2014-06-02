package com.examples.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ListExample {
  private Shell _shell;
  
  public ListExample(Display display) {
   _shell = new Shell(display);
   _shell.setText("List Example");
   initUI();
   
   _shell.setSize(500, 500);
   _shell.setLocation(500, 500);
   
   _shell.open();
   
   while(!_shell.isDisposed()) {
     if(!display.readAndDispatch()) {
       display.sleep();
     }
   }
  }
  
  private void initUI() {
    final Label status = new Label(_shell, SWT.BORDER);
    status.setText("Ready");
    
    FormLayout layout = new FormLayout();
    _shell.setLayout(layout);
    
    FormData labelData = new FormData();
    labelData.left = new FormAttachment(0);
    labelData.right = new FormAttachment(100);
    labelData.bottom = new FormAttachment(100);
    status.setLayoutData(labelData);
    
    final List list = new List(_shell, SWT.BORDER);
    list.add("Aliens");
    list.add("Capote");
    list.add("Neverending story");
    list.add("Starship troopers");
    list.add("Exorcist");
    list.add("Omen");
    
    list.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        String[] items = list.getSelection();
        status.setText(items[0]);
      }
    });
    
    FormData listData = new FormData();
    listData.left = new FormAttachment(_shell, 50, SWT.LEFT);
    listData.top = new FormAttachment(_shell, 30, SWT.TOP);
    list.setLayoutData(listData);
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    new ListExample(display);
    display.dispose();
  }
}
