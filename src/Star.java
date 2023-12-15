import java.awt.*;

public class Star implements Shape{
    private int x;
    private int y;

    public Star(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public void draw(Graphics g){
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        int size=10;
        // Calculate vertices for a star
        for (int i = 0; i < 10; i++) {
            int angleDeg = i * 36;
            if (i % 2 == 0) {
                xPoints[i] = x + (int) (size * Math.cos(Math.toRadians(angleDeg)));
                yPoints[i] = y + (int) (size * Math.sin(Math.toRadians(angleDeg)));
            } else {
                xPoints[i] = x + (int) (size / 2 * Math.cos(Math.toRadians(angleDeg)));
                yPoints[i] = y + (int) (size / 2 * Math.sin(Math.toRadians(angleDeg)));
            }
        }

        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }

}