import java.awt.*;
import java.io.Serializable;

public class Square extends ThingToPaint {
    public Square(int x, int y, Color color) {
        super(x, y, color);
    }

    public Square() {
        super(0, 0, Color.BLACK); // Domyślne wartości, mogą być dostosowane do potrzeb
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX() - 25, getY() - 25, 50, 50);
    }
}
