import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawPanel extends JPanel {
    private java.util.List<Circle> circles;
    private ThingToPaint thingToPaint = ThingToPaint.NOTHING;

    public DrawPanel() {
//        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        circles = new ArrayList<>();

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                    SwingUtilities.convertPointFromScreen(mousePosition, DrawPanel.this);
                    int circleX = mousePosition.x;
                    int circleY = mousePosition.y;
                    Color randomColor = getRandomColor();
                    circles.add(new Circle(circleX, circleY, randomColor));
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : circles) {
            circle.draw(g);
        }
    }

    private class Circle {
        private int x;
        private int y;
        private Color color;
        private final int diameter = 50; // Stały promień koła

        public Circle(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
        }
    }

    private Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
