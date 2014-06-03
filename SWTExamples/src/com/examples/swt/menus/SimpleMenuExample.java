package com.examples.swt.menus;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class SimpleMenuExample {
  private Shell _shell;

  public SimpleMenuExample(Display display) {
    _shell = new Shell(display);
    _shell.setText("Simple Menu");

    initUI();

    _shell.setSize(500, 500);
    _shell.setLocation(500, 500);
    _shell.open();

    while (!_shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  private void initUI() {
    Menu menuBar = new Menu(_shell, SWT.BAR);
    MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
    cascadeFileMenu.setText("&File");

    Menu fileMenu = new Menu(_shell, SWT.DROP_DOWN);
    cascadeFileMenu.setMenu(fileMenu);

    MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
    exitItem.setText("&Exit");

    _shell.setMenuBar(menuBar);

    exitItem.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent evt) {
        _shell.getDisplay().dispose();
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    Display display = new Display();
    new SimpleMenuExample(display);
    display.dispose();
  }
}
