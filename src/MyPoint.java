import java.awt.*;
import java.io.Serializable;

public class MyPoint extends Point implements Serializable {
    private Color color;

    public MyPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
