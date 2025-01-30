/**
* Sistema básico de reservas de cine
*/
public class SistemaCine {

/**
* Estructura de datos para la sala:
* - Usar matriz booleana 6x6
* - false = asiento ocupado
* - true = asiento libre
*/
private boolean[][] sala; //Regresa booleano para comprobar si los asientos estan disponibles u ocupados

    //
/**
*
* 1. Inicializar la sala
* 2. Marcar todos los asientos como disponibles
*/


/**
* Menú principal que mostrará:
* 1. Ver sala
* 2. Reservar asiento
* 3. Salir
*/
public void mostrarMenu() {
//Poner escaner y recibir entrada
}

/**
* Mostrar sala:
* 1. Imprimir números de columna (1-6)
* 2. Para cada fila:
* - Mostrar número de fila
* - Mostrar estado de cada asiento [O] libre, [X] ocupado
*/
public void mostrarSala() {
// Mostrar estado de la sala
}

/**
* Proceso de reserva:
* 1. Pedir al usuario fila y columna
* 2. Validar que sea una posición válida
* 3. Verificar si el asiento está disponible
* 4. Si está disponible:
* - Marcar como ocupado
* - Confirmar reserva
* 5. Si no está disponible:
* - Informar al usuario
* - Preguntar si quiere elegir otro asiento
*/
public void reservarAsiento() {
// Funcion que llenará la matriz de asientos
}

/**
* Validar posición:
* 1. Verificar que fila y columna estén entre 1 y 6
* 2. Verificar que el asiento no esté ocupado
*/

private boolean ocupado (int fila, int columna) {
// Aquí se validara si el asiento esta ocupado o no
return true;
}

/**
* Punto de entrada del programa:
* 1. Crear nueva instancia del sistema
* 2. Mostrar menú
* 3. Procesar selección del usuario
*/
public static void main(String[] args) {
//Poner el switch que servirá como menu
}
}

