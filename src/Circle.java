//	Circle.java

import java.awt.*;

// Shape を抽象クラスではなくインタフェースとして定義した版
// extends ではなく、implements を使用．

public class Circle implements Shape {
	private int x;
	private int y;
	private int size = 10;
	private Color color;
	public void setColor(Color color){
		this.color = color;
	}

	public Color getColor(){
		return color;
	}
	
	public Circle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, size, size);
	}
	
}