import javax.swing.*;
import java.io.*;

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
            JOptionPane.showMessageDialog(null,"You did not choose a file","File is not chosen",JOptionPane.PLAIN_MESSAGE);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(appFrame.getFilePath()))) {
            appFrame.getDrawPanel().loadPanel(appFrame.getDrawPanel(), ois);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(AppFrame appFrame){
        if (appFrame.getFilePath().isEmpty()){

            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                appFrame.setFilePath(selectedFile.getAbsolutePath());
                appFrame.getAppFrame().setTitle("Simple Draw: " + selectedFile.getName());
            } else {
                JOptionPane.showMessageDialog(null,"You did not choose a file","File is not chosen",JOptionPane.PLAIN_MESSAGE);
                return;
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(appFrame.getFilePath()))) {
                oos.writeObject(appFrame.getDrawPanel());
                appFrame.getToolBar().setjTextFieldRight(State.SAVED.getDisplayName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(appFrame.getFilePath()))) {
                oos.writeObject(appFrame.getDrawPanel());
                appFrame.getToolBar().setjTextFieldRight(State.SAVED.getDisplayName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveAs(AppFrame appFrame){
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            appFrame.setFilePath(selectedFile.getAbsolutePath());
            appFrame.getAppFrame().setTitle("Simple Draw: " + selectedFile.getName());
        } else {
            JOptionPane.showMessageDialog(null,"You did not choose a file","File is not chosen",JOptionPane.PLAIN_MESSAGE);
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(appFrame.getFilePath()))) {
            oos.writeObject(appFrame.getDrawPanel());
            appFrame.getToolBar().setjTextFieldRight(State.SAVED.getDisplayName());
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
