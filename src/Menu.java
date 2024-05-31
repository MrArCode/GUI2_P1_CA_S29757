import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu {
    private JMenuBar appMenu;

    private JMenu fileMenu;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem quit;

    private JMenu drawMenu;
    private JMenu figure;
    private JMenuItem color;
    private JMenuItem clear;

    private JRadioButtonMenuItem circle;
    private JRadioButtonMenuItem square;
    private JRadioButtonMenuItem pen;
    private ButtonGroup buttonGroup;

    private AppFrame appFrame;


    public Menu(AppFrame appFrame) {
        this.appFrame = appFrame;
        appMenu = new JMenuBar();
        appMenu.add(fileMenu());
        appMenu.add(drawMenu());

    }

    public JMenu fileMenu() {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        open = JMenuItemFactory.open(appFrame);
        save = JMenuItemFactory.save(appFrame);
        saveAs = JMenuItemFactory.saveAs(appFrame);
        quit = JMenuItemFactory.quit(appFrame);

        JMenuItem[] fileButtonTab = {open, save, saveAs, quit};

        addToMenu(fileMenu, fileButtonTab);

        return fileMenu;
    }

    public JMenu drawMenu() {
        drawMenu = new JMenu("Draw");
        drawMenu.setMnemonic(KeyEvent.VK_D);

        figure = JMenuItemFactory.figure(appFrame);
        circle = JMenuItemFactory.circle(appFrame);
        square = JMenuItemFactory.square(appFrame);
        pen = JMenuItemFactory.pen(appFrame);

        figure.add(circle);
        figure.add(square);
        figure.add(pen);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(circle);
        buttonGroup.add(square);
        buttonGroup.add(pen);

        color = JMenuItemFactory.color(appFrame);
        clear = JMenuItemFactory.clear(appFrame);

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

    public JMenuItem getOpen() {
        return open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public JMenuItem getQuit() {
        return quit;
    }

    public JMenuItem getColor() {
        return color;
    }

    public JMenuItem getClear() {
        return clear;
    }

    public JRadioButtonMenuItem getCircle() {
        return circle;
    }

    public JRadioButtonMenuItem getSquare() {
        return square;
    }

    public JRadioButtonMenuItem getPen() {
        return pen;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }
}
