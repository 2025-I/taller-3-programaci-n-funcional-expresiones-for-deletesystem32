# AplicarMovimiento.scala

## Proceso de ejecución

La función `aplicarMovimiento` recibe un estado `e` y un movimiento `m`, y devuelve el estado resultante después de aplicar dicho movimiento. Para ello, utiliza expresiones `for` para manejar los diferentes casos de movimientos (`Uno` y `Dos`).

- Si `n > 0`, se mueven `n` vagones del trayecto principal al trayecto auxiliar correspondiente.
- Si `n < 0`, se mueven `n` vagones del trayecto auxiliar al principal.
- Si `n = 0`, no se realiza ningún cambio.

## Diseño de funciones recursivas

No se utiliza recursión en esta función, ya que la lógica se resuelve mediante pattern matching y expresiones `for`.

## Pruebas de software

Se deben probar los siguientes casos:

- Movimientos con `n` positivo, negativo y cero.
- Estados con diferentes configuraciones de vagones en los trayectos.
- Movimientos que excedan la cantidad de vagones disponibles.

## Conclusiones

- La función es eficiente para transformar estados individuales.
- No maneja secuencias de movimientos.
- Su complejidad es lineal respecto al número de vagones afectados.
