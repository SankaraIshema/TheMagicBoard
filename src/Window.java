import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Window extends JFrame {
	
	private Panel pan = new Panel();
	
	private JMenuBar menuBar = new JMenuBar();
	
		private JMenu files = new JMenu("Files");
			private JMenuItem clear = new JMenuItem("Clear");
			private JMenuItem close = new JMenuItem("Close");
		
		private JMenu edit  = new JMenu("Edit");
		
			private JMenu shape = new JMenu("Shape");
				private JMenuItem circle = new JMenuItem("Circle");
				private JMenuItem square = new JMenuItem("Square");
				
			private JMenu color = new JMenu("Color");
				private JMenuItem black = new JMenuItem("Black");
				private JMenuItem red   = new JMenuItem("Red");
				private JMenuItem blue  = new JMenuItem("Blue");
				private JMenuItem green = new JMenuItem("Green");

	
	public Window() {
		this.setTitle("Magic Board");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.initMenuBar();
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
	public void initMenuBar() {
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK ));
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.setErase(true);
			}
		});
		
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_DOWN_MASK ));
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		files.add(clear);
		files.add(close);
		
		circle.addActionListener(new ShapeListener());
		square.addActionListener(new ShapeListener());
		
		shape.add(circle);
		shape.add(square);
		
		black.addActionListener(new ColorListener());
		red.addActionListener  (new ColorListener());
		blue.addActionListener (new ColorListener());
		green.addActionListener(new ColorListener());
		
		color.add(black);
		color.add(red);
		color.add(blue);
		color.add(green);
		
		edit.add(shape);
		edit.addSeparator();
		edit.add(color);
		
		menuBar.add(files);
		menuBar.add(edit);
		
		setJMenuBar(menuBar);	
	}
	
	class ShapeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			pan.setShape(((JMenuItem)e.getSource()).getText()); 
		}
	}
	
	class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JMenuItem)e.getSource()).getText()) {
			
			case "Black" :
				pan.setPointerColor(Color.BLACK);
				break;
				
			case "Red" :
				pan.setPointerColor(Color.RED);
				break;
				
			case "Blue" :
				pan.setPointerColor(Color.BLUE);
				break;
				
			case "Green" :
				pan.setPointerColor(Color.GREEN);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
