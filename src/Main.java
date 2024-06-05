import java.util.Scanner;

public class Main {

    //// RESET AND COLORS
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001b[32;1m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";

    // RED BACKGROUND
    public static final String ANSI_RESET_BACK = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";


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
        System.out.println("1) Ver lista de montanas ---------> " + YELLOW + Metodos.listaMontañas.size() +  "  montanas." + RESET);
        System.out.println("2) Ver lista de expediciones -----> " + YELLOW + Metodos.listaExpediciones.size() +  "  expediciones." + RESET);
        System.out.println("3) Ver lista de excurisionistas --> " + YELLOW + Metodos.listaExcursionistas.size() +  "  excursionistas." + RESET);
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
                Metodos.verMontanas();
                ejecutarPrograma();
                break;
            case 2:
                Metodos.verExpediciones();
                ejecutarPrograma();
                break;
            case 3:
                Metodos.verExcursionistas();
                ejecutarPrograma();
                break;
            case 4:
                Metodos.nuevaMontaña();
                ejecutarPrograma();
                break;
            case 5:
                Metodos.nuevaExpedicion();
                ejecutarPrograma();
                break;
            case 6:
                Metodos.nuevoExcursionista();
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