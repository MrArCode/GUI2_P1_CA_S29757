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
        // Tworzenie mapy, która mapuje obiekty na akcje
        Map<Object, Runnable> actionsMap = new HashMap<>();
        actionsMap.put(menu.getQuit(), Logic::quit);
        actionsMap.put(menu.getOpen(), Logic::open);

        // Pobieranie źródła
        Object source = actionEvent.getSource();

        Runnable action = actionsMap.get(source);
        if (action != null) {
            action.run();
        } else {
            throw new IllegalStateException("Unexpected value: " + source);
        }
    }
}
