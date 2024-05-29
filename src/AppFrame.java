import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AppFrame implements ActionListener {
    JFrame appFrame;
    Menu menu;
    ToolBar toolBar;
    DrawPanel drawPanel;

    public AppFrame() {
        appFrame = createFrame();

        menu = new Menu(this);
        appFrame.setJMenuBar(menu.getAppMenu());

        drawPanel = new DrawPanel();
        appFrame.add(drawPanel);

        toolBar = new ToolBar();
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

        if (actionEvent.getSource() == menu.getCircle()){
            Logic.circle(drawPanel);
            toolBar.setjTextFieldLeft("Circle");
        }
        if (actionEvent.getSource() == menu.getSquare()){
            Logic.square(drawPanel);
            toolBar.setjTextFieldLeft("Square");
        }
        if (actionEvent.getSource() == menu.getPen()){
            Logic.line(drawPanel);
            toolBar.setjTextFieldLeft("Pen");
        }
        if (actionEvent.getSource() == menu.getClear()){
            drawPanel.resetPanel();
        }
        if (actionEvent.getSource() == menu.getColor()){
            Color color = JColorChooser.showDialog(null, "Wybierz kolor", Color.BLACK);
            drawPanel.setColorOfPen(color);

        }




    }
}
