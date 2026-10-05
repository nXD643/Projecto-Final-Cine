/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author nacho
 */
public class DefaultConf extends JFrame {

    private MenuUI menuBtn = new MenuUI();
    private JLabel fondoLabel = new JLabel();
    private JLabel barraDeProgreso = new JLabel();

    public DefaultConf() {
    }
    public void initConf() {
        // configuracion del propio jframe
        Color colorBackground = new Color(0,1,7);
        getContentPane().setBackground(colorBackground);
        
        setBounds(0, 0, 1920, 1080);
        setVisible(true);

        int progress = 0; // temporal, despues esto va a estar en el constructor y va a marcar el progreso

        // agregar el menu
        add(menuBtn);
        menuBtn.setBounds(1760, 10, 128, 128);
        menuBtn.setVisible(true);

        // la barra de progreso
        ImageIcon BarraDeProgreso;
        switch (progress) {
            case 1:
                BarraDeProgreso = new ImageIcon("UI/Barra.png");
            default:
                BarraDeProgreso = new ImageIcon("UI/Barra.png");
        }

        if (progress != 0) {
            add(barraDeProgreso);
            barraDeProgreso.setIcon(BarraDeProgreso);
            barraDeProgreso.setBounds(624, 900, 672, 87);
        }
    }
}