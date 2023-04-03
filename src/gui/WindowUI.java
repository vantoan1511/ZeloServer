package gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WindowUI extends UIManager {

    public static void setWindowsUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Set windows UI failed");
        }
    }
}
