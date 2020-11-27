/**
 * Esta clase tendra la funcion de almacenar los valores
 * de todos las cantidades necesarios para la elaboracion
 * de un hotdog
 */
package Clases;

public class Acumuladores {

    private String name;
    private int cantidadAcumulada = 0;

    public Acumuladores(String name) {
        this.name = name;
    }

    public void setCantidadAcumulada(int cantidadAcumulada) {
        this.cantidadAcumulada = cantidadAcumulada;
    }

    public int getCantidadAcumulada() {
        return cantidadAcumulada;
    }

    public String getName() {
        return name;
    }
}
