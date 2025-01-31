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
                String[] partes = linea.split(", ");
                if (linea.startsWith(nombreProducto + ",")) {
                    return Integer.parseInt(partes[1]); // Retorna la cantidad disponible
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de inventario.");
        }
        return 0; // Si el producto no existe, retornamos 0
    }

    // Metodo para registrar movimientos en el archivo de movimientos
    public static void registrarMovimiento(String nombreProducto, int cantidad, String motivo) {
        try (FileWriter writer = new FileWriter("movimiento.txt", true)) {
            writer.write(nombreProducto + ", " + cantidad + ", " + motivo + "\n");
            System.out.println("Movimiento registrado: " + motivo + " de " + cantidad + " unidades.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de movimientos.");
        }
    }

    // Metodo para actualizar o agregar un producto en el inventario
    public static void actualizarInventario(String nombreProducto, int nuevaCantidad) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("inventario.txt"));
            boolean encontrado = false;

            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                if (linea.startsWith(nombreProducto + ",")) {
                    lineas.set(i, nombreProducto + ", " + nuevaCantidad); // Actualiza la cantidad
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                lineas.add(nombreProducto + ", " + nuevaCantidad); // Agrega nuevo producto si no existia
            }

            // Escribe todas las lineas de nuevo en el archivo
            Files.write(Paths.get("inventario.txt"), lineas);
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de inventario.");
        }
    }

    // Modulo para agregar un nuevo producto
    public static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (productoExiste(nombreProducto)) {
            System.out.println("El producto ya existe. Use la opcion de reposicion para agregar mas stock.");
            return;
        }

        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();


        // Actualiza el inventario
        actualizarInventario(nombreProducto, cantidad);
        registrarMovimiento(nombreProducto, cantidad, "nuevo producto");
    }

    // Modulo para venta
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
            System.out.println("Error: No hay suficiente stock.");
            return;
        }


        // Actualiza el inventario
        int nuevaCantidad = cantidadDisponible - cantidadVendida;
        actualizarInventario(nombreProducto, nuevaCantidad);
        registrarMovimiento(nombreProducto, -cantidadVendida, "venta");
    }

    // Modulo para devolucion
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


        // Actualiza el inventario
        actualizarInventario(nombreProducto, nuevaCantidad);
        registrarMovimiento(nombreProducto, cantidad, "devolucion");
    }

    // Modulo para reposicion
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


        // Actualiza el inventario
        actualizarInventario(nombreProducto, nuevaCantidad);
        registrarMovimiento(nombreProducto, cantidad, "reposicion");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestion de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Registrar Venta");
            System.out.println("3. Registrar Devolucion");
            System.out.println("4. Registrar Reposicion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opcion invalida. Intente de nuevo.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
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
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
