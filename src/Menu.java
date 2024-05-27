import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener{
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



    public Menu(){
        appMenu = new JMenuBar();
        appMenu.add(fileMenu());
        appMenu.add(drawMenu());
    }

    public JMenu fileMenu(){
        fileMenu = new JMenu("File");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As...");
        quit = new JMenuItem("Quit");


        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.add(quit);

        return fileMenu;
    }

    public JMenu drawMenu(){
        drawMenu = new JMenu("Draw");

        figure = new JMenuItem("Figure");
        color = new JMenuItem("Color");
        clear = new JMenuItem("CLear");

        drawMenu.add(figure);
        drawMenu.add(color);
        drawMenu.add(clear);

        return drawMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public JMenuBar getAppMenu() {
        return appMenu;
    }
}
