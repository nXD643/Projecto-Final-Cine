/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.UIManager;

/**
 *
 * @author nacho
 */
public class DefaultComboBox extends JComboBox {
    int fuenteTamanio = 14;
    int fuenteTipo = Font.BOLD;
    String fuente = "Arial";
    Color colorBackground = new Color(0, 1, 7); 
    Color colorFont = new Color(158, 129, 127);
    
    public DefaultComboBox() {
        this.setBackground(colorBackground);
        
        this.setForeground(colorFont);
        
        Font textFont = new Font(fuente, fuenteTipo, fuenteTamanio);
        this.setFont(textFont);
        
        this.putClientProperty("JComponent.roundRect", true); 
        this.putClientProperty("JComponent.outline", colorFont);
    }
}
