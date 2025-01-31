## EJERCICIO: GRADING STUDENTS
````
import java.util.*;

class Result {

public static List gradingStudents(List grades) {
List califRedondeadas = new ArrayList<>(); //Lista donde se guardan las calificaciones redondeadas

for (int numeroActual : grades) {
if (numeroActual >= 38) {
int multiploCinco = ((numeroActual / 5) + 1) * 5; // Encuentra el siguiente múltiplo de 5
if (multiploCinco - numeroActual < 3) {
numeroActual = multiploCinco; // Redondea solo si la diferencia es menor a 3
}
}
califRedondeadas.add(numeroActual); /*Agrega el numoero sin redondear si
es menor a 38*/
}

return califRedondeadas;
}
}

````

