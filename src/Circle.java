//	Circle.java

import java.awt.Graphics;

// Shape を抽象クラスではなくインタフェースとして定義した版
// extends ではなく、implements を使用．

public class Circle implements Shape {
	private int x;
	private int y;
	
	public Circle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void draw(Graphics g) {
		g.drawOval(x, y, 10, 10);
	}
	
}