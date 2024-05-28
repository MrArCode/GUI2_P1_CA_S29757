import javax.swing.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class JMenuItemFactory {


    public static JMenuItem open(Menu menu) {
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(menu);
        open.setMnemonic(KeyEvent.VK_O);
        KeyStroke openKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        open.setAccelerator(openKeyStroke);
        return open;

    }

    public static JMenuItem save(Menu menu) {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(menu);
        save.setMnemonic(KeyEvent.VK_S);
        KeyStroke saveKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        save.setAccelerator(saveKeyStroke);

        return save;

    }

    public static JMenuItem saveAs(Menu menu) {
        JMenuItem saveAs = new JMenuItem("Save As...");
        saveAs.addActionListener(menu);
        saveAs.setMnemonic(KeyEvent.VK_A);
        KeyStroke saveAsKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK);
        saveAs.setAccelerator(saveAsKeyStroke);
        return saveAs;

    }

    public static JMenuItem quit(Menu menu) {
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(menu);
        quit.setMnemonic(KeyEvent.VK_Q);
        KeyStroke quitKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        quit.setAccelerator(quitKeyStroke);
        return quit;

    }

    public static JMenu figure(Menu menu) {
        JMenu figure = new JMenu("Figure");
        figure.addActionListener(menu);
        figure.setMnemonic(KeyEvent.VK_F);

        JRadioButtonMenuItem circle = circle(menu);
        JRadioButtonMenuItem square = square(menu);
        JRadioButtonMenuItem pen = pen(menu);

        figure.add(circle);
        figure.add(square);
        figure.add(pen);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(circle);
        buttonGroup.add(square);
        buttonGroup.add(pen);

        return figure;

    }
    public static JMenuItem color(Menu menu) {
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(menu);
        color.setMnemonic(KeyEvent.VK_C);
        KeyStroke colorKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.ALT_DOWN_MASK);
        color.setAccelerator(colorKeyStroke);
        return color;

    }
    public static JMenuItem clear(Menu menu) {
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(menu);
        clear.setMnemonic(KeyEvent.VK_L);
        KeyStroke clearKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK);
        clear.setAccelerator(clearKeyStroke);
        return clear;

    }
    public static JRadioButtonMenuItem circle(Menu menu) {
        JRadioButtonMenuItem circle = new JRadioButtonMenuItem("Circle");
        circle.addActionListener(menu);
        circle.setMnemonic(KeyEvent.VK_C);
        KeyStroke circleKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        circle.setAccelerator(circleKeyStroke);
        return circle;

    }
    public static JRadioButtonMenuItem square(Menu menu) {
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Square");
        square.addActionListener(menu);
        square.setMnemonic(KeyEvent.VK_R);
        KeyStroke squareKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        square.setAccelerator(squareKeyStroke);
        return square;
    }
    public static JRadioButtonMenuItem pen(Menu menu) {
        JRadioButtonMenuItem pen = new JRadioButtonMenuItem("Pen");
        pen.addActionListener(menu);
        pen.setMnemonic(KeyEvent.VK_P); // Sam dodałem
        KeyStroke penKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        pen.setAccelerator(penKeyStroke);
        return pen;
    }
}
