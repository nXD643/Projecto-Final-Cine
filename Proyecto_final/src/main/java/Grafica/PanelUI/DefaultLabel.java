/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author nacho
 */
public class DefaultLabel extends JLabel {
    
    public DefaultLabel(int letraTamanio) {
        super();
        int fuenteTamanio;
        int fuenteTipo = Font.BOLD;
        String fuente;
        
        switch (letraTamanio) {
            case 1:
                fuente = "Verdana";
                fuenteTamanio = 12;
                break;
            case 2:
                fuente = "SegoreUI";
                fuenteTamanio = 32;
                break;
            case 3:
                fuente = "Arial Black";
                fuenteTamanio = 64;
                break;
            default:
                throw new IllegalArgumentException("Tamanio de letra no valido: " + letraTamanio);
        }
        
        // color de la fuente 143,103,122
        Color colorBtnFont = new Color(158, 129, 127);
        this.setForeground(colorBtnFont);
        // fuente y tamano
        java.awt.Font textFont = new java.awt.Font(fuente, fuenteTipo, fuenteTamanio);
        this.setFont(textFont);
    }
}