package login;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->new Ventana_Login().setVisible(true));

    }

}
