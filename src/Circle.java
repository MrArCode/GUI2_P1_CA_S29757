import java.awt.*;

class Circle extends ThingToPaint {
    private final int diameter = 50;

    public Circle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX() - diameter / 2, getY() - diameter / 2, diameter, diameter);
    }

    public boolean contains(Point point) {
        int radius = diameter / 2;
        int centerX = getX();
        int centerY = getY();
        double distance = Math.sqrt(Math.pow(point.x - centerX, 2) + Math.pow(point.y - centerY, 2));
        return distance <= radius;
    }
}
