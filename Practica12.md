## ---------------EJERCICIO 448---------------------------
````
import java.util.ArrayList;
import java.util.List;
public class Solution {
public List findDisappearedNumbers(int[] nums) {
ArrayList result = new ArrayList<>();

// Marcar los elementos presentes de forma negativa
for (int i = 0; i < nums.length; i++) {
int index = Math.abs(nums[i]) - 1; // Encontrar el índice correspondiente
if (nums[index] > 0) {
nums[index] *= -1; // Marcamos el número como negativo
}
}

// Agregar los números desaparecidos al resultado
for (int i = 0; i < nums.length; i++) {
if (nums[i] > 0) { // Si es positivo, significa que ese número no estaba en el array
result.add(i + 1); // El número desaparecido es i+1
}
}

return result;
}
}
````



## -----------------EJERCICIO 2923-------------------------

```
class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length; //Asigna a n el tamaño de la matriz
        int candidato = 0; //Candidato inicial

        for (int i = 1; i < n; i++) {
            //Se compara si el equipo i vence al candidato actual
            if (grid[i][candidato] == 1) {
                candidato = i; // Si el equipo i vence al candidato actual, i se convierte en el nuevo candidato
            }
        }

        // Si el equipo i nunca le gana a candidato, regresa -1
        for (int i = 0; i < n; i++) {
            if (i != candidato && (grid[candidato][i] != 1 || grid[i][candidato] != 0)) {
                return -1; 
            }
        }

        return candidato; // Regresa el equipo campeón
    }
}

```

## ------------EJERCICIO 387------------------------------

````
class Solution {
public int firstUniqChar(String s) {

int indiceUnico = -1; //Se inicia en -1 por si no encuentra caracteres unico

s = s.toLowerCase();

//Transforma la frase a minusculas

List caracteres = new ArrayList<>();
for (int i=0; i< s.length(); i++){
caracteres.add(s.charAt(i)); //Agrega los caracteres individuales a una lista
}




//Va por cada elemento de la lista verificando si el caracter actual es igual a
char caracterActual;
for (int i=0; i
//Primer bucle que itera sobre cada caracter para asignarlo al caracter actual
boolean esUnico = true;

caracterActual = caracteres.get(i);

for (int j=0; j
//Segundo bucle que recorre la lista y compara con el caracter actual
if (i != j && caracterActual == caracteres.get(j)){

esUnico = false;
break;

}


}

if (esUnico) {
indiceUnico = i;
break; // Asigna el indice del caracter unico a la salida
}

}


return indiceUnico;


}
}

````


