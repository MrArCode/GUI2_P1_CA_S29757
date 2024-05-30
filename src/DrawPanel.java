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
    private boolean deleteMode = false;
    private List<ThingToPaint> selectedShapes;

    public DrawPanel() {
        setBackground(Color.WHITE);
        allLines = new ArrayList<>();
        currentLine = new ArrayList<>();
        thingToPaint = new ArrayList<>();
        orderOfPainting = new ArrayList<>();
        selectedShapes = new ArrayList<>();

        setFocusable(true);
        requestFocusInWindow();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (deleteMode) {
                    selectShapeIfClicked(e.getPoint());
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
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    deleteMode = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    deleteMode = false;
                    if (!selectedShapes.isEmpty()) {
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to erase selected figures?", "Erase figures", JOptionPane.YES_NO_OPTION);
                        if (dialogResult == JOptionPane.YES_OPTION) {
                            for (ThingToPaint shape : selectedShapes) {
                                thingToPaint.remove(shape);
                                orderOfPainting.remove(shape);
                            }
                            selectedShapes.clear();
                            repaint();
                        }
                    }
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

    private void selectShapeIfClicked(Point point) {
        for (ThingToPaint shape : thingToPaint) {
            if (shape.contains(point)) {
                if (!selectedShapes.contains(shape)) {
                    selectedShapes.add(shape);
                    repaint();
                }
                return;
            }
        }
    }

    public void resetPanel() {
        allLines.clear();
        currentLine.clear();
        thingToPaint.clear();
        orderOfPainting.clear();
        selectedShapes.clear();
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
