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
    JTextField inputDogos;

    int totalCocinera, totalAyudante, totalDogos;

    // Acumuladores de los ingredientes totales
    int cebollaAcumulada = 0;
    int tomateAcumulado = 0;
    int lechugaAcumulada = 0;
    int mayonesaAcumulada = 0;
    int condimentosAcumulados = 0;
    int tocinoAcumulado = 0;
    int panAcumulado = 0;
    int salchichaAcumulada = 0;
    int tiempoAcumulado = 0;
    
    // Ingredientes sobrantes
    int cPan;
    
    public void incremetarDogos() {
        int total = totalAyudante + totalCocinera;
        if (total % 2 == 0) {
            totalDogos++;
            int dogos = Integer.parseInt(inputDogos.getText());
            inputDogos.setText(Integer.toString(dogos - 1));
        }
    }

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
            lblProgreso.setVisible(false);
            return true;
        }
        return false;
    }

    // Metodo que mostrara todos los resultados al acabar la simulacion
    public void mostrarResultados() {

        if (simulacionDetenida) {
            JOptionPane.showMessageDialog(null, "SIMULACION DETENIDA");
            simulacionDetenida = false;
            lblProgreso.setVisible(false);
        } else {
            // Totales
            System.out.println("Dogos:" + totalDogos);
            System.out.println(panAcumulado);
            System.out.println(tocinoAcumulado);
            System.out.println(salchichaAcumulada);
            System.out.println(mayonesaAcumulada);
            System.out.println(cebollaAcumulada);
            System.out.println(tomateAcumulado);
            System.out.println(lechugaAcumulada);
            System.out.println(condimentosAcumulados);
            
            // Sobrantes
            System.out.println("SOBRARON");
            System.out.println("Pan: " + (cPan - panAcumulado));
            
            // Tiempos
            
            // Volvemos los acumuladores a su estado inicial
            panAcumulado = tocinoAcumulado = salchichaAcumulada = mayonesaAcumulada = 
            cebollaAcumulada = tomateAcumulado = lechugaAcumulada = condimentosAcumulados = 0;
            
            statusAydante = statusCocinero = false;
            JOptionPane.showMessageDialog(null, "RESULTADOS DE LA SIMULACION");
            totalCocinera = totalCocinera = totalDogos = 0;
            desbloquearBotonesInputs(txtIngredientes, txtTiempos);
        }
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
