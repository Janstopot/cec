package Clases;

import Otros.GeneradorID;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private final int ID;

    private String nombre;

    private List<Montaña> listaMontañas = new ArrayList<>();

    public Catalogo(String name) {
        setNombre(name);
        this.ID = GeneradorID.generarId();
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

    public List<Montaña> getListaMontañas() {
        return listaMontañas;
    }

    public void setListaMontañas(Montaña montaña) {
        this.listaMontañas.add(montaña);
    }

}
