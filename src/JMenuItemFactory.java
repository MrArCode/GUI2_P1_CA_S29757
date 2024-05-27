import javax.swing.*;

public class JMenuItemFactory {


    public static JMenuItem open(Menu menu) {
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(menu);
        return open;

    }

    public static JMenuItem save(Menu menu) {
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(menu);
        return save;

    }

    public static JMenuItem saveAs(Menu menu) {
        JMenuItem saveAs = new JMenuItem("Save As...");
        saveAs.addActionListener(menu);
        return saveAs;

    }

    public static JMenuItem quit(Menu menu) {
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(menu);
        return quit;

    }

    public static JMenuItem figure(Menu menu) {
        JMenuItem figure = new JMenuItem("Figure");
        figure.addActionListener(menu);
        return figure;

    }
    public static JMenuItem color(Menu menu) {
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(menu);
        return color;

    }
    public static JMenuItem clear(Menu menu) {
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(menu);
        return clear;

    }
}
