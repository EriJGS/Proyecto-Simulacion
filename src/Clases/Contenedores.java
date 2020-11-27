/**
 * Esta clase tendra la funcion de almacenar los valores
 * de todos las cantidades necesarios para la elaboracion
 * de un hotdog
 */
package Clases;

import javax.swing.*;

public class Contenedores {

    private String name;
    private int cantidad = 0;

    public Contenedores(String name) {
        this.name = name;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getName() {
        return name;
    }
}
