package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window {

    private JTextField termField;
    private JButton goButton;
    private JTextPane textPane;
    private JFrame frame;
    private JPanel contentPane;
    private JLabel loading;
    private final String TITLE = "Thesaurus";
    private final String ERROR_SOURCE = "Error source: ";
    private final String ERROR_MESSAGE = newLine() + "Error message: ";
    private final String CONTENT_TYPE = "text/html";
    private final String FATAL_ERROR = "Fatal error";
    private final String IMAGE_PATH = "/loader.gif";
    private final int EXIT_ON_CLOSE = WindowConstants.EXIT_ON_CLOSE;

    public Window() {
        frame = new JFrame(TITLE);
        textPane.setContentType(CONTENT_TYPE);
        loading.setIcon(createLoadingIcon());
        loading.setVisible(false);
        textPane.setEditable(false);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private String newLine() {
        return System.lineSeparator();
    }

    private ImageIcon createLoadingIcon() {
        Image image = createImage();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }

    private Image createImage() {
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource(IMAGE_PATH));
        return image;
    }

    public void setButtonListener(ActionListener a) {
        goButton.addActionListener(a);
    }

    public String getTextFieldText() {
        return termField.getText();
    }

    public void showError(String searchSource, String error) {
        JOptionPane.showMessageDialog(frame,
                ERROR_SOURCE + searchSource + ERROR_MESSAGE + error + ".",
                FATAL_ERROR,
                JOptionPane.ERROR_MESSAGE);
    }

    public void setTexToJTextPane(String text) {
        textPane.setText(text);
    }

    public void startProgress() {
        loading.setVisible(true);
    }

    public void stopProgress() {
        loading.setVisible(false);
    }

    private void cleanTextPanel() {
        textPane.setText("");
    }
}
