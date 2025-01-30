package src;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GestionInventario {

    // Metodo para escribir en el archivo de inventario (formato: nombre, cantidad)
    public static void escribirInventario(String nombreProducto, int cantidad) {
        try (FileWriter writer = new FileWriter("inventario.txt", true)) {
            writer.write(nombreProducto + ", " + cantidad + "\n");
            System.out.println("Datos añadidos al inventario.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de inventario.");
        }
    }

    // Metodo para registrar movimientos en el archivo de movimientos (formato: nombre, cantidad, motivo)
    public static void registrarMovimiento(String nombreProducto, int cantidad, String motivo) {
        try (FileWriter writer = new FileWriter("movimiento.txt", true)) {
            writer.write(nombreProducto + ", " + cantidad + ", " + motivo + "\n");
            System.out.println("Movimiento registrado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de movimientos.");
        }
    }

    // Metodo para verificar si un producto ya existe en el inventario
    public static boolean productoExiste(String nombreProducto) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("inventario.txt"));
            for (String linea : lineas) {
                if (linea.startsWith(nombreProducto + ",")) {
                    return true; // El producto ya existe
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de inventario.");
        }
        return false; // El producto no existe
    }

    // Metodo para obtener la cantidad disponible de un producto
    public static int obtenerCantidadDisponible(String nombreProducto) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("inventario.txt"));
            for (String linea : lineas) {
                if (linea.startsWith(nombreProducto + ",")) {
                    String[] partes = linea.split(", ");
                    return Integer.parseInt(partes[1]); // Retorna la cantidad disponible
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de inventario.");
        }
        return -1; // Si el producto no existe
    }

    // Módulo para agregar un producto inicial
    public static void agregarProductoInicial(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (productoExiste(nombreProducto)) {
            System.out.println("Error: El producto ya existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        escribirInventario(nombreProducto, cantidad);
    }

    // Módulo para venta
    public static void venta(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (!productoExiste(nombreProducto)) {
            System.out.println("Error: El producto no existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        int cantidadDisponible = obtenerCantidadDisponible(nombreProducto);
        if (cantidadVendida > cantidadDisponible) {
            System.out.println("Error: No hay suficiente stock para vender " + cantidadVendida + " unidades.");
            return;
        }

        registrarMovimiento(nombreProducto, -cantidadVendida, "venta");
    }

    // Módulo para devolución
    public static void devolucion(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (!productoExiste(nombreProducto)) {
            System.out.println("Error: El producto no existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la cantidad devuelta: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        registrarMovimiento(nombreProducto, +cantidad, "devolución");
    }

    // Módulo para reposición
    public static void reposicion(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (!productoExiste(nombreProducto)) {
            System.out.println("Error: El producto no existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la cantidad repuesta: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        registrarMovimiento(nombreProducto, +cantidad, "reposición");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Registrar Devolución");
            System.out.println("4. Registrar Reposición");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarProductoInicial(scanner);
                    break;
                case 2:
                    venta(scanner);
                    break;
                case 3:
                    devolucion(scanner);
                    break;
                case 4:
                    reposicion(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}