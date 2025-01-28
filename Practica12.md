## -----------------EJERCICIO 2-------------------------

```
class Solution {
public int findChampion(int[][] grid) {
int n = grid.length;
int candidato = 0;

        // Identificar al posible campeón
        for (int i = 1; i < n; i++) {
            if (grid[i][candidato] == 1) {
                candidato = i; // Si el equipo i vence al candidato actual, i se convierte en el nuevo candidato
            }
        }

        // Verificar si el candidato es realmente el campeón
        for (int i = 0; i < n; i++) {
            if (i != candidato && (grid[candidato][i] != 1 || grid[i][candidato] != 0)) {
                return -1; // No hay campeón si el candidato pierde contra algún otro equipo
            }
        }

        return candidato; // Retornar el equipo campeón
    }
}

```