import javax.swing.*;
import java.awt.*;
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
            appFrame.getMenu().getButtonGroup().clearSelection();
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

    public static void quit(AppFrame appFrame){
        if (appFrame.getFilePath().isEmpty()){
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit without saving?", "Save your progress", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) System.exit(0);

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
                System.exit(0);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to exit without saving?", "Save your progress", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                System.exit(0);
            }else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(appFrame.getFilePath()))) {
                    oos.writeObject(appFrame.getDrawPanel());
                    appFrame.getToolBar().setjTextFieldRight(State.SAVED.getDisplayName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }

    public static void   circle(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.CIRCLE);
    }

    public static void  square(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.SQUARE);
    }

    public static void  line(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.LINE);
        drawPanel.setColorOfPen(Color.BLACK);
    }
}
