package Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import login.Imagen;

public class Admin extends JFrame {

    private JLabel jlbTexto1, jlbTexto2;
    private JTextField jtfUsuario;
    private JPasswordField jpfContraseña;
    private JButton jbtIngresar;
    private JPanel PanelPrincipal, PanelBarra;
    private Imagen im;

    private String user, password;

    public Admin() {
        setTitle("Ventana Administrador");
        setMinimumSize(new Dimension(600, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Panel();
    }

    private void Panel() {
        PanelPrincipal = new JPanel(null);
        PanelPrincipal.setBackground(Color.lightGray);
        PanelPrincipal.add(Barra());
        setContentPane(PanelPrincipal);
    }

    private JPanel Barra() {
        PanelBarra = new JPanel(null);
        PanelBarra.setBackground(Color.black);
        PanelBarra.setSize(PanelPrincipal.getMaximumSize().width, 50);
        PanelBarra.setLocation(0, 0);
        JLabel texto1 = new JLabel("Administrador");
        texto1.setSize(200, 30);
        texto1.setLocation(150, 5);
        texto1.setForeground(Color.white);
        texto1.setFont(new Font("Arial", 2, 30));
        PanelBarra.add(texto1);
        return PanelBarra;
    }

}
