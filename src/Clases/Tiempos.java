/**
  * Esta clase tendra la funcion de almacenar los valores
  * de todos las tiempos necesarios para la elaboracion
  * de un hotdog
  */
package Clases;

public class Tiempos {

    private String name;
    private int time = 0;

    public Tiempos (String name) {
        this.name = name;
    }

    public void setTiempo(int time) {
        this.time = time;
    }

    public int getTiempo() {
        return time;
    }

    public String getName(){
        return name;
    }
}
