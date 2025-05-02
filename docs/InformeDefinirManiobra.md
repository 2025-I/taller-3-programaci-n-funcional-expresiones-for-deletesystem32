# DefinirManiobra.scala

## Proceso de ejecución

La función `definirManiobra` genera una secuencia de movimientos para transformar el tren `t1` en `t2`. Utiliza una función auxiliar recursiva que compara los vagones del tren objetivo con los disponibles en los trayectos y decide moverlos según su posición.

## Diseño de funciones recursivas

- La función `aux` maneja casos base (trenes vacíos) y recursivos (comparación de vagones).
- Se prioriza mover vagones desde los trayectos auxiliares al principal cuando coinciden con el objetivo.

## Pruebas de software

Se deben probar los siguientes casos:

- Trenes idénticos (maniobra vacía).
- Trenes con vagones en orden inverso.
- Casos donde los vagones están distribuidos en los trayectos auxiliares.

## Conclusiones

- La función es correcta pero puede no ser óptima en el número de movimientos.
- Su complejidad depende de la distribución de los vagones en los trayectos.
