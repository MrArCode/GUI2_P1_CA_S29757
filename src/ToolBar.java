import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ToolBar implements Serializable {
    JToolBar toolBar;
    JLabel jTextFieldLeft;
    JLabel jTextFieldRight;

    public ToolBar() {
        toolBar = new JToolBar();
        toolBar.setLayout(new BorderLayout());
        jTextFieldLeft = new JLabel();
        jTextFieldRight = new JLabel();
        toolBar.add(jTextFieldLeft, BorderLayout.WEST);
        toolBar.add(jTextFieldRight, BorderLayout.EAST);
        jTextFieldRight.setText(State.NEW.getDisplayName());
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public JLabel getjTextFieldLeft() {
        return jTextFieldLeft;
    }

    public void setjTextFieldLeft(String text) {
        this.jTextFieldLeft.setText(text);
    }

    public JLabel getjTextFieldRight() {
        return jTextFieldRight;
    }

    public void setjTextFieldRight(String text) {
        this.jTextFieldRight.setText(text);
    }
}
