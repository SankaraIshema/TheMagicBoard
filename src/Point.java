import java.awt.Color;

public class Point {
	
	private Color color = Color.BLACK;
	private int size = 10;
	private int posX = -10;
	private int posY = -10;
	private String shape = "Circle";
	
	
	public Point(Color color, int size, int posX, int posY, String shape) {
		super();
		this.color = color;
		this.size = size;
		this.posX = posX;
		this.posY = posY;
		this.shape = shape;
	}
	
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
}
