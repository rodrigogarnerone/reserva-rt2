//Source file: C:\\Users\\rodri\\Desktop\\Nueva carpeta\\Marca.java
package model;

import java.util.ArrayList;

public class Marca
{
    private String nombre;
    public ArrayList<Modelo> modelos;

    public Marca(ArrayList<Modelo> modelos, String nombre) {
        this.modelos = modelos;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }



    public void mostrarMisModelos()
    {

    }
}
