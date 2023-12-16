import java.awt.*;

public class Triangle implements Shape{
    private int x;
    private int y;
    private Color color;
	public void setColor(Color color){
		this.color = color;
	}

	public Color getColor(){
		return color;
	}

    public Triangle(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public void draw(Graphics g){
        g.setColor(color);
        int size = 10;
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        for (int i = 0; i < 3; i++) {
            xPoints[i] = x + (int) (size * Math.cos(i * 2 * Math.PI / 3));
            yPoints[i] = y + (int) (size * Math.sin(i * 2 * Math.PI / 3));
        }
        g.fillPolygon(xPoints, yPoints, 3);
    }

}