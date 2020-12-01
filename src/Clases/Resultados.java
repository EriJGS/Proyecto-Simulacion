/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    public boolean acabaronIngredientesCocinera = false, acabaronIngredientesAyudante = false, simulacionDetenida = false;
    MiBoton btnPrincipal;
    JButton btnEditT;
    JButton btnEditC;
    JButton btnResetT;
    JButton btnResetC;
    JButton btnReset;
    JButton btnGuardar;
    JButton btnStop;
    JLabel lblProgreso;
        
    // Ambos threads se quederaon sin ingredientes
    public void ingredientesTerminados() {
        if (acabaronIngredientesCocinera && acabaronIngredientesAyudante) {
            JOptionPane.showMessageDialog(null, "Se acabaron los ingredientes");
            acabaronIngredientesAyudante = acabaronIngredientesCocinera = false;
        }   
    }
        
    // Verificara que ambos hayan acabado su chamba 
    public boolean terminaronAmbosThreads() {
        if (statusCocinero && statusAydante) {
            if (simulacionDetenida) {
                JOptionPane.showMessageDialog(null, "SIMULACION DETENIDA");
                simulacionDetenida = false;
                lblProgreso.setVisible(false);
            }
            lblProgreso.setVisible(false);
            return true;
        }
        return false;
    }
    
    // Metodo que mostrara todos los resultados al acabar la simulacion
    public void mostrarResultados() {
        statusAydante = statusCocinero = false;
        JOptionPane.showMessageDialog(null, "RESULTADOS DE LA SIMULACION");
        desbloquearBotonesInputs(txtIngredientes, txtTiempos);
    }

    // Metodo que desbloqueara todo al terminar la simulacion
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
