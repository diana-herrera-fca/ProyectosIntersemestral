# Proyectos Intersemestral
# **Proyecto Final de Programación en Java E3**

## **Máquina de Pago de Estacionamiento**
1. **Descripción del Proyecto:**
   Este proyecto consiste en desarrollar un Sistema de Máquina de Pago de Estacionamiento. 
   El sistema permite registrar la entrada y salida de vehículos, calcular tarifas en función del tiempo de estancia
   y procesar pagos de forma eficiente.
   El sistema cuenta con las siguientes funcionalidades:
   - Registrar la entrada de un vehículo: El sistema solicita la placa del vehículo y registra la hora de entrada.
   - Procesar el pago de un vehículo: Al ingresar la placa, se calcula el tiempo de estancia, se determina la tarifa correspondiente y se muestra el monto a pagar, y el método de pago que se desee.
   - Generar tickets: Después de procesar el pago, el sistema guarda el ticket con la información de la entrada y salida, así como la tarifa pagada.

   

2. **Requerimientos Específicos**
   - Archivos de entrada - entrada.txt
   Este archivo contendra los registros de entrada de los vehículos, incluyendo placa y hora de entrada.
   - Archivo de salida – salida.txt
    Este archivo registrará los pagos realizados incluyendo placa, hora de entrada, hora de salida, monto a pagar.
   - Lógica del Estacionamiento:
    El primer bloque de 15 minutos de estancia es gratuito.
    Después de esos 15 minutos, se cobrará 5 pesos por cada fracción de 15 minutos, es decir, $20 la hora.
   - Métodos de Pago y manejo de excepciones:
   - •Efectivo: El sistema calculará el cambio depende del monto ingresado, si el pago está incompleto mostrara un mensaje de error.
   - •Tarjeta: El sistema procesara el pago, si el pago no puede ser procesado mostrara un mensaje de error, el número de intentos máximo es de 3.

3. **Cómo Ejecutarlo:**
- $ java Main
-------
  **Bienvenido al sistema de estacionamiento** (Se muestra el menú principal)

- **Ejemplo al seleccionar la opción 1**
  - 1.Registrar entrada de vehículo.
  - 2.Procesar pago y calcular tarifa.
  - 3.Salir del sistema.
  - Seleccione una opción: 1
------
Ingrese la placa del vehículo: ABC123
- Vehículo con placa ABC123 
- Registrado a las 10:15 AM.

-------------------------------
**Ejemplo seleccionar opción 2**
- 1.Registrar entrada de vehículo.
- 2.Procesar pago y calcular tarifa.
- 3.Salir del sistema.
- ----
- Seleccione una opción: 2
- Ingrese la placa del vehículo: ABC123
- Tiempo de estancia: 30 minutos
- Tarifa a pagar: $10
- ¿Método de pago (efectivo/tarjeta): efectivo
- **Pago realizado.**
- Cambio: $0.


-------------------------------
**Ejemplo seleccionar opción 3**
   - 1.Registrar entrada de vehículo.
   - 2.Procesar pago y calcular tarifa.
   - 3.Salir del sistema.
---
Seleccione una opción: 3
- Saliendo del sistema...

4. **Ejemplos de Uso:**
  
