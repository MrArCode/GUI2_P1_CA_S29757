import javax.swing.*;
import java.awt.*;

public class DrawPanel {
    JPanel drawPanel;
    public DrawPanel() {
        drawPanel = new JPanel();
        drawPanel.setBackground(Color.ORANGE);
    }

    public JPanel getDrawPanel() {
        return drawPanel;
    }
}
