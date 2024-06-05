package Acciones;

import static BaseDeDatos.BD.*;
import Clases.Catalogo;
import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Alpinista;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;
import static Otros.Ansi.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crear {

    public static void nuevoCatalogo(){
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||         NUEVO CATALOGO        ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        Scanner input = new Scanner(System.in);

        System.out.println(YELLOW + "Introduce el nombre del catálogo: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        catalogo = new Catalogo(nombre);

    }

    public static void nuevaMontaña(){
        // eliminar
        catalogo = new Catalogo("TEST");
        //

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||         NUEVA MONTANA         ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        Scanner input = new Scanner(System.in);

        System.out.println(YELLOW + "Introduce el nombre: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Montana creada: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Montaña nuevaMontaña = new Montaña(nombre, catalogo.getID());
        listaMontañas.add(nuevaMontaña);
        catalogo.setListaMontañas(nuevaMontaña);
    }

    public static void nuevaExpedicion(){
        Medico medico = null;
        Montaña montaña = null;

        if(listaMontañas.size() == 0){
            System.err.println("No existen motanas");
            return;
        } else if (listaExcursionistas.size() == 0) {
            System.err.println("No existen excursionistas");
            return;
        }

        List<Medico> listaMedicos = new ArrayList<>();
        for(Excursionista e : listaExcursionistas){
            if(e instanceof Medico) listaMedicos.add((Medico) e);
        }

        if (listaMedicos.size() == 0){
            System.err.println("No hay medicos disponibles");
            return;
        }
        else{
            while(medico == null){
                Scanner input = new Scanner(System.in);
                System.out.println(YELLOW + "Anade un medico para crear la expedicion: " + RESET);
                for(Medico m : listaMedicos){
                    System.out.println(m.getNombre());
                }
                for(Medico m : listaMedicos){
                    if(m.getNombre().matches(input.nextLine().toLowerCase())) medico = m;
                }
                if(medico == null) System.err.println("Medico no encontrado");
            }
        }

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||         NUEVA EXPEDICION      ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        System.out.println(YELLOW + "Escribe el nombre de la montana: " + RESET);


        while(montaña == null){
            Scanner input = new Scanner(System.in);
            for(Montaña m : listaMontañas){
                System.out.println(m.getNombre());
            }
            for(Montaña m : listaMontañas){
                if(m.getNombre().equals(input.nextLine().toLowerCase())) montaña = m;
            }
            if(montaña == null) System.err.println("Montana no encontrada.");
        }


        Scanner input = new Scanner(System.in);
        System.out.println(YELLOW + "Introduce el nombre de la expedicion: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Expedicion creada: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Expedicion expedicion = new Expedicion(nombre, montaña.getID(), 0, null, medico);
        listaExpediciones.add(expedicion);
        medico.setListaExpediciones(expedicion);
        montaña.setListaExpediciones(expedicion);

    }

    public static void nuevoExcursionista(){
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||        NUEVO EXCURSIONISTA    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);

        Scanner input = new Scanner(System.in);
        System.out.println(YELLOW + "Introduce el nombre del excursionista: " + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        String nombre = input.nextLine().toLowerCase();

        Excursionista excursionista = null;

        while(excursionista == null){
            System.out.println(PURPLE + "Introduce el tipo de excursionista: MEDICO o ALPINISTA" + RESET);
            String i = input.nextLine().toLowerCase();
            if(i.matches("medico")) excursionista = new Medico(nombre, 35);
            if(i.matches("alpinista")) excursionista = new Alpinista(nombre, 35);
            else System.err.println("Tipo no reconocido");
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(GREEN + "Excursionista creado: " + nombre + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        listaExcursionistas.add(excursionista);
    }
}
