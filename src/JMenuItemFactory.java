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

    public static JMenuItem figure(Menu menu) {
        JMenuItem figure = new JMenuItem("Figure");
        figure.addActionListener(menu);
        figure.setMnemonic(KeyEvent.VK_F);



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
}
