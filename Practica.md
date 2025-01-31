
# Práctica

## **Ejercicio 1: Rotación Circular a la Izquierda (Arreglos)**
**Descripción:**  
Escribe un programa que rote los elementos de un arreglo a la izquierda `k` veces.

**Entrada:**
- Un entero `n` que indica el tamaño del arreglo (1 ≤ n ≤ 100).
- Un entero `k` que indica el número de rotaciones.
- Un arreglo de `n` enteros.

**Salida:**
- El arreglo después de rotarlo `k` veces.

**Ejemplo:**
1. Entrada:
   ```
   5 2  
   1 2 3 4 5  
   ```  
   Salida:
   ```
   3 4 5 1 2  
   ```
2. Entrada:
   ```
   4 1  
   10 20 30 40  
   ```  
   Salida:
   ```
   20 30 40 10  
   ```
3. Entrada:
   ```
   6 3  
   7 8 9 10 11 12  
   ```  
   Salida:
   ```
   10 11 12 7 8 9  
   ```

---

## **Ejercicio 2: Cuenta de Palabras Únicas (Cadenas)**
**Descripción:**  
Escribe un programa que reciba una cadena y devuelva el número de palabras únicas en ella. Ignora mayúsculas y espacios adicionales.

**Entrada:**
- Una cadena de texto.

**Salida:**
- Un entero representando el número de palabras únicas.

**Ejemplo:**
1. Entrada:
   ```
   hola mundo hola  
   ```  
   Salida:
   ```
   2  
   ```
2. Entrada:
   ```
   Hello world hello  
   ```  
   Salida:
   ```
   2  
   ```
3. Entrada:
   ```
   Python is great and Python is fun  
   ```  
   Salida:
   ```
   6  
   ```

---

## **Ejercicio 3: Validación de Archivos (Excepciones)**
**Descripción:**  
Escribe un programa que valide si una lista de nombres de archivo cumple con un formato específico (`nombre.extension`). Maneja las siguientes excepciones:
1. Si un archivo no tiene extensión, lanza un error.
2. Si la extensión no es válida (`txt`, `csv`, `jpg`), lanza un error.

**Entrada:**
- Una lista de cadenas que representan nombres de archivos.

**Salida:**
- `Valid` si todos los nombres de archivo son válidos, o un mensaje de error si alguno no lo es.

**Ejemplo:**
1. Entrada:
   ```
   archivo.txt  
   imagen.jpg  
   datos.csv  
   ```  
   Salida:
   ```
   Valid  
   ```
2. Entrada:
   ```
   archivo  
   imagen.jpg  
   datos.csv  
   ```  
   Salida:
   ```
   Error: archivo no tiene extensión  
   ```
3. Entrada:
   ```
   archivo.txt  
   imagen.png  
   datos.csv  
   ```  
   Salida:
   ```
   Error: imagen.png tiene una extensión no válida  
   ```
