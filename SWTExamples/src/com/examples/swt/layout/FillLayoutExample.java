package com.examples.swt.layout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class FillLayoutExample {
	private Shell _shell;
	private Image _image;

	public FillLayoutExample(Display display) {
		_shell = new Shell(display);
		_shell.setLayout(new org.eclipse.swt.layout.FillLayout());

		_shell.setText("Fill Layout");
		Device dev = _shell.getDisplay();
		try {
			_image = new Image(dev, "image.png");
		} catch (Exception ex) {
			System.out.println("Cannot load image");
			System.out.println(ex.getMessage());
			System.exit(1);
		}
		initUI();

		Rectangle rect = _image.getBounds();
		_shell.setSize(rect.width, rect.height);
		_shell.setLocation(500, 500);

		_shell.open();

		while (!_shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void initUI() {
		Label label = new Label(_shell, SWT.IMAGE_PNG);
		label.setImage(_image);
		label.pack();
	}

	public static void main(String[] args) {
		Display display = new Display();
		new FillLayoutExample(display);
		display.dispose();
	}
}
