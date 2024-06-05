package Acciones;

import Clases.Expedicion;
import Clases.Montaña;
import Clases.Usuarios.Excursionista;
import Clases.Usuarios.Medico;
import static Otros.Ansi.*;
import static BaseDeDatos.BD.*;

public class Obtener {

    public static void verMontanas(){
        if(listaMontañas.size() == 0){
            System.err.println("No hay montanas que mostrar");
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||        LISTA DE MONTANAS      ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        for(Montaña m : listaMontañas){
            System.out.println(m.getNombre());
        }
    }

    public static void verExpediciones(){
        if(listaExpediciones.size() == 0){
            System.err.println("No hay expediciones que mostrar");
            return;
        }
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
        System.out.println(YELLOW + "||      LISTA DE EXPEDICIONES    ||" + RESET);
        System.out.println(YELLOW + "||-------------------------------||" + RESET);
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
