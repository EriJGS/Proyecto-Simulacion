/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Resultados {

    public boolean statusCocinero = false, statusAydante = false;
    public JTextField[] txtIngredientes, txtTiempos;
    public Thread tCocinero, tAyudante;
    public boolean statusMensaje = false;
    
    MiBoton btnPrincipal;
    JButton btnEditT;
    JButton btnEditC;
    JButton btnResetT;
    JButton btnResetC;
    JButton btnReset;
    JButton btnGuardar;
    JButton btnStop;

    Resultados() {

    }

    public boolean terminaronAmbosThreads() {
        System.out.println(statusCocinero);
        System.out.println(statusAydante);
        if (statusCocinero && statusAydante) {
            return true;
        }
        return false;
    }

    public void mostrarResultados() {
        
        if (statusMensaje) {
            JOptionPane.showMessageDialog(null, "SIMULACION DETENIDA");
        } else {
            JOptionPane.showMessageDialog(null, "RESULTADOS DE LA SIMULACION");
        }
      
        statusMensaje = statusAydante = statusCocinero = false;
        
        desbloquearBotonesInputs(txtIngredientes, txtTiempos);
    }

    public void desbloquearBotonesInputs(JTextField[] inputsI, JTextField[] inputsC) {
        for (int i = 0; i < inputsI.length; i++) {
            inputsI[i].setBackground(Color.white);
        }
        for (int i = 0; i < inputsC.length; i++) {
            inputsC[i].setBackground(Color.white);
        }

        btnPrincipal.setEnabled(true);
        btnEditT.setEnabled(true);
        btnEditC.setEnabled(true);
        btnReset.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnStop.setEnabled(false);
    }

}
