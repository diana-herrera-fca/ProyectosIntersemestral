import java.util.Scanner;
import java.io.*;

public class Cuestionario {

    public static void main(String[] args) {

        String archivoSalida = "encuestas.txt";

        try(Scanner scanner = new Scanner(System.in)) {

            GestorDeArchivos gestor = new GestorDeArchivos();

            while(true){

                System.out.println("Ingrese el nombre del archivo: ");
                String nombreEncuesta = scanner.nextLine();

                Encuesta encuesta = new Encuesta(nombreEncuesta);
                gestor.guardarEncuesta(archivoSalida, encuesta);

                System.out.println("Encuesta guardada.");

                break;

            }//Fin de while

        }catch (IOException e){

            System.err.println(e.getMessage());

        }

    }//Fin de main

}//Fin de Cuestionario

class GestorDeArchivos{

    public void guardarEncuesta(String archivo, Encuesta encuesta) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))){

            writer.write(encuesta.toString());
            writer.write("////////////////////////\n");

        }

    }

}//Fin de GestorDeArchivos

class Encuesta{

    public String nombre;

    public Encuesta(String nombre){

        this.nombre = nombre;
    }//Fin de contructor

    public String toString(){

        return nombre;

    }


}//Finde Encuesta