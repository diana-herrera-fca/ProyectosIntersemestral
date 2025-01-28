
# Práctica 1 

## **Ejercicio 1: Diferencia Máxima en un Arreglo (Arreglos)**
**Descripción:**  
Dado un arreglo de números enteros, encuentra la diferencia máxima entre dos elementos del arreglo, donde el número más grande aparece después del más pequeño.

**Entrada:**
- Un entero `n` que indica el tamaño del arreglo (2 ≤ n ≤ 100).
- Un arreglo de `n` enteros.

**Salida:**
- La diferencia máxima entre dos elementos.

**Ejemplo:**
1. Entrada:
   ```
   5  
   2 3 10 6 4  
   ```  
   Salida:
   ```
   8  
   ```
2. Entrada:
   ```
   4  
   7 1 5 3  
   ```  
   Salida:
   ```
   4  
   ```
3. Entrada:
   ```
   3  
   10 8 7  
   ```  
   Salida:
   ```
   0  
   ```

---

## **Ejercicio 2: Cadenas Alternadas (Cadenas)**
**Descripción:**  
Dada una cadena, elimina los caracteres consecutivos repetidos para que la cadena resultante tenga caracteres alternados.

**Entrada:**
- Una cadena `s` (1 ≤ longitud de `s` ≤ 10^4).

**Salida:**
- La cadena sin caracteres consecutivos repetidos.

**Ejemplo:**
1. Entrada:
   ```
   aaabccddd  
   ```  
   Salida:
   ```
   abcd  
   ```
2. Entrada:
   ```
   aabbcc  
   ```  
   Salida:
   ```
   abc  
   ```
3. Entrada:
   ```
   ababab  
   ```  
   Salida:
   ```
   ababab  
   ```

---

## **Ejercicio 3: Operaciones con Matrices (Excepciones)**
**Descripción:**  
Crea un programa que acepte dos matrices cuadradas y realice una operación seleccionada por el usuario (`suma` o `multiplicación`). Maneja las siguientes excepciones:
1. Si las matrices no son cuadradas, muestra un error.
2. Si la operación ingresada no es válida, lanza un error.

**Entrada:**
- Dimensiones de las matrices.
- Elementos de ambas matrices.
- Tipo de operación (`suma` o `multiplicación`).

**Salida:**
- Resultado de la operación o mensaje de error.

**Ejemplo:**
1. Entrada:
   ```
   2  
   1 2  
   3 4  
   2 0  
   1 2  
   suma  
   ```  
   Salida:
   ```
   3 2  
   4 6  
   ```
2. Entrada:
   ```
   2  
   1 2  
   3 4  
   2 0  
   1 2  
   multiplicación  
   ```  
   Salida:
   ```
   4 4  
   10 8  
   ```
3. Entrada:
   ```
   2  
   1 2  
   3 4  
   2 0  
   1 2  
   resta  
   ```  
   Salida:
   ```
   Error: Operación no válida  
   ```
