package Grafica.PanelUI;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuUI extends JButton {

    public MenuUI() {
        super();
        Dimension dimensionBtn = new Dimension(128,128);
        this.setPreferredSize(dimensionBtn);
        ImageIcon imagenFondo = new ImageIcon("UI/Menu.png");
        setIcon(imagenFondo);
    }
    
   private void MenuUIBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Menu ventana = new Menu();
        ventana.setVisible(true);
    }                                            
}