// Shape.java 
import java.awt.Graphics;

// クラス Shape を抽象クラスの代わりに、インタフェースで表現
// 各図形クラスは extends の代わりに implements に置き換える．

/*
public abstract class Shape {
	public static final int CIRCLE		= 0;
	public static final int RECTANGLE 	= 1;
	public static final int LINE		= 2;
	public static final String name[] 	= {"Circle", "Rectangle", "Line"};
	
	public abstract int getX();
	public abstract int getY();
	public abstract void draw(Graphics g);
}
*/

public interface Shape {
	public static final int CIRCLE		= 0;
	public static final int RECTANGLE 	= 1;
	public static final int LINE		= 2;
	public static final String name[] 	= {"Circle", "Rectangle", "Line"};
	
	public abstract int getX();				// 抽象メソッドのみ宣言している
	public abstract int getY();
	public abstract void draw(Graphics g);
}
