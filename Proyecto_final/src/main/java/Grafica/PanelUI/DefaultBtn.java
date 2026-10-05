/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author nacho
 */
public class DefaultBtn extends JButton {
    
    public DefaultBtn() {
        super();
        Color colorBtn = new Color(0,1,7); // 118,94,87
        this.setBackground(colorBtn);
        
        this.setBorderPainted(true);
        
        Color colorBtnFont = new Color(143,103,122); // 255,240,176
        this.setForeground(colorBtnFont);
        
        java.awt.Font textFont = new java.awt.Font("Verdana", 0, 64);
        this.setFont(textFont);

        this.putClientProperty("JButton.buttonType", "roundRect"); 
        this.putClientProperty("JComponent.outline", colorBtnFont);
        putClientProperty("FlatClientProperties.STYLE", "borderWidth: 100; arc: 20");

    }
}