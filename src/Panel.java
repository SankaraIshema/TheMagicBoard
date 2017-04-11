import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private Color pointerColor = Color.BLACK;
	private int size =  10;
	private String shape = "Circle";
	private ArrayList<Point> points = new ArrayList<>();
	
	private boolean erase = false;
	
	
	public Panel() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				points.add(new Point(pointerColor, size, e.getX(), e.getY(), shape));
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				points.add(new Point(pointerColor, size, e.getX(), e.getY(), shape));
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics graph) {
		if(erase) {
			erase = false;
			clearBoard();
		}
		else {
			graph.setColor(Color.WHITE);
			graph.fillRect(0, 0, getWidth(), getHeight());
			
			for(Point p : points) {
				graph.setColor(p.getColor());
				
				if(shape.equals("Square")) {
					graph.fillRect(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
				}
				else {
					graph.fillOval(p.getPosX(), p.getPosY(), p.getSize(), p.getSize());
				}
			}
		}
	}

	public void setErase(boolean erase) {
		this.erase = erase;
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}

	public void setPointerColor(Color pointerColor) {
		this.pointerColor = pointerColor;
	}

	public void clearBoard() {
		points = new ArrayList<Point>();
		repaint();
	}
	
	
}

