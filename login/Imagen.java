package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Imagen extends JPanel {

    public Imagen(int x, int y, int Altura, int Anchura) {
        setSize(Anchura, Altura);
        setLocation(x, y);
        setBackground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.fillRect(0, 0, getMaximumSize().width, getMaximumSize().height);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", 1, 50));
        g.drawString("?", (getSize().width / 2) - (getFont().getSize()), getSize().height / 2);
    }

}
