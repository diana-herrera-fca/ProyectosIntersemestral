import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GestionInventario {

   // Metodo para verificar si un producto ya existe en el inventario
    public static boolean productoExiste(String nombreProducto) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("inventario.txt"));
            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
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
            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
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

    // Metodo para registrar movimientos en el archivo de movimientos 
    public static void registrarMovimiento(String nombreProducto, int cantidad, String motivo) {
        try (FileWriter writer = new FileWriter("movimiento.txt", true)) {
            writer.write(nombreProducto + ", " + cantidad + ", " + motivo + "\n");
            System.out.println("Movimiento registrado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de movimientos.");
        }
    }

// Metodo para actualizar la cantidad de un producto en el archivo de inventario
    public static void actualizarInventario(String nombreProducto, int nuevaCantidad) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("inventario.txt"));
            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                if (linea.startsWith(nombreProducto + ",")) {
                    lineas.set(i, nombreProducto + ", " + nuevaCantidad); // Actualiza la cantidad
                    break;
                }
            }
// Escribe todas las líneas de nuevo en el archivo
            Files.write(Paths.get("inventario.txt"), lineas);
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de inventario.");
        }
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
        scanner.nextLine(); 

        int cantidadDisponible = obtenerCantidadDisponible(nombreProducto);
        if (cantidadVendida > cantidadDisponible) {
            System.out.println("Error: No hay suficiente stock para vender " + cantidadVendida + " unidades.");
            return;
        }
        
        // Actualiza la cantidad en el inventario
        int nuevaCantidad = cantidadDisponible - cantidadVendida;
        actualizarInventario(nombreProducto, nuevaCantidad);
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
        scanner.nextLine(); 
        int cantidadDisponible = obtenerCantidadDisponible(nombreProducto);
        int nuevaCantidad = cantidadDisponible + cantidad;

        // Actualiza la cantidad en el inventario
        actualizarInventario(nombreProducto, nuevaCantidad);
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
        scanner.nextLine(); 
        int cantidadDisponible = obtenerCantidadDisponible(nombreProducto);
        int nuevaCantidad = cantidadDisponible + cantidad;

        // Actualiza la cantidad en el inventario
        actualizarInventario(nombreProducto, nuevaCantidad);
        registrarMovimiento(nombreProducto, +cantidad, "reposición");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Inventario ---");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Registrar Devolución");
            System.out.println("3. Registrar Reposición");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    venta(scanner);
                    break;
                case 2:
                    devolucion(scanner);
                    break;
                case 3:
                    reposicion(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no volida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
