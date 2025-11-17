package Principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelImagen extends JPanel {

    private Image imagen = null;

    public JPanelImagen(String ruta) {
        SetImage(ruta);
    }

    public void SetImage(String ruta) {
        if (!ruta.equals("")) {
            imagen = new ImageIcon(getClass().getResource(ruta))
                    .getImage();
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        this.setOpaque(false);
        super.paint(g);
    }

}
