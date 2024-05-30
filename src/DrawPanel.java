import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
    private WhatIsPainting whatIsPainting = WhatIsPainting.NOTHING;
    private List<List<MyPoint>> allLines;
    private List<MyPoint> currentLine;
    private List<ThingToPaint> thingToPaint;
    private List<Object> orderOfPainting;
    private Color colorOfPen = Color.BLACK;

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
                    MyPoint startPoint = new MyPoint(e.getX(), e.getY(), colorOfPen); // Użyj koloru z pędzla
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
                    MyPoint currentPoint = new MyPoint(e.getX(), e.getY(), colorOfPen); // Użyj koloru z pędzla
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Object obj : orderOfPainting) {
            if (obj instanceof ThingToPaint) {
                ((ThingToPaint) obj).draw(g2d);
            } else if (obj instanceof List) {
                List<MyPoint> line = (List<MyPoint>) obj;
                g2d.setColor(line.get(0).getColor());
                MyPoint previousPoint = line.get(0);
                for (int i = 1; i < line.size(); i++) {
                    MyPoint currentPoint = line.get(i);
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
    public void loadPanel(DrawPanel drawPanel, ObjectInputStream loadedPanelRaw) {
        DrawPanel loadedPanel = null;
        try {
            loadedPanel = (DrawPanel) loadedPanelRaw.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        drawPanel.setAllLines(loadedPanel.getAllLines());
        drawPanel.setCurrentLine(loadedPanel.getCurrentLine());
        drawPanel.setThingToPaint(loadedPanel.getThingToPaint());
        drawPanel.setOrderOfPainting(loadedPanel.getOrderOfPainting());
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

    public void setColorOfPen(Color colorOfPen) {
        this.colorOfPen = colorOfPen;
    }

    public List<Object> getOrderOfPainting() {
        return orderOfPainting;
    }

    public List<List<MyPoint>> getAllLines() {
        return allLines;
    }

    public void setAllLines(List<List<MyPoint>> allLines) {
        this.allLines = allLines;
    }

    public List<MyPoint> getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(List<MyPoint> currentLine) {
        this.currentLine = currentLine;
    }

    public List<ThingToPaint> getThingToPaint() {
        return thingToPaint;
    }

    public void setThingToPaint(List<ThingToPaint> thingToPaint) {
        this.thingToPaint = thingToPaint;
    }

    public void setOrderOfPainting(List<Object> orderOfPainting) {
        this.orderOfPainting = orderOfPainting;
    }

    public Color getColorOfPen() {
        return colorOfPen;
    }
}