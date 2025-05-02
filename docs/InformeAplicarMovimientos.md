# AplicarMovimientos.scala

## Proceso de ejecución

La función `aplicarMovimientos` aplica una lista de movimientos a un estado inicial, generando una lista de estados intermedios. Utiliza una función auxiliar recursiva con tail recursion para acumular los estados.

## Diseño de funciones recursivas

- La función auxiliar `aux` recorre la lista de movimientos y aplica cada uno al último estado acumulado.
- Se garantiza la terminación gracias a la tail recursion.

## Pruebas de software

Se deben probar los siguientes casos:

- Listas vacías de movimientos.
- Secuencias de movimientos que involucren ambos trayectos auxiliares.
- Movimientos que requieran manejar límites (ej.: mover más vagones de los disponibles).

## Conclusiones

- La función es eficiente y maneja correctamente secuencias de movimientos.
- La complejidad es lineal respecto al número de movimientos.
