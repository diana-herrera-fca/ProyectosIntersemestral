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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.*;
public class Main {

   
    private static final String ARCHIVO_ENTRADA = "entrada.txt";
    private static final String ARCHIVO_SALIDA = "salida.txt";
    private boolean[][] sala; // Matriz de asientos
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
    
    private void cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO_ENTRADA);
        if (!archivo.exists()) {
            System.out.println("No se encontró archivo de entrada. Se inicializa la sala vacía.");
            inicializarSala();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ENTRADA))) {
            for (int i = 0; i < 6; i++) {
                String linea = br.readLine();
                if (linea == null) {
                    System.out.println("Archivo de entrada incompleto. Se inicializa la sala vacía.");
                    inicializarSala();
                    return;
                }
                String[] valores = linea.split(" ");
                for (int j = 0; j < 6; j++) {
                    sala[i][j] = valores[j].equals("O"); // "O" representa asiento libre
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error al leer el archivo de entrada. Se inicializa la sala vacía.");
            inicializarSala();
        }
    }
    /**3.-
     * Menú principal que mostrará opciones al usuario
     */
public void mostrarMenu() {

    int opcion;
    do{
        System.out.println("\n---- Sistema de Reservas de Cine ----");
        System.out.println("1. Ver sala");
        System.out.println("2. Reservar asiento");
        System.out.println("3. Salir");
        System.out.println("4. Seleccione una opcion");

        opcion = escaner.nextInt();

        switch (opcion){

            case 1:
                mostrarSala(); //Muestra la matriz de los asientos y su estado actual
                break;

                case 2:
                reservarAsiento(); //Metodo para reservar asiento
                    break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                        default:
                            System.out.println("Opción inválida. Intente de nuevo.");

        }

    }while (opcion != 3);

    }
    

    /**4.-
     * Muestra la sala de cine con el estado de los asientos
     */
    public void mostrarSala() {

        System.out.println("\n 1 2 3 4 5 6");//Indicador de columnas

        for (int i = 0; i < 6; i++){
            System.out.print((i + 1)+ "");
            for (int j = 0; j < 6; j++){
                System.out.print(sala [i][j] ? "[O]" : "[X]");//Ternario que dependiendon del estado asigna un "simbolo"
                                                               // u otro
            }
            System.out.println();//Linea de espacio
        }

    }
    /**5.-
     * Permite al usuario reservar un asiento en la sala
     */
    public void reservarAsiento() {
        int fila, columna;
        while (true) {
            System.out.print("Ingrese la fila (1-6): ");
            fila = escaner.nextInt();
            System.out.print("Ingrese la columna (1-6): ");
            columna = escaner.nextInt();

            if (validarPosicion(fila, columna)) { //usa la funcion validarPosicion
                if (sala[fila - 1][columna - 1]) { //Si el asiento esta ocupado o vacio envia distintos ensajes
                    sala[fila - 1][columna - 1] = false; //Asigna el asliento como ocupado
                    System.out.println("Reserva confirmada en fila " + fila + ", columna " + columna);
                    break;
                } else {
                    System.out.println("El asiento ya está ocupado. Intente nuevamente.");
                }
            } else {
                System.out.println("Posición inválida. Intente de nuevo.");
            }
        }
    }


    /**6.-
     * Verifica si la posición ingresada es válida
     */
    private boolean validarPosicion(int fila, int columna) {
        return fila >= 1 && fila <= 6 && columna >= 1 && columna <= 6; //Regresa true o false si cumple o no las condiciones para un asiento valido
    }

   private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_SALIDA))) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    bw.write(sala[i][j] ? "O" : "X");
                    if (j < 5) bw.write(" ");
                }
                bw.newLine();
            }
            System.out.println("Estado de la sala guardado en " + ARCHIVO_SALIDA);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de salida.");
        }
    }
    /**7.-
     * Método principal que inicia el programa
     */
public static void main(String[] args) {
    Main cine = new Main(); // Inicia el método de main que inicia todos los demás en domino
    cine.mostrarMenu();
    cine.guardarEnArchivo(); // Guardar el estado de la sala cuando el usuario termina
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
