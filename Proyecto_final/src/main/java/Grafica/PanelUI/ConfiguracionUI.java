package Grafica.PanelUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConfiguracionUI extends JButton {

    public ConfiguracionUI() {
        super();

        ImageIcon imagenFondo = new ImageIcon("UI/UserIcon.png");
        setIcon(imagenFondo);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }
    
   private void SiguienteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Configuracion ventana = new Configuracion();
        ventana.setVisible(true);
    }                                            
}