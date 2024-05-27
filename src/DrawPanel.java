import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    private int startX, startY;
    private int endX, endY;
    private boolean drawingCircle;

    public DrawPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                endX = startX;
                endY = startY;
                drawingCircle = true;
                repaint(); // Odśwież panel, aby pokazać początkowy punkt koła
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawingCircle = false;
                repaint(); // Odśwież panel, aby pokazać pełne koło
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint(); // Odśwież panel, aby pokazać koło w czasie rysowania
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawingCircle) {
            int diameter = Math.max(Math.abs(endX - startX), Math.abs(endY - startY));
            int radius = diameter / 2;
            int centerX = startX < endX ? startX + radius : startX - radius;
            int centerY = startY < endY ? startY + radius : startY - radius;
            g.setColor(Color.BLACK);
            g.drawOval(centerX - radius, centerY - radius, diameter, diameter);
        }
    }
}