import java.awt.*;
import java.io.Serializable;

public abstract class ThingToPaint implements Serializable {
    private int x;
    private int y;
    private Color color;

    public ThingToPaint(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public abstract boolean contains(Point point);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
