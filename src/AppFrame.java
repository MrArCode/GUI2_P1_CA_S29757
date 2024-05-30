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
        if (actionEvent.getSource() == menu.getOpen()) {
            // Tworzymy nowy obiekt JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            String filePath = "";

            // Wyświetlamy okno dialogowe do wyboru pliku
            int result = fileChooser.showOpenDialog(null);

            // Sprawdzamy, czy użytkownik wybrał plik
            if (result == JFileChooser.APPROVE_OPTION) {
                // Pobieramy wybrany plik jako obiekt File
                File selectedFile = fileChooser.getSelectedFile();
                // Pobieramy ścieżkę do wybranego pliku
                filePath = selectedFile.getAbsolutePath();
            } else {
                System.out.println("Anulowano wybór pliku.");
                return; // Przerwij działanie metody, jeśli użytkownik anulował wybór pliku
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                drawPanel.loadPanel(drawPanel, ois);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == menu.getSave()){
            if (filePath == ""){
                // Tworzymy nowy obiekt JFileChooser
                JFileChooser fileChooser = new JFileChooser();

                // Wyświetlamy okno dialogowe do wyboru pliku
                int result = fileChooser.showSaveDialog(null);

                // Sprawdzamy, czy użytkownik wybrał plik
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Pobieramy wybrany plik jako obiekt File
                    File selectedFile = fileChooser.getSelectedFile();
                    // Pobieramy ścieżkę do wybranego pliku
                    filePath = selectedFile.getAbsolutePath();
                } else {
                    System.out.println("Anulowano wybór pliku.");
                    return; // Przerwij działanie metody, jeśli użytkownik anulował wybór pliku
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                    oos.writeObject(drawPanel);
                    toolBar.setjTextFieldRight(State.SAVED.getDisplayName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                    oos.writeObject(drawPanel);
                    toolBar.setjTextFieldRight(State.SAVED.getDisplayName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        if (actionEvent.getSource() == menu.getSaveAs()) {
            // Tworzymy nowy obiekt JFileChooser
            JFileChooser fileChooser = new JFileChooser();

            // Wyświetlamy okno dialogowe do wyboru pliku
            int result = fileChooser.showSaveDialog(null);

            // Sprawdzamy, czy użytkownik wybrał plik
            if (result == JFileChooser.APPROVE_OPTION) {
                // Pobieramy wybrany plik jako obiekt File
                File selectedFile = fileChooser.getSelectedFile();
                // Pobieramy ścieżkę do wybranego pliku
                filePath = selectedFile.getAbsolutePath();
            } else {
                System.out.println("Anulowano wybór pliku.");
                return; // Przerwij działanie metody, jeśli użytkownik anulował wybór pliku
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(drawPanel);
                System.out.println("Object saved to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
}
