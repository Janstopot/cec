package Clases.Usuarios;

import Clases.Expedicion;
import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public abstract class Excursionista {

    private final int ID;

    private String nombre;

    private int edad;

    private List<Expedicion> listaExpediciones = new ArrayList<>();

    public Excursionista(String nombre, int edad) {
        this.ID = GeneradorID.generarId();
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Expedicion> getListaExpediciones() {
        return listaExpediciones;
    }

    public void setListaExpediciones(Expedicion expedicion) {
        this.listaExpediciones.add(expedicion);
    }
}
