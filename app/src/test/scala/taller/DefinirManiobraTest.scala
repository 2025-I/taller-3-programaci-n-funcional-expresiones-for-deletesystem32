package taller

import org.scalatest.funsuite.AnyFunSuite

class DefinirManiobraTest extends AnyFunSuite {

  val definir = new DefinirManiobra()

  // Función para generar una lista de vagones
  def generarVagones(tamano: Int): List[Char] = {
    val alfabeto = ('a' to 'z').toList
    List.fill((tamano + alfabeto.size - 1) / alfabeto.size)(alfabeto).flatten.take(tamano)
  }

  test("Prueba de juguete: 10 vagones y 10 movimientos") {
    val t1 = generarVagones(10)
    val t2 = t1.reverse
    val movimientos = definir.definirManiobra(t1, t2)
    assert(movimientos.size == 10, s"Se esperaban 10 movimientos, pero se obtuvieron ${movimientos.size}")
  }

  test("Prueba pequeña: 100 vagones y 100 movimientos") {
    val t1 = generarVagones(100)
    val t2 = t1.reverse
    val movimientos = definir.definirManiobra(t1, t2)
    assert(movimientos.size == 100, s"Se esperaban 100 movimientos, pero se obtuvieron ${movimientos.size}")
  }

  test("Prueba mediana: 500 vagones y 500 movimientos") {
    val t1 = generarVagones(500)
    val t2 = t1.reverse
    val movimientos = definir.definirManiobra(t1, t2)
    assert(movimientos.size == 500, s"Se esperaban 500 movimientos, pero se obtuvieron ${movimientos.size}")
  }

  test("Prueba grande: 1000 vagones y 1000 movimientos") {
    val t1 = generarVagones(1000)
    val t2 = t1.reverse
    val movimientos = definir.definirManiobra(t1, t2)
    assert(movimientos.size == 1000, s"Se esperaban 1000 movimientos, pero se obtuvieron ${movimientos.size}")
  }
}
