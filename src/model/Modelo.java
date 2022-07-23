//Source file: C:\\Users\\rodri\\Desktop\\Nueva carpeta\\Modelo.java
package model;

public class Modelo
{
    private String nombre;
    public Marca marca;

    public Modelo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String[] getMarcaYModelo() {
        String[] marcaModelo = {nombre, marca.getNombre()};
        return marcaModelo;
    }
}