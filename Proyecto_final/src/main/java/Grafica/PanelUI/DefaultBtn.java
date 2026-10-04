/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
        
        Color colorBtnFont = new Color(255,255,255); // 255,240,176
        this.setForeground(colorBtnFont);
        
        java.awt.Font textFont = new java.awt.Font("Verdana", 0, 12);
        this.setFont(textFont);
        
        ImageIcon fondo = new ImageIcon("UI/Menu.png");
        this.putClientProperty("JButton.buttonType", "roundRect"); 
        this.putClientProperty("JComponent.outline", new java.awt.Color(0,0,0,0));
    }
}