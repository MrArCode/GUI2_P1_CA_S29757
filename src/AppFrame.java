import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppFrame implements ActionListener {
    private JFrame appFrame;
    private Menu menu;
    private ToolBar toolBar;
    private DrawPanel drawPanel;
    private String filePath = "";

    public AppFrame() {
        appFrame = createFrame();

        menu = new Menu(this);
        appFrame.setJMenuBar(menu.getAppMenu());

        drawPanel = new DrawPanel();
        appFrame.add(drawPanel);

        toolBar = new ToolBar();
        drawPanel.setToolBar(toolBar);
        appFrame.add(toolBar.getToolBar(), BorderLayout.SOUTH);


    }

    public JFrame createFrame() {
        JFrame frame = new JFrame("Simple Draw");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menu.getOpen()) {
            Logic.open(this);
        }
        if (actionEvent.getSource() == menu.getSave()) {
            Logic.save(this);
        }
        if (actionEvent.getSource() == menu.getSaveAs()) {
            Logic.saveAs(this);
        }

        if (actionEvent.getSource() == menu.getQuit()) {
            Logic.quit();
        }

        if (actionEvent.getSource() == menu.getCircle()) {
            Logic.circle(drawPanel);
            toolBar.setjTextFieldLeft("Circle");
        }
        if (actionEvent.getSource() == menu.getSquare()) {
            Logic.square(drawPanel);
            toolBar.setjTextFieldLeft("Square");
        }
        if (actionEvent.getSource() == menu.getPen()) {
            Logic.line(drawPanel);
            toolBar.setjTextFieldLeft("Pen");
        }
        if (actionEvent.getSource() == menu.getClear()) {
            drawPanel.resetPanel();
        }
        if (actionEvent.getSource() == menu.getColor()) {
            Color color = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);
            drawPanel.setColorOfPen(color);
        }


    }

    public JFrame getAppFrame() {
        return appFrame;
    }

    public void setAppFrame(JFrame appFrame) {
        this.appFrame = appFrame;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(ToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public void setDrawPanel(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
