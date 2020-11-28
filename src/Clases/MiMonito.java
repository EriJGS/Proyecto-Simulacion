package Clases;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiMonito extends JLabel implements Runnable {

    public boolean stop;
    private String name, url;
    private ImageIcon imagenIcon;
    JTextField[] txtIngredientes, txtTiempos;
    JLabel lblProgreso;
    // Botones de MyPanel para desactivar/activar
    MiBoton btnPrincipal;
    JButton btnEditT = new JButton("");
    JButton btnEditC = new JButton("");
    JButton btnResetT = new JButton("");
    JButton btnResetC = new JButton("");
    JButton btnReset = new JButton("");
    JButton btnGuardar = new JButton("");
    JButton btnStop = new JButton("");

    public MiMonito(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void innit() {
        URL resource = this.getClass().getResource(url);
        if (resource != null) {
            imagenIcon = new ImageIcon(new ImageIcon(resource).getImage().getScaledInstance(40, 40, Image.SCALE_FAST));
            this.setIcon(imagenIcon);
        } else {
            System.out.println("URL vacia");
        }
    }

    @Override
    public void run() {
        //lblProgreso.setVisible(true);
        chambaAnimacion();
    }

    // Método sincronizado para stop
    public synchronized void stopHilo() { stop = true; }

    // Todo el rollo de la animacion
    private void chambaAnimacion() {
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

        int cebollaAcumulada = 0;
        int tomateAcumulado = 0;
        int lechugaAcumulada = 0;
        int mayonesaAcumulada = 0;
        int condimentosAcumulados = 0;
        int tocinoAcumulado = 0;
        int panAcumulado = 0;
        int salchichaAcumulada = 0;
        int tiempoAcumulado = 0;

        // Contenedores de cantidades
        Contenedores cCebolla = new Contenedores("Contenedor Cebolla");
        cCebolla.setCantidad(cebolla);
        Contenedores cTomate = new Contenedores("Contenedor Tomate");
        cTomate.setCantidad(tomate);
        Contenedores cLechuga = new Contenedores("Contenedor Lechuga");
        cLechuga.setCantidad(lechuga);
        Contenedores cMayonesa = new Contenedores("Contenedor Mayonesa");
        cMayonesa.setCantidad(mayonesa);
        Contenedores cCondimentos = new Contenedores("Contenedor Condimentos");
        cCondimentos.setCantidad(condimentos);
        Contenedores cTocino = new Contenedores("Contenedor Tocino");
        cTocino.setCantidad(tocino);
        Contenedores cPan = new Contenedores("Contenedor Pan");
        cPan.setCantidad(pan);
        Contenedores cSalchicha = new Contenedores("Contenedor Salchicha");
        cSalchicha.setCantidad(salchicha);
        Contenedores cHotDogs = new Contenedores("Contenedor HotDogs");
        cHotDogs.setCantidad(hotdogs);

        // Acumuladores de cantidades
        Acumuladores aCebolla = new Acumuladores("Acumulador Cebolla");
        aCebolla.setCantidadAcumulada(cebollaAcumulada);
        Acumuladores aTomate = new Acumuladores("Acumulador Tomate");
        aTomate.setCantidadAcumulada(tomateAcumulado);
        Acumuladores aLechuga = new Acumuladores("Acumulador Lechuga");
        aLechuga.setCantidadAcumulada(lechugaAcumulada);
        Acumuladores aMayonesa = new Acumuladores("Acumulador Mayonesa");
        aMayonesa.setCantidadAcumulada(mayonesaAcumulada);
        Acumuladores aCondimento = new Acumuladores("Acumulador Condimento");
        aCondimento.setCantidadAcumulada(condimentosAcumulados);
        Acumuladores aTocino = new Acumuladores("Acumulador Tocino");
        aTocino.setCantidadAcumulada(tocinoAcumulado);
        Acumuladores aPan = new Acumuladores("Acumulador Pan");
        aPan.setCantidadAcumulada(panAcumulado);
        Acumuladores aSalchicha = new Acumuladores("Acumulador Salchicha");
        aSalchicha.setCantidadAcumulada(salchichaAcumulada);

        Acumuladores aTiempo = new Acumuladores("Acumulador tiempo");
        aTiempo.setCantidadAcumulada(tiempoAcumulado);

        int ciclos = hotdogs;
        int dogosPreparados = 0;
        int x = 85;
        int TIEMPO = 1000;
        stop = false;

        // Tiempos de tareas
        int tPicarTomate = (int) (Double.parseDouble(txtTiempos[0].getText()) * TIEMPO);
        int tPicarCebolla = (int) (Double.parseDouble(txtTiempos[1].getText()) * TIEMPO);
        int tPicarLechuga = (int) (Double.parseDouble(txtTiempos[2].getText()) * TIEMPO);
        int tAplicarTomate = (int) (Double.parseDouble(txtTiempos[3].getText()) * TIEMPO);
        int tAplicarCebolla = (int) (Double.parseDouble(txtTiempos[4].getText()) * TIEMPO);
        int tAplicarLechuga = (int) (Double.parseDouble(txtTiempos[5].getText()) * TIEMPO);
        int tAplicarMayonesa = (int) (Double.parseDouble(txtTiempos[6].getText()) * TIEMPO);
        int tAplicarCondimentos = (int) (Double.parseDouble(txtTiempos[7].getText()) * TIEMPO);
        int tAplicarTocino = (int) (Double.parseDouble(txtTiempos[8].getText()) * TIEMPO);
        int tPrepararPan = (int) (Double.parseDouble(txtTiempos[9].getText()) * TIEMPO);
        int tAplicarPan = (int) (Double.parseDouble(txtTiempos[10].getText()) * TIEMPO);
        int tPrepararSalchicha = (int) (Double.parseDouble(txtTiempos[11].getText()) * TIEMPO);
        int tAplicarSalchicha = (int) (Double.parseDouble(txtTiempos[12].getText()) * TIEMPO);

        // Tiempos acumulados
        int tiempoTotal = 0, tiemposTomate = 0, tiemposCebolla = 0, tiemposLechuga = 0, tiemposMayonesa = 0, tiemposCondimentos = 0 , tiemposTocino = 0, tiemposPan =0, tiemposSalchicha = 0;

        System.out.println(tPicarTomate);

        for (int i = 1; i <= ciclos; i++) {

            // Por cada ciclo va quitando cada ingrediente usado
            cebolla = cebolla - 1;
            tomate = tomate - 1;
            lechuga = lechuga - 1;
            mayonesa = mayonesa - 1;
            condimentos = condimentos - 1;
            tocino = tocino - 1;
            pan = pan - 1;
            salchicha = salchicha - 1;

            //Por cada ciclo va añadiendo cada ingrediente usado
            cebollaAcumulada++;
            tomateAcumulado++;
            lechugaAcumulada++;
            mayonesaAcumulada++;
            condimentosAcumulados++;
            tocinoAcumulado++;
            panAcumulado++;
            salchichaAcumulada++;
            
                        
            if (cebolla >= 0 && tomate >= 0 && lechuga >= 0 && mayonesa >= 0 && condimentos >= 0 && tocino >= 0 && pan >= 0 && salchicha >= 0 &&
                tPicarTomate > 0 && tPicarCebolla > 0 && tPicarLechuga > 0 && tAplicarTomate > 0 && tAplicarCebolla > 0 && tAplicarLechuga > 0 && tAplicarMayonesa > 0 &&
                tAplicarCondimentos > 0 && tAplicarTocino > 0 && tPrepararPan > 0 && tAplicarPan > 0 && tPrepararSalchicha > 0 && tAplicarSalchicha > 0) {
                
                System.out.println("Entraste a la simulacion");
                
                // Tareas a realizar de la cocinera   
                if (name == "cocinera") {
             
                    cPan.setCantidad(cPan.getCantidad() - 1);
                    try { Thread.sleep(tPrepararPan); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    this.setBounds(140, 40, 80, 40);

                    try { Thread.sleep(tAplicarPan); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputPan.setText("" + cPan.getCantidad());
                    this.setBounds(200, 40, 80, 40);

                    cMayonesa.setCantidad(cMayonesa.getCantidad() - 1);
                    try { Thread.sleep(tAplicarMayonesa); } catch (Exception e) {}
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputMayonesa.setText("" + cMayonesa.getCantidad());
                    this.setBounds(255, 40, 80, 40);

                    try { Thread.sleep(tPrepararSalchicha); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    this.setBounds(305, 40, 80, 40);

                    cTocino.setCantidad(cTocino.getCantidad() - 1);
                    try { Thread.sleep(tAplicarTocino); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputTocino.setText("" + cTocino.getCantidad());
                    this.setBounds(370, 40, 80, 40);

                    cSalchicha.setCantidad(cSalchicha.getCantidad() - 1);
                    try { Thread.sleep(tAplicarSalchicha); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputSalchicha.setText("" + cSalchicha.getCantidad());
                    this.setBounds(85, 40, 80, 40);
               
                }
                // Fin de las tareas de la cocinera
                
                // Tareas a realizar del ayudante
                if(name == "ayudante") {
//                    System.out.println("Entro el ayudante");
                    
                    this.setBounds(425, 40, 80, 40);

                    cCebolla.setCantidad(cCebolla.getCantidad() - 1);
                    try { Thread.sleep(tPicarCebolla); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    try { Thread.sleep(tAplicarCebolla); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputCebolla.setText("" + cCebolla.getCantidad());
                    this.setBounds(480, 40, 80, 40);

                    cTomate.setCantidad(cTomate.getCantidad() - 1);
                    try { Thread.sleep(tPicarTomate); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    try { Thread.sleep(tAplicarTomate); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputTomate.setText("" + cTomate.getCantidad());
                    this.setBounds(535, 40, 80, 40);

                    cLechuga.setCantidad(cLechuga.getCantidad() - 1);
                    try { Thread.sleep(tPicarLechuga); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    try { Thread.sleep(tAplicarLechuga); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputLechuga.setText("" + cLechuga.getCantidad());
                    this.setBounds(590, 40, 80, 40);

                    cCondimentos.setCantidad(cCondimentos.getCantidad() - 1);
                    try { Thread.sleep(tAplicarCondimentos); } catch (Exception e) { }
                    try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                    inputCondimentos.setText("" + cCondimentos.getCantidad());
                    this.setBounds(485, 40, 80, 40);

                }
                // Fin de las tareas a realizar del ayudante
            
            } else {
               JOptionPane.showMessageDialog(null, "Las cantidades no pueden ser cero");
            }
            
            
         // Las cantidades deben ser cero para que el ciclo se detenga cuando queden 0 ingredientes
            /*if (cebolla >= 0 && tomate >= 0 && lechuga >= 0 && mayonesa >= 0 && condimentos >= 0 && tocino >= 0 && pan >= 0 && salchicha >= 0 &&
                tPicarTomate > 0 && tPicarCebolla > 0 && tPicarLechuga > 0 && tAplicarTomate > 0 && tAplicarCebolla > 0 && tAplicarLechuga > 0 && tAplicarMayonesa > 0 &&
                tAplicarCondimentos > 0 && tAplicarTocino > 0 && tPrepararPan > 0 && tAplicarPan > 0 && tPrepararSalchicha > 0 && tAplicarSalchicha > 0) {
                //System.out.println("Estas dentro de la simulacion");

                cPan.setCantidad(cPan.getCantidad() - 1);
                // Tiempos del pan
                try { Thread.sleep(tPrepararPan); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                this.setBounds(140, 40, 80, 40);

                try { Thread.sleep(tAplicarPan); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputPan.setText("" + cPan.getCantidad());
              //  x += 60;
                this.setBounds(200, 40, 80, 40);

                cMayonesa.setCantidad(cMayonesa.getCantidad() - 1);
                try { Thread.sleep(tAplicarMayonesa); } catch (Exception e) {}
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputMayonesa.setText("" + cMayonesa.getCantidad());
               // x += 60;
                this.setBounds(255, 40, 80, 40);

                try { Thread.sleep(tPrepararSalchicha); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                this.setBounds(305, 40, 80, 40);

                cTocino.setCantidad(cTocino.getCantidad() - 1);
                try { Thread.sleep(tAplicarTocino); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputTocino.setText("" + cTocino.getCantidad());
             //   x += 60;
                this.setBounds(370, 40, 80, 40);

                cSalchicha.setCantidad(cSalchicha.getCantidad() - 1);
                // Tiempo de la salchicha
                try { Thread.sleep(tAplicarSalchicha); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputSalchicha.setText("" + cSalchicha.getCantidad());
               // x += 60;
                this.setBounds(425, 40, 80, 40);

                cCebolla.setCantidad(cCebolla.getCantidad() - 1);
                // Tiempos de cebolla
                try { Thread.sleep(tPicarCebolla); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                try { Thread.sleep(tAplicarCebolla); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputCebolla.setText("" + cCebolla.getCantidad());
              //  x += 60;
                this.setBounds(480, 40, 80, 40);

                cTomate.setCantidad(cTomate.getCantidad() - 1);
                try { Thread.sleep(tPicarTomate); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                try { Thread.sleep(tAplicarTomate); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputTomate.setText("" + cTomate.getCantidad());
              //  x += 60;
                this.setBounds(535, 40, 80, 40);

                cLechuga.setCantidad(cLechuga.getCantidad() - 1);
                // Tiempos de la lechuga
                try { Thread.sleep(tPicarLechuga); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                try { Thread.sleep(tAplicarLechuga); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputLechuga.setText("" + cLechuga.getCantidad());
              //  x += 60;
                this.setBounds(590, 40, 80, 40);

                cCondimentos.setCantidad(cCondimentos.getCantidad() - 1);
                try { Thread.sleep(tAplicarCondimentos); } catch (Exception e) { }
                try { synchronized(this) { if(stop) { break; } } } catch(Exception e) {}
                inputCondimentos.setText("" + cCondimentos.getCantidad());
                this.setBounds(85, 40, 80, 40);

                cHotDogs.setCantidad(cHotDogs.getCantidad() - 1);
                inputHotDogs.setText("" + cHotDogs.getCantidad());
                dogosPreparados++;
                //System.out.println("HotDogs preparados: " + i + "\n Cantidad de cebolla que queda: " + cebolla);
                // System.out.println("cebolla usada: " + cebollaAcumulada);

                // Acumulacion de tiempos totales
                tiempoTotal += (tPicarTomate + tPicarCebolla + tPicarLechuga + tAplicarTomate + tAplicarCebolla + tAplicarLechuga + tAplicarMayonesa + tAplicarCondimentos + tAplicarTocino
                                + tPrepararPan + tAplicarPan + tPrepararSalchicha + tAplicarSalchicha) / 1000;
                tiemposTomate += (tPicarTomate + tPicarTomate) / 1000;
                tiemposCebolla += (tPicarCebolla + tAplicarCebolla) / 1000;
                tiemposLechuga += (tPicarLechuga + tAplicarCebolla) / 1000;
                tiemposCondimentos += tAplicarCondimentos / 1000;
                tiemposMayonesa += tAplicarMayonesa / 1000;
                tiemposTocino += tAplicarTocino / 1000;
                tiemposPan += (tPrepararPan + tAplicarPan) / 1000;
                tiemposSalchicha += (tPrepararSalchicha + tAplicarSalchicha) / 1000;

            } else {
                System.out.println("Faltan ingredientes");
                JOptionPane.showMessageDialog(null, "\n FALTAN INGREDIENTES. \n" +
                        "\n Faltaron de preparar " + (hotdogs - (i -1))+ " HotDog(s)");

                //Se añadio el break para cancelar el ciclo for
                break;
            }*/

        }
        
//        if (name == "ayudante") {
//           this.setBounds(30, 40, 80, 40);
//        }

        // Solo quitamos el lbl ya que acabe las iteraciones
        //lblProgreso.setVisible(false);

/*        if ( dogosPreparados == hotdogs) { //Ingredientes y Pedidos IGUALES && Ingredientes son mayores
            JOptionPane.showMessageDialog(null," \n SE PREPARARON " + dogosPreparados + " HOTDOG(S) \n" +
             "\n QUEDARON LOS SIGUIENTES INGREDIENTES : \n" +
            (pan ) + " Piezas de Pan \n" +
            (mayonesa) + " cda(s) de mayonesa \n"+
            (tocino) + " Tiras de Tocino \n"+
            (salchicha) + " Salchichas \n"+
            (cebolla ) + "/4 de Cebolla \n"+
            (tomate ) + "/4 de Tomate \n"+
            (lechuga ) + "/12 de Lechuga \n" +
            (condimentos ) + " cda(s) de Aderezo \n" +

            "\n INGREDIENTES QUE SE UTILIZARON Y TIEMPOS DE LAS TAREAS: \n" +
            (panAcumulado ) + " Piezas de Pan (" + tiemposPan + " seg)\n" +
            (mayonesaAcumulada ) + " cda(s) de mayonesa (" + tiemposMayonesa + " seg) \n"+
            (tocinoAcumulado ) + " Tiras de Tocino (" + tiemposTocino + " seg) \n"+
            (salchichaAcumulada ) + " Salchichas (" + tiemposSalchicha + " seg) \n"+
            (cebollaAcumulada ) + "/4 de Cebolla (" + tiemposCebolla + " seg) \n"+
            (tomateAcumulado ) + "/4 de Tomate (" + tiemposTomate + " seg) \n"+
            (lechugaAcumulada ) + "/12 de Lechuga (" + tiemposLechuga + " seg)\n" +
            (condimentosAcumulados ) + " cda(s) de Aderezo (" + tiemposCondimentos + " seg)\n" +
             "\tTiempo de la simulacion: " + tiempoTotal + " segundos");

        } else { // Los pedidos son mayores
             JOptionPane.showMessageDialog(null," \n SE PREPARARON " + dogosPreparados + " HOTDOG(S) \n" +
             "\n QUEDARON LOS SIGUIENTES INGREDIENTES: \n" +
            (pan +1) + " Piezas de Pan \n" +
            (mayonesa +1) + " cda(s) de mayonesa \n"+
            (tocino +1) + " Tiras de Tocino \n"+
            (salchicha +1) + " Salchichas \n"+
            (cebolla +1) + "/4 de Cebolla \n"+
            (tomate +1) + "/4 de Tomate \n"+
            (lechuga +1) + "/12 de Lechuga \n" +
            (condimentos +1) + " cda(s) de Aderezo \n" +

            "\n INGREDIENTES QUE SE UTILIZARON Y TIEMPOS DE LAS TAREAS: \n" +
            (panAcumulado -1) + " Piezas de Pan (" + tiemposPan + " seg)\n" +
            (mayonesaAcumulada -1) + " cda(s) de mayonesa (" + tiemposMayonesa + " seg)\n"+
            (tocinoAcumulado -1) + " Tiras de Tocino (" + tiemposTocino + " seg)\n"+
            (salchichaAcumulada -1) + " Salchichas (" + tiemposSalchicha + " seg)\n"+
            (cebollaAcumulada -1) + "/4 de Cebolla (" + tiemposCebolla + " seg)\n"+
            (tomateAcumulado -1) + "/4 de Tomate (" + tiemposTomate + " seg)\n"+
            (lechugaAcumulada -1) + "/12 de Lechuga (" + tiemposLechuga + " seg)\n" +
            (condimentosAcumulados -1) + " cda(s) de Aderezo (" + tiemposCondimentos + " seg)\n"+
             "\tTiempo de la simulacion: " + tiempoTotal + " segundos");

        }*/
    }
}
