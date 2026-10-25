/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import Logica.Asiento;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author nacho
 */
public class AsientoUI extends JToggleButton{

    public AsientoUI(Asiento asiento) {
        System.out.println(asiento.isEstado());
        if (asiento.isEstado()) {
            ImageIcon icono = new ImageIcon("UI/AsientoVerde.png");
            System.out.println(icono.toString());
            this.setIcon(icono);
        } else {
            ImageIcon icono = new ImageIcon("UI/AsientoRojo.png");
            System.out.println(icono.toString());
            this.setIcon(icono);
        }
        setBounds(asiento.getNumero() * 150, asiento.getFila() * 150, 128, 128);
    }
}
