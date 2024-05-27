import javax.swing.*;
import java.awt.*;

public class AppFrame {
    JFrame appFrame;

    public AppFrame() {
        appFrame = createFrame();

        Menu menu = new Menu();
        appFrame.setJMenuBar(menu.getAppMenu());

        DrawPanel drawPanel = new DrawPanel();
        appFrame.add(drawPanel.getDrawPanel());

        ToolBar toolBar = new ToolBar();
        appFrame.add(toolBar.getToolBar(), BorderLayout.SOUTH);



    }

    public JFrame createFrame() {
        JFrame frame = new JFrame("Simple Draw");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
}
