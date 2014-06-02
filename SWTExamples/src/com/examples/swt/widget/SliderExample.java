package com.examples.swt.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;

public class SliderExample {
  private Shell _shell;
  private Image _mute;
  private Image _min;
  private Image _max;
  private Image _med;
  
  public SliderExample(Display display) {
    _shell = new Shell(display);
    Device dev = _shell.getDisplay();
    
    try {
      _mute = new Image(dev, "mute.png");
      _min = new Image(dev, "min.png");
      _max = new Image(dev, "max.png");
      _med = new Image(dev, "med.png");
      
    } catch(Exception ex) {
      System.out.println("Cannot load images");
      System.out.println(ex.getMessage());
      System.exit(1);
    }
    _shell.setText("Slider Example");
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
    final Label label = new Label(_shell, SWT.IMAGE_PNG);
    label.setImage(_mute);
    label.pack();
    label.setLocation(240, 30);
    
    final Slider slider = new Slider(_shell, SWT.HORIZONTAL);
    slider.setMaximum(100);
    slider.setBounds(30, 30, 180, 30);
    
    slider.addListener(SWT.Selection, new Listener() {

      @Override
      public void handleEvent(Event arg0) {
        int value = slider.getSelection();
        if(value == 0) {
          label.setImage(_mute);
          label.pack();
        } else if(value > 0 && value <= 30) {
          label.setImage(_min);
        } else if(value > 30 && value < 80) {
          label.setImage(_med);
        } else {
          label.setImage(_max);
        }
      }
    });
  }
  
  @Override
  public void finalize() {
    System.out.println("Disposing images");
    _mute.dispose();
    _max.dispose();
    _min.dispose();
    _med.dispose();
  }
  
  public static void main(String[] args) {
    Display display = new Display();
    SliderExample ex = new SliderExample(display);
    ex.finalize();
    display.dispose();
  }
}
