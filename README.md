# Sistema de Reserva de Asientos en una Sala de Cine
# **Proyecto Final Equipo 4 Programación EA96**

## Descripción del Proyecto

Este proyecto es un sistema básico de reservas de asientos para una sala de cine. Permite a un cliente visualizar los asientos disponibles, seleccionar y reservar uno o varios asientos.

## Requerimientos Específicos

- El sistema permite al usuario ver las butacas disponibles y seleccionar una o varias para reservar.
- Al confirmar la reserva, el estado de las butacas se actualiza en tiempo real.
- Se genera un registro de la reserva realizada.
- La sala cuenta con un máximo de 36 butacas organizadas en una matriz de 6x6.
- El sistema solo gestiona reservas para una única función y un horario específico.
- No se permite la modificación ni cancelación de reservas una vez confirmadas.
- La asignación de películas a la sala es manual y definida por el administrador.
- Los horarios son estáticos y no se considerarán cambios ni atrasos en las funciones.

### Requerimientos Previos

- Tener instalado Java en el sistema (en caso de correr el proyecto localmente).
- Un compilador de Java o un entorno de desarrollo como IntelliJ IDEA o Eclipse o en linea a través de OnlineGDB.com

## Ejemplos de Uso

1. **Visualizar la sala:**

   - El usuario selecciona la opción `1` en el menú.
   - Se muestra una representación en forma de matriz con las butacas disponibles `[O]` y ocupadas `[X]`.

2. **Reservar un asiento:**

   - El usuario selecciona la opción `2` en el menú.
   - Ingresa la fila y columna deseada.
   - Si el asiento está disponible, se confirma la reserva y se actualiza el estado de la butaca.
   - Si el asiento está ocupado, se le solicita al usuario que seleccione otro.

3. **Salir del sistema:**

   - El usuario selecciona la opción `3` en el menú para salir del programa.

## Autores

- **Jesús Alfonso Domínguez Valdez**
- **Briceida Martínez Hernández**
- **Luis Eduardo Vadillo Rojas**
- **Flavia Sofía Zuñiga Guimarais**
