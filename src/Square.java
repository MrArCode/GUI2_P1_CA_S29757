import java.awt.*;

public class Square extends ThingToPaint{
    public Square(int x, int y, Color color) {
        super(x, y, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX()-25,getY()-25,50,50);
    }
}
