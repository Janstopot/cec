import Clases.Catalogo;
import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Alpinista;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    public static List<Montaña> listaMontañas = new ArrayList<>();
    public static List<Expedicion> listaExpediciones = new ArrayList<>();
    public static List<Excursionista> listaExcursionistas = new ArrayList<>();
    public static Catalogo catalogo;

    public static void nuevoCatalogo(){
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||         NUEVO CATALOGO        ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        Scanner input = new Scanner(System.in);

        System.out.println(Main.YELLOW + "Introduce el nombre del catálogo: " + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        String nombre = input.nextLine().toLowerCase();

        catalogo = new Catalogo(nombre);

    }

    public static void nuevaMontaña(){
        // eliminar
        catalogo = new Catalogo("TEST");
        //

        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||         NUEVA MONTANA         ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        Scanner input = new Scanner(System.in);

        System.out.println(Main.YELLOW + "Introduce el nombre: " + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.GREEN + "Montana creada: " + nombre + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);

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
                System.out.println(Main.YELLOW + "Anade un medico para crear la expedicion: " + Main.RESET);
                for(Medico m : listaMedicos){
                    System.out.println(m.getNombre());
                }
                for(Medico m : listaMedicos){
                    if(m.getNombre().matches(input.nextLine().toLowerCase())) medico = m;
                }
                if(medico == null) System.err.println("Medico no encontrado");
            }
        }

        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||         NUEVA EXPEDICION      ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);

        System.out.println(Main.YELLOW + "Escribe el nombre de la montana: " + Main.RESET);


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
        System.out.println(Main.YELLOW + "Introduce el nombre de la expedicion: " + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        String nombre = input.nextLine().toLowerCase();

        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.GREEN + "Expedicion creada: " + nombre + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);

        Expedicion expedicion = new Expedicion(nombre, montaña.getID(), 0, null, medico);
        listaExpediciones.add(expedicion);
        medico.setListaExpediciones(expedicion);
        montaña.setListaExpediciones(expedicion);

    }

    public static void nuevoExcursionista(){
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||        NUEVO EXCURSIONISTA    ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);

        Scanner input = new Scanner(System.in);
        System.out.println(Main.YELLOW + "Introduce el nombre del excursionista: " + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        String nombre = input.nextLine().toLowerCase();

        Excursionista excursionista = null;

        while(excursionista == null){
            System.out.println(Main.PURPLE + "Introduce el tipo de excursionista: MEDICO o ALPINISTA" + Main.RESET);
            String i = input.nextLine().toLowerCase();
            if(i.matches("medico")) excursionista = new Medico(nombre, 35);
            if(i.matches("alpinista")) excursionista = new Alpinista(nombre, 35);
            else System.err.println("Tipo no reconocido");
        }
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.GREEN + "Excursionista creado: " + nombre + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        listaExcursionistas.add(excursionista);
    }

    public static void verMontanas(){
        if(listaMontañas.size() == 0){
            System.err.println("No hay montanas que mostrar");
            return;
        }
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||        LISTA DE MONTANAS      ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        for(Montaña m : listaMontañas){
            System.out.println(m.getNombre());
        }
    }

    public static void verExpediciones(){
        if(listaExpediciones.size() == 0){
            System.err.println("No hay expediciones que mostrar");
            return;
        }
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||      LISTA DE EXPEDICIONES    ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        for(Expedicion e : listaExpediciones){
            System.out.println(e.getNombre());
        }
    }

    public static void verExcursionistas(){
        if(listaExcursionistas.size() == 0){
            System.err.println("No hay excursionistas que mostrar");
            return;
        }
        for(Excursionista e : listaExcursionistas){
            System.out.println(listaExcursionistas.indexOf(e) + " : " + e.getNombre());
            if(e instanceof Medico) System.out.println("Tipo: Medico");
            else System.out.println("Tipo: Alpinista");
        }
    }
}
