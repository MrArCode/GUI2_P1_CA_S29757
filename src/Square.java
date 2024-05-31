import java.awt.*;

public class Square extends ThingToPaint {
    private final int size = 50;

    public Square(int x, int y, Color color) {
        super(x, y, color);
    }

    public Square() {
        super(0, 0, Color.BLACK);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX() - size / 2, getY() - size / 2, size, size);
    }

    public boolean contains(Point point) {
        int halfSize = size / 2;
        int left = getX() - halfSize;
        int right = getX() + halfSize;
        int top = getY() - halfSize;
        int bottom = getY() + halfSize;
        return point.x >= left && point.x <= right && point.y >= top && point.y <= bottom;
    }
}
