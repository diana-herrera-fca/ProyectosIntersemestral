Descripción del Proyecto

El Sistema de Gestión de Inventario de Tienda es un programa en Java diseñado para automatizar y simplificar el control de inventario en tiendas minoristas. El sistema reemplaza los procesos manuales existentes con un sistema basado en archivos que permite el seguimiento preciso de productos y sus movimientos.
En cuanto a su alcance, el sistema maneja el registro y seguimiento de productos de uso cotidiano en tiendas minoristas, con capacidad para gestionar entre 50 y 200 productos diferentes, procesando un volumen de 20 a 50 transacciones diarias.
La estructura del sistema se basa en dos archivos de texto principales: inventario.txt, que almacena el inventario actual, y movimientos.txt, que registra el historial de transacciones.

Requerimientos

Requerimientos Funcionales

1. Gestión de Productos
    - Agregar nuevos productos al inventario
    - Validar la no duplicación de productos
    - Mantener registro de cantidad disponible

2. Gestión de Movimientos
    - Registrar ventas con reducción de inventario
    - Procesar devoluciones con incremento de inventario
    - Manejar reposiciones de stock
    - Validar disponibilidad antes de ventas

3. Formato de Datos
    - Inventario: `nombre_producto,cantidad`
    - Movimientos: `nombre_producto,cambio,motivo`

4. Validaciones
    - Cantidades: Números enteros
    - Nombres: Caracteres alfanuméricos sin espacios externos
    - Motivos: Limitados a "Venta", "Reposición", "Devolución"

Requerimientos No Funcionales

1. Rendimiento
    - Capacidad para manejar 50-200 productos
    - Procesamiento de 20-50 transacciones diarias

2. Usabilidad
    - Interfaz por línea de comandos
    - Mensajes de error claros y específicos

3. Confiabilidad
    - Actualización inmediata después de cada movimiento
    - Manejo de excepciones para errores de archivo

4. Restricciones Técnicas
    - Implementación en Java
    - Almacenamiento en archivos de texto plano
    - Sin requerimientos de autenticación


Limitaciones
- No requiere logs adicionales
- No incluye control de acceso
- No genera reportes adicionales más allá del archivo de movimientos



Guía de ejecución

A partir de la ejecución del programa se desplegará un menú de 5 opciones:

1. Agregar Producto
2. Registrar Venta
3. Registrar Devolucion
4. Registrar Reposicion
5. Salir

1. Agregar Producto
Esta opción se utiliza cuando se necesita incorporar un producto completamente nuevo al inventario. El sistema verifica automáticamente que el producto no exista previamente.

El sistema solicitará:
- Nombre del producto (debe ser único)
- Cantidad inicial en stock
- Precio unitario del producto


Ejemplo de uso:

Seleccione una opción: 1
Ingrese el nombre del producto: Gel Antibacterial
Ingrese la cantidad inicial: 25
Ingrese el precio unitario: 45.50


Si se intenta agregar "Agua Embotellada" u otro producto existente, el sistema indicará que se use la opción de reposición en su lugar.

2. Registrar Venta
Esta opción gestiona la salida de productos por venta. El sistema realiza automáticamente:
- Verificación de existencia del producto
- Comprobación de stock suficiente
- Actualización del inventario
- Registro del movimiento


Ejemplo de uso:

Seleccione una opción: 2
Ingrese el nombre del producto: Leche Entera
Ingrese la cantidad vendida: 5


El sistema verificará que haya suficientes unidades (en este caso, hay 150 unidades de Leche Entera) y realizará la venta a $25.0 por unidad.

3. Registrar Devolución
Esta opción registra la devolución de productos. El sistema:
- Verifica que el producto exista
- Aumenta el stock automáticamente
- Registra la devolución en el historial


Ejemplo de uso:

Seleccione una opción: 3
Ingrese el nombre del producto: Jugo de Naranja
Ingrese la cantidad devuelta: 2


El sistema aumentará el stock de Jugo de Naranja de 150 a 152 unidades.

4. Registrar Reposición
Esta opción permite aumentar el stock de productos existentes. El sistema:
- Verifica que el producto exista
- Suma las nuevas unidades al stock actual
- Mantiene el mismo precio unitario
- Registra la reposición


Ejemplo de uso:

Seleccione una opción: 4
Ingrese el nombre del producto: Café Soluble
Ingrese la cantidad repuesta: 30


El stock de Café Soluble aumentará de 70 a 100 unidades, manteniendo su precio de $27.0.
