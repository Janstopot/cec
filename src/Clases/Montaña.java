package Clases;

import Clases.Usuarios.Alpinista;

import java.util.ArrayList;
import java.util.List;

public class Montaña {

    private final int ID;
    private int catalogoId;
    private String nombre;

    private List<Expedicion> listaExpediciones = new ArrayList<>();

    private List<Alpinista> listaAlpinistas = new ArrayList<>();

    public Montaña(String nombre, int catalogId) {
        this.catalogoId = catalogId;
        this.nombre = nombre;
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

    public int getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(int catalogoId) {
        this.catalogoId = catalogoId;
    }

    public List<Expedicion> getListaExpediciones() {
        return listaExpediciones;
    }

    public void setListaExpediciones(Expedicion expedicion) {
        this.listaExpediciones.add(expedicion);
    }

    public List<Alpinista> getListaAlpinistas() {
        return listaAlpinistas;
    }

    public void setListaAlpinistas(Alpinista alpinista) {
        for(Alpinista a : this.listaAlpinistas){
            if(a.getID() == alpinista.getID()) return;
        }
        this.listaAlpinistas.add(alpinista);
    }
}
