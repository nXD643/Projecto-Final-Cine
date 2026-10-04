package Grafica.PanelUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuUI extends JButton {

    public MenuUI() {
        super();

        ImageIcon imagenFondo = new ImageIcon("UI/Menu.png");
        setIcon(imagenFondo);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }
    
   private void MenuUIBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Menu ventana = new Menu();
        ventana.setVisible(true);
    }                                            
}