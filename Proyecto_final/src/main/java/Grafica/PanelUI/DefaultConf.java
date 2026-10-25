/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafica.PanelUI;

import Logica.Fachada;
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
    private JLabel fondoDifuminado = new JLabel();
    private JLabel barraDeProgreso = new JLabel();
    private boolean estadoMenu = false;
    private Menu menuVentana = new Menu();
    private Fachada fachada = Fachada.getInstancia();

    public DefaultConf() {
    }
    public void add_background() {
        // fondo
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("UI/BackgroundInicio.png"));
        fondo.setBounds(0, 0, 1920, 1080);
        this.add(fondo);
   
        setBounds(0, 0, 1920, 1080);
        setVisible(true);
    }
    
    public void initConf() {
        // configuracion del propio jframe
        
        Color colorBackground = new Color(0,1,7);
        getContentPane().setBackground(colorBackground);
        
        int progress = 0; // temporal, despues esto va a estar en el constructor y va a marcar el progreso
        
        if (fachada.isEstaIniciado()) {
            menuVentana.setMenu();
            // agregar el menu
            add(menuVentana);
            menuVentana.setBounds(150, 150, 1620, 780);
            menuVentana.setVisible(false);
            // boton del menu
            menuBtn.setBounds(1760, 10, 128, 128);
            menuBtn.setVisible(true);
            menuBtn.addActionListener(e -> menuBtnActionPerformed(e));

            add(menuBtn);
        }

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
    
    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (!estadoMenu) {
            menuVentana.setVisible(true);
            estadoMenu = true;
            fondoDifuminado.setVisible(true);
    } else {
            menuVentana.setVisible(false);
            estadoMenu = false;
            fondoDifuminado.setVisible(false);
        }
    }
}