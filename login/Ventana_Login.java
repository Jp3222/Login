package login;

import Ventanas.Admin;
import Ventanas.Empleado;
import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana_Login extends JFrame implements KeyListener {

    private JLabel jlbTexto1, jlbTexto2;
    private JTextField jtfUsuario;
    private JPasswordField jpfContraseña;
    private JButton jbtIngresar;
    private JPanel PanelPrincipal, PanelBarra;
    private Imagen im;

    private String user, password;

    public Ventana_Login() {
        setTitle("Login");
        setMinimumSize(new Dimension(400, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        inComponents();
        Panel();
    }

    private void inComponents() {
        Font F = new Font("Arial", 1, 14);
        jlbTexto1 = new JLabel("Ingresa el Usuario:");
        jlbTexto1.setBounds(20, 300, 160, 25);
        jlbTexto1.setFont(F);
        jlbTexto2 = new JLabel("Ingresa la contraseña:");
        jlbTexto2.setBounds(20, 350, 160, 25);
        jlbTexto2.setFont(F);
        jtfUsuario = new JTextField();
        jtfUsuario.setBounds(180, 300, 150, 25);
        jpfContraseña = new JPasswordField();
        jpfContraseña.setBounds(180, 350, 150, 25);
        im = new Imagen(((getSize().width / 2) - 50), 100, 100, 100);
        jbtIngresar = new JButton("Ingresar");
        jbtIngresar.setBounds((getSize().width / 2) - 75, 420, 150, 30);

    }

    private void Panel() {
        PanelPrincipal = new JPanel(null);
        PanelPrincipal.setBackground(Color.lightGray);
        PanelPrincipal.add(Barra());
        PanelPrincipal.add(jlbTexto1);
        PanelPrincipal.add(jlbTexto2);
        PanelPrincipal.add(jtfUsuario);
        PanelPrincipal.add(jpfContraseña);
        PanelPrincipal.add(jbtIngresar);
        PanelPrincipal.add(im);
        jbtIngresar.addActionListener((e) -> ingresar());
        jtfUsuario.addKeyListener(this);
        jpfContraseña.addKeyListener(this);
        setContentPane(PanelPrincipal);
    }

    private JPanel Barra() {
        PanelBarra = new JPanel(null);
        PanelBarra.setBackground(Color.black);
        PanelBarra.setSize(PanelPrincipal.getMaximumSize().width, 50);
        PanelBarra.setLocation(0, 0);
        JLabel texto1 = new JLabel("Inicio");
        texto1.setSize(100, 30);
        texto1.setLocation(150, 5);
        texto1.setForeground(Color.white);
        texto1.setFont(new Font("Arial", 2, 30));
        PanelBarra.add(texto1);
        return PanelBarra;
    }

    @SuppressWarnings("deprecation")
    public void ingresar() {
        user = jtfUsuario.getText();
        password = jpfContraseña.getText();
        if (!user.equals("") && !password.equals("")) {
            try {
                //query para usuario
                String query = "select cargo from empleados where usuario = '" + user
                        + "' and pass = '" + password + "'";
                //busqueda
                PreparedStatement pst = BD.getConexion().prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String cargo = rs.getString("cargo");
                    if (cargo.equalsIgnoreCase("Admin")) {
                        System.out.println("Es admin");
                        new Admin().setVisible(true);
                        dispose();
                    } else if (cargo.equalsIgnoreCase("Empleado")) {
                        new Empleado().setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Datos no encontrados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }
    }

    public String contraseña() {
        char[] a = jpfContraseña.getPassword();
        String c = "";
        for (int i = 0; i < a.length; i++) {
            c += a[i];
        }
        return c;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            ingresar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
