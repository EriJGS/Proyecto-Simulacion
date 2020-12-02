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
    int cSalchicha;
    int cTocino;
    int cMayonesa;
    int cCebolla;
    int cTomate;
    int cLechuga;
    int cCondimentos;
    
    //Tiempos 
    int tiemposMayonesa = 0,
        tiemposTocino = 0,
        tiemposPan = 0,
        tiemposSalchicha = 0,
        tiemposCebolla = 0,
        tiemposTomate = 0,
        tiemposLechuga = 0,
        tiemposCondimentos = 0;
    int tiempoTotal = 0;
    
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
            tiempoTotal = tiemposPan+tiemposMayonesa+tiemposTocino+tiemposSalchicha+tiemposCebolla
            +tiemposTomate+tiemposLechuga+tiemposCondimentos;
            JOptionPane.showMessageDialog(null, "SE PREPARARON: "+totalDogos + " Hotdog(s) \n"
            + "\n INGREDIENTES UTILIZADOS: \n" +
            (panAcumulado ) + " Piezas de Pan" + " en " +tiemposPan+ " seg(s)\n" +
            (mayonesaAcumulada ) + " cda(s) de mayonesa"+ " en "+tiemposMayonesa+ " seg(s)\n" +
            (tocinoAcumulado ) + " Tiras de Tocino"+ " en "+tiemposTocino+ " seg(s)\n" +
            (salchichaAcumulada ) + " Salchichas"+ " en "+tiemposSalchicha+ " seg(s)\n" +
            (cebollaAcumulada ) + "/4 de Cebolla"+  " en "+tiemposCebolla+ " seg(s)\n" +
            (tomateAcumulado ) + "/4 de Tomate"+  " en "+tiemposTomate+ " seg(s)\n" +
            (lechugaAcumulada ) + "/12 de Lechuga" +  " en "+tiemposLechuga+ " seg(s)\n" +
            (condimentosAcumulados ) + " cda(s) de Aderezo"+  " en "+tiemposCondimentos+ " seg(s)\n" 
                    
            + "\n INGREDIENTES SOBRANTES: \n" +
            (cPan - panAcumulado) + " Piezas de Pan \n" +
            (cMayonesa - mayonesaAcumulada) + " cda(s) de mayonesa \n"+
            (cTocino - tocinoAcumulado)+ " Tiras de Tocino \n"+
            (cSalchicha - salchichaAcumulada) + " Salchichas \n"+
            (cCebolla - cebollaAcumulada)  + "/4 de Cebolla \n"+
            (cTomate - tomateAcumulado) + "/4 de Tomate \n"+
            (cLechuga - lechugaAcumulada) + "/12 de Lechuga \n" +
            (cCondimentos - condimentosAcumulados) + " cda(s) de Aderezo \n" +
             "\n Tiempo de la Simulacion: " + tiempoTotal + " Seg(s)"       
            );
            
            // Reinicia Tiempos
           tiemposMayonesa = tiemposTocino = tiemposPan = tiemposSalchicha = tiemposCebolla =
           tiemposTomate =  tiemposLechuga = tiemposCondimentos = tiempoTotal = 0;
           
            // Volvemos los acumuladores a su estado inicial
            panAcumulado = tocinoAcumulado = salchichaAcumulada = mayonesaAcumulada = 
            cebollaAcumulada = tomateAcumulado = lechugaAcumulada = condimentosAcumulados = 0;
            
            statusAydante = statusCocinero = false;
           
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
