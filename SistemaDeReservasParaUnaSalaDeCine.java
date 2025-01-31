/**
* Sistema básico de reservas de cine
<<<<<<< HEAD
 * Equipo 4
 * Jesus Alfonso Dominguez Valdez
 * Briceida Martinez Hernandez
 * Luis Eduardo Vadillo Rojas
 * Flavia Sofia Zuñiga Guimarais
=======
*/
public class SistemaCine {

/**
* Estructura de datos para la sala:
* - Usar matriz booleana 6x6
* - false = asiento ocupado
* - true = asiento libre
*/
private boolean[][] sala; //Regresa booleano para comprobar si los asientos estan disponibles u ocupados
    //Luisprueba

/**
*
* 1. Inicializar la sala
* 2. Marcar todos los asientos como disponibles
>>>>>>> origin/ProyectoEquipo4
*/

import java.util.*;
public class Main {

    private boolean[][] sala; //Regresa booleano para comprobar si los asientos estan disponibles u ocupados
    private Scanner escaner;

    /**1.-
     * Constructor para inicializar la sala de cine con todos los asientos disponibles
     */
    public  Main () {
        sala = new boolean[6][6]; //Inicia la matriz de los asientos
        escaner = new Scanner(System.in);   //Abre el escanerentrada
        inicializarSala();  //Funcion  que inicializa la matriz de la sala
    }

    /**2.- Inicializa la sala vacia
     *
     */
    private void inicializarSala() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                sala[i][j] = true; // Asigna todos los asientos como disponibles
            }
        }
    }

    /**3.-
     * Menú principal que mostrará opciones al usuario
     */

    /**4.-
     * Muestra la sala de cine con el estado de los asientos
     */

    /**5.-
     * Permite al usuario reservar un asiento en la sala
     */

    /**6.-
     * Verifica si la posición ingresada es válida
     */
    private boolean validarPosicion(int fila, int columna) {
        return fila >= 1 && fila <= 6 && columna >= 1 && columna <= 6; //Regresa true o false si cumple o no las condiciones para un asiento valido
    }


    /**7.-
     * Método principal que inicia el programa
     */
    public static void main(String[] args) {
    //Poner el switch que servirá como menu
    }
}
//-------------------------------------FIN DEL PROGRAMA------------------------------



/**-------------------------------------COMENTARIOS ANTERIORES---------------------------------
 * Comentarios previos para tener como guia de funcionamiento:
 *   /**
 *   * Estructura de datos para la sala:
 *   * - Usar matriz booleana 6x6
 *   * - false = asiento ocupado
 *   * - true = asiento libre
 *
 *   /**
 *   * 1. Inicializar la sala
 *   * 2. Marcar todos los asientos como disponibles
 *
 *   /**
 *     * Menú principal que mostrará:
 *     * 1. Ver sala
 *     * 2. Reservar asiento
 *     * 3. Salir
 *
 *   /**
 *     * Mostrar sala:
 *     * 1. Imprimir números de columna (1-6)
 *     * 2. Para cada fila:
 *     * - Mostrar número de fila
 *     * - Mostrar estado de cada asiento [O] libre, [X] ocupado
 *
 *     /**
 *     * Proceso de reserva:
 *     * 1. Pedir al usuario fila y columna
 *     * 2. Validar que sea una posición válida
 *     * 3. Verificar si el asiento está disponible
 *     * 4. Si está disponible:
 *     * - Marcar como ocupado
 *     * - Confirmar reserva
 *     * 5. Si no está disponible:
 *     * - Informar al usuario
 *
 *    /**
 *     * Validar posición:
 *     * 1. Verificar que fila y columna estén entre 1 y 6
 *     * 2. Verificar que el asiento no esté ocupado
 *     *
 *
 *     /**
 *     Punto de entrada del programa:
 *     1. Crear nueva instancia del sistema
 *     2. Mostrar menú
 *     3. Procesar selección del usuario
 *
 */