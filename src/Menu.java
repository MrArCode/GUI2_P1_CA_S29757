import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu implements ActionListener {
    private JMenuBar appMenu;

    private JMenu fileMenu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem quit;

    private JMenu drawMenu;
    private JMenuItem figure;
    private JMenuItem color;
    private JMenuItem clear;


    public Menu() {
        appMenu = new JMenuBar();
        appMenu.add(fileMenu());
        appMenu.add(drawMenu());
    }

    public JMenu fileMenu() {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        open = JMenuItemFactory.open(this);
        save = JMenuItemFactory.save(this);
        saveAs = JMenuItemFactory.saveAs(this);
        quit = JMenuItemFactory.quit(this);

        JMenuItem[] fileButtonTab = {open, save, saveAs, quit};

        addToMenu(fileMenu, fileButtonTab);

        return fileMenu;
    }

    public JMenu drawMenu() {
        drawMenu = new JMenu("Draw");
        drawMenu.setMnemonic(KeyEvent.VK_D);

        figure = JMenuItemFactory.figure(this);
        color = JMenuItemFactory.color(this);
        clear = JMenuItemFactory.clear(this);

        JMenuItem[] fileButtonTab = {figure, color, clear};

        addToMenu(drawMenu, fileButtonTab);

        return drawMenu;
    }

    public JMenuBar getAppMenu() {
        return appMenu;
    }

    public void addToMenu(JMenu menu, JMenuItem[] tab) {
        for (JMenuItem j : tab) {
            menu.add(j);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open){
            System.out.println("open");
        }else if (e.getSource() == quit) {
            System.exit(0);
        }
    }
}
