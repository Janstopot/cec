package Clases;

import Clases.Usuarios.Alpinista;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expedicion {

    private final int ID;

    private String nombre;

    private int montañaId;

    private double duracion;

    private Date fecha;

    private List<Excursionista> listaExcursionistas = new ArrayList<>();


    private boolean finalizada = false;

    public Expedicion(String nombre, int montañaId, double duracion, Date fecha, Medico medico) {
        this.ID = GeneradorID.generarId();
        this.nombre = nombre;
        this.montañaId = montañaId;
        this.duracion = duracion;
        this.fecha = fecha;
        this.listaExcursionistas.add(medico);
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

    public int getMontañaId() {
        return montañaId;
    }

    public void setMontañaId(int montañaId) {
        this.montañaId = montañaId;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Excursionista> getListaExcursionistas() {
        return listaExcursionistas;
    }

    public void setListaExcursionistas(Excursionista excursionista) {
        this.listaExcursionistas.add(excursionista);
    }

}
