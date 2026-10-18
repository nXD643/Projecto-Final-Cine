/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import javax.swing.JScrollPane;

/**
 *
 * @author nacho
 */
public class DefaultScrollPanel extends JScrollPane {
    
    public DefaultScrollPanel() {
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        
        Color colorFondo = new Color(0,0,0,128);
        Color colorBorde = new Color(158, 129, 127);
        
        this.putClientProperty("JComponent.outline", colorBorde);
        this.putClientProperty("FlatClientProperties.STYLE", "background: 0,0,0,128; arc: 200; borderWidth: 100");
    }
}
