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
