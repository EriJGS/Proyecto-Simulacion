package Clases;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiBoton extends JButton implements ActionListener {

    public MiMonito monito, monito2;
    private String name;
    JTextField[] txtIngredientes, txtTiempos;
    Resultados resultados;
    
    /* Botones */
    MiBoton btnPrincipal;
    JButton btnEditT = new JButton("");
    JButton btnEditC = new JButton("");
    JButton btnResetT = new JButton("");
    JButton btnResetC = new JButton("");
    JButton btnReset = new JButton("");
    JButton btnGuardar = new JButton("");
    JButton btnStop = new JButton("");

    MiBoton(String texto) {
        this.name = texto;
    }

    void innit() {
        this.setText(name);
        System.out.println("Init");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().toString() == "Detener") {

        }
        if (e.getSource().toString() == "Comenzar") {
            this.name = "Iniciar";

        } else {
            System.out.println("Hey soy el Ancton Event del thread");
            // Solo validamos que haya ingredientes disponibles
            if (verificarCantidades()) {
          
                Thread t = new Thread(monito, name);
                Thread t2 = new Thread(monito2, name);
                
                t.start();
                t2.start();
                
                bloquear(txtIngredientes, txtTiempos);
            } else {
                JOptionPane.showMessageDialog(null, "Verifique la cantidad de ingredientes porfavor");
            }
        }
    }

    private boolean verificarCantidades() {
        JTextField inputCebolla = txtIngredientes[0];
        JTextField inputTomate = txtIngredientes[1];
        JTextField inputLechuga = txtIngredientes[2];
        JTextField inputMayonesa = txtIngredientes[3];
        JTextField inputCondimentos = txtIngredientes[4];
        JTextField inputTocino = txtIngredientes[5];
        JTextField inputPan = txtIngredientes[6];
        JTextField inputSalchicha = txtIngredientes[7];
        JTextField inputHotDogs = txtIngredientes[8];

        // Cantidades
        int cebolla = Integer.parseInt(inputCebolla.getText());
        int tomate = Integer.parseInt(inputTomate.getText());
        int lechuga = Integer.parseInt(inputLechuga.getText());
        int mayonesa = Integer.parseInt(inputMayonesa.getText());
        int condimentos = Integer.parseInt(inputCondimentos.getText());
        int tocino = Integer.parseInt(inputTocino.getText());
        int pan = Integer.parseInt(inputPan.getText());
        int salchicha = Integer.parseInt(inputSalchicha.getText());
        int hotdogs = Integer.parseInt(inputHotDogs.getText());

        if (cebolla >= 1 && tomate >= 1 && lechuga >= 1 && mayonesa >= 1 && condimentos >= 1 && tocino >= 1 && pan >= 1 && salchicha >= 1 && hotdogs >= 1) {
            return true;
        } else {
            return false;
        }
    }
    
    
    // Metodos para bloquar
    public void bloquear(JTextField[] inputsI, JTextField[] inputsC) {
        for (int i = 0; i < inputsI.length; i++) {
            inputsI[i].setEnabled(false);
            inputsI[i].setBackground(Color.white);
        }
        for (int i = 0; i < inputsC.length; i++) {
            inputsC[i].setEnabled(false);
            inputsC[i].setBackground(Color.white);
        }
        btnPrincipal.setEnabled(false);
        btnEditT.setEnabled(false);
        btnEditC.setEnabled(false);
        btnResetT.setEnabled(false);
        btnResetC.setEnabled(false);
        btnReset.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnStop.setEnabled(true);
    }
    
}
