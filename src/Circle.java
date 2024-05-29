import java.awt.*;
import java.io.Serializable;

class Circle extends ThingToPaint {
    private final int diameter = 50; // Stały promień koła

    public Circle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX() - diameter / 2, getY() - diameter / 2, diameter, diameter);
    }

}