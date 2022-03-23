package edu.escuelaing.arep.TallerVirtualizacion;
import static spark.Spark.*;
/**
 * Esta clase define los subprocesos para empezar a ejecutrar.
 * @author Deivid Medina
 * @version 15/03/2022
 */

public class primerApiSegura
{
    /**
     * Clase principal main, la cual invoca los métodos correspondientes para ejecutar el main.
     * @param args - String []
     */
    public static void main( String[] args ){
        secure(getKeyStore(), "123456", null, null);
        port(getPor());
        get("/hello", ((request, response) -> "Hello World Seguridad"));
    }

    /**
     * Método que me permite obtener el puerto donde se ejecutara la aplicación, en caso de no ser definido por defecto se dara el puerto 4567
     * @return int - Retorna el puerto obtenido o sino por defecto el puerto 4567.
     */
    private static int getPor() {
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

    /**
     * Método que me permite obtener el KeyStore para realizar la validación segura.
     * @return ruta donde se encuentra mi keyStore
     */
    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null){
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore.p12";
    }
}
