package Grafica.PanelUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author nacho
 */
public class DefaultBtn extends JButton {
    
    public DefaultBtn(int letraTamanio) {
        super();
        
        int fuenteTamanio;
        int tipo = Font.BOLD;
        String fuente;
        
        switch (letraTamanio) {
            case 1:
                fuente = "Sim Sun";
                fuenteTamanio = 12;
                break;
            case 2:
                fuente = "Verdana";
                fuenteTamanio = 32;
                break;
            case 3:
                fuente = "SegoreUI";
                fuenteTamanio = 64;
                break;
            default:
                throw new IllegalArgumentException("Tamanio de letra no valido: " + letraTamanio);
        }
        
        Color colorBtn = new Color(0, 1, 7); // 118,94,87
        this.setBackground(colorBtn);
        this.setBorderPainted(true);
        
        Color colorBtnFont = new Color(158, 129, 127); // 143, 103, 122
        this.setForeground(colorBtnFont);
        
        Font textFont = new Font(fuente, tipo, fuenteTamanio);
        this.setFont(textFont);
        
        this.putClientProperty("JButton.buttonType", "roundRect"); 
        this.putClientProperty("JComponent.outline", colorBtnFont);
    }
}