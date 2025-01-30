import java.util.*;
import java.io.*;

public class Cuestionario {

    public static void main(String[] args) {

        String archivoEntrada = "encuestas.txt";
        String archivoSalida = "recuentoSalida.txt";

        // Creamos las listas de las preguntas y respuestas
        List<String> preguntas = new ArrayList<>();
        List<List<String>> respuestas = new ArrayList<>();

        // Lectura del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {

            String linea;

            while ((linea = br.readLine()) != null) {//Lee linea por linea hasta que no haya mas

                String[] partes = linea.split(","); // Separador que usa la coma

                if (partes.length == 3) {

                    String pregunta = partes[1].replace("\"", "").trim();
                    //Sirve para limpiar tanto preguntas y respuestas
                    String respuesta = partes[2].replace("\"", "").trim();

                    int index = preguntas.indexOf(pregunta);//Verifica que exista la pregunta

                    // Se busca si no existe la pregunta y si ese es el caso la agrega
                    if (index == -1) { //
                        preguntas.add(pregunta);
                        respuestas.add(new ArrayList<>());
                        index = preguntas.size() - 1;
                    }

                    respuestas.get(index).add(respuesta); //agrega la respuesta de la pregunta recien agrega

                } // Fin if

            } // Fin while

        } catch (IOException e) { //

            System.err.println("Error de entrada: " + e.getMessage());

        } catch (Exception e) {

            System.err.println("Error inesperado: " + e.getMessage());
        }




        // se empieza a escribir en el archivo de salida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {

            for (int i = 0; i < preguntas.size(); i++) {//recorre todas las preguntas

                //Si en la pregunta que se encuentra situado no tiene respuesta la salta
                if (respuestas.get(i) == null) continue;

                //Escribe las preguntas en el nuevo archivo
                writer.write(preguntas.get(i) + "\n");

                List<String> respuestasLista = respuestas.get(i);//Lista con todas las preguntas
                List<String> respuestasUnicas = new ArrayList<>();//Lista con las respuestas sin repetir
                List<Integer> conteo = new ArrayList<>();//cuantas veces se repitio la pregunta

                for (String respue : respuestasLista) {

                    int index = respuestasUnicas.indexOf(respue);

                    if (index == -1) {//Si la respuesta no está en respuestasUnicas, la agrega y su contador inicia en 1.
                        respuestasUnicas.add(respue);
                        conteo.add(1);
                    } else {
                        conteo.set(index, conteo.get(index) + 1);//Si ya existe, incrementa el contador en conteo.
                    }

                }//Fin for

                for (int j = 0; j < respuestasUnicas.size(); j++) {

                    writer.write(respuestasUnicas.get(j) + ": " + conteo.get(j) + "\n");
                }//Escribe las respuestas y el recuento en el archivo

                writer.write("\n");//Slato de linea

            } // Fin for

            System.out.println("Recuento de respuestas generado en: " + archivoSalida);

        } catch (IOException e) { //

            System.err.println("Error de I/O al escribir el archivo: " + e.getMessage());

        } catch (Exception e) {

            System.err.println("Error inesperado al escribir el archivo: " + e.getMessage());

        }

    } // Fin de main
} // Fin de Cuestionario




