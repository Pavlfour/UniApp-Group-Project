package uniapp.main;

import java.io.IOException;
import uniapp.gui.mainFrame;

public class Main {

    public static void main(String[] args) throws IOException {

        // Create and show the mainFrame window
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.getInstance().setVisible(true);

        });
    }
}
