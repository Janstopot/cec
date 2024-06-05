package Clases.Usuarios;

import Clases.Montaña;

import java.util.ArrayList;
import java.util.List;

public class Alpinista extends Excursionista {

    private List<Montaña> listaMonañas = new ArrayList<>();

    public Alpinista(String name, int edad) {
        super(name, edad);
    }


    public List<Montaña> getListaMonañas() {
        return listaMonañas;
    }

    public void setListaMonañas(Montaña montaña) {
        this.listaMonañas.add(montaña);
    }
}
