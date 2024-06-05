package Otros;

public class GeneradorID {

    private static int nuevaId;
    private static int contador = 0;

    public static int generarId(){
        nuevaId = contador;
        contador++;
        return nuevaId;
    }
}
