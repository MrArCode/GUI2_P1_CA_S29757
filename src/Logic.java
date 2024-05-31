import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Logic {
    public static void open(AppFrame appFrame){
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            appFrame.setFilePath(selectedFile.getAbsolutePath());
            appFrame.getToolBar().setjTextFieldLeft("");
            appFrame.getToolBar().setjTextFieldRight(State.NEW.getDisplayName());
            appFrame.getAppFrame().setTitle("Simple Draw: " + selectedFile.getName());
        } else {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(appFrame.getFilePath()))) {
            appFrame.getDrawPanel().loadPanel(appFrame.getDrawPanel(), ois);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quit(){
        System.exit(0);
    }

    public static void   circle(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.CIRCLE);
    }

    public static void  square(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.SQUARE);
    }

    public static void  line(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.LINE);
    }
}
