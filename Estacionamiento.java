

import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estacionamiento {

    // Función para obtener la hora actual en formato "HH:mm"
    public static String obtenerHoraActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // Formato de hora
        return sdf.format(new Date()); // Devuelve la hora actual
    }

    // Función para registrar la entrada de un vehículo
    public static void registrarEntrada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la placa del vehículo: ");
        String placa = scanner.nextLine(); // Lee la placa del vehículo

        // Valida si la placa es válida
        if (!validarPlaca(placa)) {
            System.out.println("Placa no válida. No se registró la entrada.");
            return; // Si no es válida, termina la función
        }

        String horaEntrada = obtenerHoraActual(); // Obtiene la hora actual

        // Escribe la placa y la hora de entrada en el archivo "entradas.txt"
        try (FileWriter fw = new FileWriter("entradas.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(placa + "," + horaEntrada); // Guarda la placa y la hora
            System.out.println("Entrada registrada: " + placa + " a las " + horaEntrada);
        } catch (IOException e) {
            System.out.println("Error al registrar la placa: " + e.getMessage());
        }
    }

    // Función para obtener la hora de entrada de un vehículo desde el archivo
    public static String obtenerHoraEntradaDesdeArchivo(String placa) {
        try (BufferedReader br = new BufferedReader(new FileReader("entradas.txt"))) {
            String linea;
            // Lee el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separa la placa y la hora
                if (datos[0].equalsIgnoreCase(placa)) { // Busca la placa
                    return datos[1]; // Devuelve la hora de entrada
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada: " + e.getMessage());
        }
        return null; // Si no encuentra la placa, devuelve null
    }

    // Función para calcular el tiempo de estancia en minutos
    public static int calcularTiempoEstancia(String horaEntrada, String horaSalida) {
        String[] entradaPartes = horaEntrada.split(":"); // Separa horas y minutos de la entrada
        String[] salidaPartes = horaSalida.split(":"); // Separa horas y minutos de la salida
        int horaEntradaMinutos = Integer.parseInt(entradaPartes[0]) * 60 + Integer.parseInt(entradaPartes[1]); // Convierte la hora de entrada a minutos
        int horaSalidaMinutos = Integer.parseInt(salidaPartes[0]) * 60 + Integer.parseInt(salidaPartes[1]); // Convierte la hora de salida a minutos
        // Calcula la diferencia de tiempo, considerando si pasa de medianoche
        int diferenciaMinutos = (horaSalidaMinutos < horaEntradaMinutos) ? (1440 - horaEntradaMinutos) + horaSalidaMinutos : horaSalidaMinutos - horaEntradaMinutos;
        return (int) Math.ceil(diferenciaMinutos / 15.0) * 15; // Redondea el tiempo a intervalos de 15 minutos
    }

    // Función para calcular la tarifa basada en el tiempo de estancia
    public static int calcularTarifa(int minutos) {
        minutos -= 15; // Los primeros 15 minutos son gratis
        return (minutos <= 0) ? 0 : ((int) Math.ceil(minutos / 15.0)) * 5; // Cobra $5 por cada 15 minutos adicionales
    }

    // Función principal (menú del programa)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // Menú de opciones
            System.out.println("------------------------------");
            System.out.println("E S T A C I O N A M I E N T O");
             System.out.println("------------------------------");
            System.out.println("\n¡Recuerda que los primeros 15 min de tu estancia son gratis!\n");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Calcular tarifa de salida");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    registrarEntrada(); // Registra la entrada de un vehículo
                    break;
                case 2:
                    System.out.print("Ingresa la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    String horaEntrada = obtenerHoraEntradaDesdeArchivo(placa); // Obtiene la hora de entrada
                    if (horaEntrada == null) {
                        System.out.println("No se encontró la entrada para la placa ingresada.");
                        break;
                    }
                    String horaSalida = obtenerHoraActual(); // Obtiene la hora de salida
                    int minutosEstancia = calcularTiempoEstancia(horaEntrada, horaSalida); // Calcula el tiempo de estancia
                    int tarifa = calcularTarifa(minutosEstancia); // Calcula la tarifa
                    System.out.println("Minutos de estancia: " + minutosEstancia);
                    System.out.println("Tarifa: $" + tarifa);
                    procesarPago(scanner, tarifa, placa, minutosEstancia); // Procesa el pago
                    break;
                case 3:
                    System.out.println("¡Hasta Pronto! :)"); // Sale del programa
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 3); // Repite el menú hasta que el usuario elija salir
    }

    // Función para validar la placa del vehículo
    public static boolean validarPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            System.out.println("La placa no puede estar vacía.");
            return false; // La placa no es válida si está vacía
        }
        return placa.matches("^[A-Za-z0-9]+$"); // La placa es válida si solo contiene letras y números
    }

    // Función para procesar el pago
    public static void procesarPago(Scanner sc, int tarifa, String placa, int minutosEstancia) {
        System.out.print("\nSelecciona el método de pago (1: Efectivo, 2: Tarjeta): ");
        int metodoPago = sc.nextInt(); // Lee el metodo de pago
        boolean pagoExitoso = false;
        int cambio = 0;

        if (metodoPago == 1) { // Pago en efectivo
            System.out.print("Ingresa la cantidad en efectivo: $");
            int efectivo = sc.nextInt();
            if (efectivo >= tarifa) { // Verifica si el pago es suficiente
                cambio = efectivo - tarifa; // Calcula el cambio
                System.out.println("Pago realizado con éxito.");
                System.out.println("Cambio: $" + cambio);
                pagoExitoso = true;
            } else {
                System.out.println("Pago insuficiente. Intenta nuevamente.");
            }
        } else if (metodoPago == 2) { // Pago con tarjeta
            System.out.println("Pago con tarjeta realizado con éxito.");
            pagoExitoso = true;
        } else {
            System.out.println("Método de pago inválido.");
        }

        if (pagoExitoso) {
            escribirArchivoSalida(placa, minutosEstancia, tarifa, metodoPago, cambio); // Genera el ticket
        }
    }

    // Función para escribir el ticket en un archivo
    public static void escribirArchivoSalida(String placa, int minutos, int tarifa, int metodoPago, int cambio) {
        try (FileWriter fw = new FileWriter("tickets.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Placa: " + placa); // Escribe la placa
            pw.println("Tiempo de estancia: " + minutos + " minutos"); // Escribe el tiempo de estancia
            pw.println("Tarifa: $" + tarifa); // Escribe la tarifa
            pw.println("Método de pago: " + (metodoPago == 1 ? "Efectivo" : "Tarjeta")); // Escribe el metodo de pago
            if (metodoPago == 1) {
                pw.println("Cambio: $" + cambio); // Escribe el cambio si fue en efectivo
            }
            pw.println("-------------------------"); // Separador
            System.out.println("Ticket generado en tickets.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir el ticket: " + e.getMessage());
        }
    }
}
