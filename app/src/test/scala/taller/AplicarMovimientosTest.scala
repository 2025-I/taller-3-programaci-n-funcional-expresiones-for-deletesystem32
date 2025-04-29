package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AplicarMovimientosTest extends AnyFunSuite {

  val obj = new AplicarMovimientos()

  test("Test 1: Secuencia básica Uno(2), Dos(3), Dos(-1), Uno(-2)") {
    val e1 = (List('a', 'b', 'c', 'd'), Nil, Nil)
    val movimientos = List(obj.Uno(2), obj.Dos(3), obj.Dos(-1), obj.Uno(-2))
    val resultado = obj.aplicarMovimientos(e1, movimientos)

    val esperado = List(
      (List('a', 'b', 'c', 'd'), Nil, Nil),
      (List('a', 'b'), List('c', 'd'), Nil),
      (Nil, List('c', 'd'), List('a', 'b')),
      (List('a'), List('c', 'd'), List('b')),
      (List('c', 'd', 'a'), Nil, List('b'))
    )

    assert(resultado == esperado)
  }

  test("Test 2: Sin movimientos") {
    val e = (List('x', 'y', 'z'), Nil, Nil)
    val movimientos = Nil
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado == List(e))
  }

  test("Test 3: Mover todo a uno con Uno(4)") {
    val e = (List('a', 'b', 'c', 'd'), Nil, Nil)
    val movimientos = List(obj.Uno(4))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.last == (Nil, List('a', 'b', 'c', 'd'), Nil))
  }

  test("Test 4: Mover más vagones de los que hay") {
    val e = (List('p'), Nil, Nil)
    val movimientos = List(obj.Uno(5), obj.Uno(-2))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.last == (List('p'), Nil, Nil))
  }

  test("Test 5: Alternar trayectos Uno y Dos") {
    val e = (List('a', 'b', 'c'), Nil, Nil)
    val movimientos = List(obj.Uno(1), obj.Dos(1), obj.Uno(-1), obj.Dos(-1))
    val resultado = obj.aplicarMovimientos(e, movimientos)

    val esperado = List(
      (List('a', 'b', 'c'), Nil, Nil),
      (List('a', 'b'), List('c'), Nil),
      (List('a'), List('c'), List('b')),
      (List('c', 'a'), Nil, List('b')),
      (List('b', 'c', 'a'), Nil, Nil)
    )

    assert(resultado == esperado)
  }

  // Pruebas pequeñas (~100 elementos)
  test("Test 6: Prueba pequeña con 100 elementos") {
    val e = (List.fill(100)('a'), Nil, Nil)
    val movimientos = List(obj.Uno(50), obj.Dos(30), obj.Uno(-20))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  test("Test 7: Prueba pequeña con 100 elementos y movimientos alternados") {
    val e = (List.fill(100)('b'), Nil, Nil)
    val movimientos = List(obj.Uno(40), obj.Dos(50), obj.Uno(-10), obj.Dos(-40))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  // Pruebas medianas (~1000–5000 elementos)
  test("Test 8: Prueba mediana con 1000 elementos") {
    val e = (List.fill(1000)('c'), Nil, Nil)
    val movimientos = List(obj.Uno(500), obj.Dos(300), obj.Uno(-200))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  test("Test 9: Prueba mediana con 2000 elementos y movimientos alternados") {
    val e = (List.fill(2000)('d'), Nil, Nil)
    val movimientos = List(obj.Uno(1000), obj.Dos(800), obj.Uno(-500))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  // Pruebas grandes (~10000–50000 elementos)
  test("Test 10: Prueba grande con 10000 elementos") {
    val e = (List.fill(10000)('e'), Nil, Nil)
    val movimientos = List(obj.Uno(5000), obj.Dos(3000), obj.Uno(-2000))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  test("Test 11: Prueba grande con 20000 elementos y movimientos alternados") {
    val e = (List.fill(20000)('f'), Nil, Nil)
    val movimientos = List(obj.Uno(10000), obj.Dos(8000), obj.Uno(-5000))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }

  test("Test 12: Prueba muy grande con 50000 elementos y movimientos extremos") {
    val e = (List.fill(50000)('g'), Nil, Nil)
    val movimientos = List(obj.Uno(25000), obj.Dos(15000), obj.Uno(-10000))
    val resultado = obj.aplicarMovimientos(e, movimientos)
    assert(resultado.size > 0)  // Verifica que la función devuelve algo
  }
}
