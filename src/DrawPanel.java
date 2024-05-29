import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
    private WhatIsPainting whatIsPainting = WhatIsPainting.NOTHING;
    private List<List<Point>> allLines;
    private List<Point> currentLine;
    private List<ThingToPaint> thingToPaint;
    private List<Object> orderOfPainting;

    public DrawPanel() {
        setBackground(Color.WHITE);
        allLines = new ArrayList<>();
        currentLine = new ArrayList<>();
        thingToPaint = new ArrayList<>();
        orderOfPainting = new ArrayList<>();

        setFocusable(true);
        requestFocusInWindow();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (whatIsPainting == WhatIsPainting.LINE) {
                    currentLine = new ArrayList<>(); // Nowa linia
                    Point startPoint = e.getPoint();
                    currentLine.add(startPoint);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (whatIsPainting == WhatIsPainting.LINE) {
                    allLines.add(new ArrayList<>(currentLine)); // Dodaj obecną linię do listy wszystkich linii
                    orderOfPainting.add(new ArrayList<>(currentLine));
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (whatIsPainting == WhatIsPainting.LINE) {
                    Point currentPoint = e.getPoint();
                    currentLine.add(currentPoint);
                    orderOfPainting.add(new ArrayList<>(currentLine)); // Dodaj obecną linię do listy wszystkich linii
                    repaint();
                }
            }
        });


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                    SwingUtilities.convertPointFromScreen(mousePosition, DrawPanel.this);
                    int shapeX = mousePosition.x;
                    int shapeY = mousePosition.y;
                    Color randomColor = getRandomColor();
                    if (whatIsPainting == WhatIsPainting.SQUARE) {
                        Square square = new Square(shapeX, shapeY, randomColor);
                        thingToPaint.add(square);
                        orderOfPainting.add(square);
                    } else if (whatIsPainting == WhatIsPainting.CIRCLE) {
                        Circle circle = new Circle(shapeX, shapeY, randomColor);
                        thingToPaint.add(circle);
                        orderOfPainting.add(circle);
                    }
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Object obj : orderOfPainting) {
            if (obj instanceof ThingToPaint) {
                ((ThingToPaint) obj).draw(g2d);
            } else if (obj instanceof List) {
                List<Point> line = (List<Point>) obj;
                g2d.setColor(Color.BLACK);
                Point previousPoint = line.get(0);
                for (int i = 1; i < line.size(); i++) {
                    Point currentPoint = line.get(i);
                    g2d.drawLine(previousPoint.x, previousPoint.y, currentPoint.x, currentPoint.y);
                    previousPoint = currentPoint;
                }
            }
        }
    }
    public void resetPanel() {
        allLines.clear();
        currentLine.clear();
        thingToPaint.clear();
        orderOfPainting.clear();
        repaint();
    }

    public Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public WhatIsPainting getWhatIsPainting() {
        return whatIsPainting;
    }

    public void setWhatIsPainting(WhatIsPainting whatIsPainting) {
        this.whatIsPainting = whatIsPainting;
    }
}
