import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame implements ActionListener {
    JFrame appFrame;
    Menu menu;
    ToolBar toolBar;

    public AppFrame() {
        appFrame = createFrame();

        menu = new Menu(this);
        appFrame.setJMenuBar(menu.getAppMenu());

        appFrame.add(new DrawPanel());

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
            toolBar.setjTextFieldLeft("Circle");
        } else if (actionEvent.getSource() == menu.getSquare()) {
            toolBar.setjTextFieldLeft("Square");
        } else if(actionEvent.getSource() == menu.getPen()){
            toolBar.setjTextFieldLeft("Pen");
        }
    }
}
