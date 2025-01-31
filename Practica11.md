EJERCICIO 1 -------------------------
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in); // Se crea el escaner

// Leer el tamaño del arreglo y el numero de rotaciones
System.out.println("Introduzca el tamaño del arreglo: ");
int n = sc.nextInt();
System.out.println("Introduzca el numero de rotaciones a la izquierda del arreglo: ");
int k = sc.nextInt();

//Se crea un arreglo con el tamaño de n
int[] arreglo = new int[n];
for (int i = 0; i < n; i++) {

//Llena el arreglo con los numeros que se ingresen
System.out.println("Introduzca los valores del arreglo: ");
arreglo[i] = sc.nextInt();
}

// Ajustar k en caso de que sea mayor que n
k = k % n;
//De acuerdo al residuo de la division de k y n, asigna los indices

//Crea arreglo para almacenar el resultado igual con tamaño de "n"
int[] resultado = new int[n];

// Realiza la "rotacion"
for (int i = 0; i < n; i++) {
resultado[i] = arreglo[(i + k) % n];

//resultado en el indice del bucle es igual a el valor que tiene el arreglo en el indice del bucle
//+ el numero de rotaciones con el resultado y regresa el residuo de eso con el tamaño del arreglo.
}

// Imprime el resultado del array "resultado"
for (int i = 0; i < n; i++) {
System.out.print(resultado[i] + (i < n - 1 ? " " : ""));
}
}
}

EJERCICIO 2 ---------------------------------
import java.util.*;

public class Main {

public static void main(String[] args) {
// Solicita la entrada del usuario
System.out.println("Introduzca la frase: ");
Scanner escaner = new Scanner(System.in);
String frase = escaner.nextLine();

// Llama a la función que cuenta las palabras únicas
int resultado = contarPalabrasUnicas(frase);

// Imprime el número de palabras únicas
System.out.println("Número de palabras únicas: " + resultado);
}



//---------------------------------------
// Contar las palabras únicas
public static int contarPalabrasUnicas(String frase) {
// Elimina los espacios extra
String fraseSinEspacioXtra = frase.trim().replaceAll("\\s+", " ");

// Divide la frase en palabras utilizando el espacio como delimitador
String[] palabras = fraseSinEspacioXtra.split(" ");

// Usar un ArrayList para almacenar las palabras, pero evitando duplicados
List palabrasUnicas = new ArrayList<>();

// Agregar solo palabras que NO están completamente en mayúsculas (ignorando mayúsculas/minúsculas)
for (String palabra : palabras) {

/*
1.- Si la palabra esta en mayusculas tipo ASI, no cuenta la palabra
2.- Si la palbra esta Asi entonces, la convierte a minusculas
3.- Añadir palabra a palabrasUnicas si no está en la lista
*/


// Verificar si la palabra NO está completamente en mayúsculas
if (!palabra.equals(palabra.toUpperCase())) {

String palabraMinuscula = palabra.toLowerCase(); // Convertir la palabra a minúsculas

// Añadir solo si no está ya en la lista
if (!palabrasUnicas.contains(palabraMinuscula)) {
palabrasUnicas.add(palabraMinuscula); // Añadir la palabra a la lista
}
}
}

// Regresa el número de palabras únicas
return palabrasUnicas.size();
}
}




EJERCICIO 3-------------------------------------
import java.util.*;

class Main {
public static void main(String[] ar) {
try {
Scanner scan = new Scanner(System.in);
String s = scan.nextLine();

List archivo = new ArrayList<>();
for (String st : s.split(",")) {
archivo.add(st);
}

for (String fileName : archivo) {
if (!fileName.contains(".")) {
throw new Exception(fileName + " no tiene extension");
}

String extension = fileName.substring(fileName.lastIndexOf(".") + 1);


if (extension.isEmpty()) {
throw new Exception(fileName + " tiene una extension vacC-a");
}
}

System.out.println("Valido");

} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
}
}



