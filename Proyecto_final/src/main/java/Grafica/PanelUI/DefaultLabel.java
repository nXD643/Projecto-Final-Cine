/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author nacho
 */
public class DefaultLabel extends JLabel {
    
    public DefaultLabel() {
        super();
        // color de la fuente
        Color colorBtnFont = new Color(143,103,122);
        this.setForeground(colorBtnFont);
        // fuente y tamano
        java.awt.Font textFont = new java.awt.Font("Arial Black", 0, 64);
        this.setFont(textFont);
    }
}