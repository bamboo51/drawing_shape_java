//	Line.java

import java.awt.*;

//Shape を抽象クラスではなくインタフェースとして定義した版
//extends ではなく、implements を使用．

public class Line implements Shape {
	private int x;
	private int y;
	private Color color;
	public void setColor(Color color){
		this.color = color;
	}

	public Color getColor(){
		return color;
	}
		
	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	public int getX() { return x; }
	public int getY() { return y; }
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, x+10, y+10);
	}
		
}