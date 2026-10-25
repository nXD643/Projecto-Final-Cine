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
public class AsientoUI extends JToggleButton {

    boolean seleccionado = false;
    Asiento asiento;
    
    public AsientoUI(Asiento asiento) {
        this.asiento = asiento;
        this.addActionListener(e -> AsientoUIActionPerformed(e));
        
        if (asiento.isEstado()) {
            ImageIcon icono = new ImageIcon("UI/AsientoGris.png");
            System.out.println(icono.toString());
            this.setIcon(icono);
        } else {
            ImageIcon icono = new ImageIcon("UI/AsientoRojo.png");
            System.out.println(icono.toString());
            this.setIcon(icono);
        }
        setBounds(asiento.getNumero() * 150, asiento.getFila() * 150, 128, 128);
    }
    private void AsientoUIActionPerformed(java.awt.event.ActionEvent evt) {
        if (asiento.isEstado()){
            if (seleccionado) {
                seleccionado = false;
                ImageIcon icono = new ImageIcon("UI/AsientoGris.png");
                this.setIcon(icono);
            } else{
                seleccionado = true;
                ImageIcon icono = new ImageIcon("UI/AsientoVerde.png");
                this.setIcon(icono);
            }
        }
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    public Asiento getAsiento() {
        return asiento;
    }
}
