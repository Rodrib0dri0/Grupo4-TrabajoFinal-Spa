
package Principal;

import javax.swing.JInternalFrame;

public class JInternalFrameImagen extends JInternalFrame{
    protected String path;
    private final JPanelImagen jPanelImagen;
    public JInternalFrameImagen() {
        this.path = "";
        jPanelImagen = new JPanelImagen(path);
        setContentPane(jPanelImagen);
    }
    public void SetImagen(String path){
    jPanelImagen.SetImage(path);
}
}
