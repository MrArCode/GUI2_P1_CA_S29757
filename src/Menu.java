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

        ButtonGroup buttonGroup = new ButtonGroup();
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

    public void setAppMenu(JMenuBar appMenu) {
        this.appMenu = appMenu;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public void setOpen(JMenuItem open) {
        this.open = open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public void setSave(JMenuItem save) {
        this.save = save;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public void setSaveAs(JMenuItem saveAs) {
        this.saveAs = saveAs;
    }

    public JMenuItem getQuit() {
        return quit;
    }

    public void setQuit(JMenuItem quit) {
        this.quit = quit;
    }

    public JMenu getDrawMenu() {
        return drawMenu;
    }

    public void setDrawMenu(JMenu drawMenu) {
        this.drawMenu = drawMenu;
    }

    public JMenu getFigure() {
        return figure;
    }

    public void setFigure(JMenu figure) {
        this.figure = figure;
    }

    public JMenuItem getColor() {
        return color;
    }

    public void setColor(JMenuItem color) {
        this.color = color;
    }

    public JMenuItem getClear() {
        return clear;
    }

    public void setClear(JMenuItem clear) {
        this.clear = clear;
    }

    public JRadioButtonMenuItem getCircle() {
        return circle;
    }

    public void setCircle(JRadioButtonMenuItem circle) {
        this.circle = circle;
    }

    public JRadioButtonMenuItem getSquare() {
        return square;
    }

    public void setSquare(JRadioButtonMenuItem square) {
        this.square = square;
    }

    public JRadioButtonMenuItem getPen() {
        return pen;
    }

    public void setPen(JRadioButtonMenuItem pen) {
        this.pen = pen;
    }
}
