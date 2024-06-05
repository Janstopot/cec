import Acciones.Crear;
import Acciones.Obtener;
import BaseDeDatos.BD;

import java.util.Scanner;

import static Otros.Ansi.*;

public class Main {

    //// RESET AND COLORS



    public static void main(String[] args) {
        ejecutarPrograma();
    }

    public static void ejecutarPrograma(){
        imprimirCabecera();
        imprimirMenu();
        int input = recojerInput();
        realizarAccion(input);
    }

    private static void imprimirCabecera(){
        System.out.println("||---------------------------------||");
        System.out.println("||          Bienvenido a           ||");
        System.out.println("||               CEC               ||");
        System.out.println("||---------------------------------||");

    }

    private static void imprimirMenu(){
        System.out.println(PURPLE + "Escoje una de las siguientes opciones:" + RESET);
        System.out.println("1) Ver lista de montanas ---------> " + YELLOW + BD.listaMontañas.size() +  "  montanas." + RESET);
        System.out.println("2) Ver lista de expediciones -----> " + YELLOW + BD.listaExpediciones.size() +  "  expediciones." + RESET);
        System.out.println("3) Ver lista de excurisionistas --> " + YELLOW + BD.listaExcursionistas.size() +  "  excursionistas." + RESET);
        System.out.println("4) Anadir nueva montana");
        System.out.println("5) Anadir nueva expedicion");
        System.out.println("6) Anadir nuevo excursionista");
        System.out.println("0) Cerrar programa.");
    }

    public static void realizarAccion(int input) {
        switch (input){
            case 0:
                System.out.println("Cerrando programa");
                break;
            case 1:
                Obtener.verMontanas();
                ejecutarPrograma();
                break;
            case 2:
                Obtener.verExpediciones();
                ejecutarPrograma();
                break;
            case 3:
                Obtener.verExcursionistas();
                ejecutarPrograma();
                break;
            case 4:
                Crear.nuevaMontaña();
                ejecutarPrograma();
                break;
            case 5:
                Crear.nuevaExpedicion();
                ejecutarPrograma();
                break;
            case 6:
                Crear.nuevoExcursionista();
                ejecutarPrograma();
                break;
        }
    }

    private static int recojerInput(){
        Scanner kb = new Scanner(System.in);
        int input = -1;
        while(input < 0 || input > 6){
            try{
                input = Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Introudce un número \n");
                imprimirMenu();

            }
            if(input < 0 || input > 6){
                System.out.println("Introudce un número dentro de la seleccion");
                imprimirMenu();
            }
        }
        return input;
    }
}