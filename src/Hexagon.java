import java.awt.*;

public class Hexagon implements Shape{
    private int x;
    private int y;
    private Color color;
	public void setColor(Color color){
		this.color = color;
	}

	public Color getColor(){
		return color;
	}

    public Hexagon(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public void draw(Graphics g){
        g.setColor(color);
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];
        int size = 10;
        for (int i = 0; i < 6; i++) {
            xPoints[i] = x + (int) (size * Math.cos(i * 2 * Math.PI / 6));
            yPoints[i] = y + (int) (size * Math.sin(i * 2 * Math.PI / 6));
        }
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}