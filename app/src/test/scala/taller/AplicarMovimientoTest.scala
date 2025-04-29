package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AplicarMovimientoTest extends AnyFunSuite {
  // Suponiendo que Movimiento es un trait definido en otro lugar
  val objAplicarMovimiento = new AplicarMovimiento()

  val Movimiento: objAplicarMovimiento.Movimiento = objAplicarMovimiento.Uno(2)
  val Movimiento2: objAplicarMovimiento.Movimiento = objAplicarMovimiento.Dos(3)

  // Pruebas de juguete: tamaño de listas 10 vagones y 10 movimientos

  test("Test 1.1: Movimiento Uno(2) desde principal a uno (10 vagones)") {
    val e1 = (List.fill(10)('a'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, Movimiento)
    assert(e2 == (List.fill(8)('a'), List.fill(2)('a'), Nil))
  }

  test("Test 1.2: Movimiento Dos(3) desde principal a dos (10 vagones)") {
    val e1 = (List.fill(10)('c'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(3))
    assert(e2 == (List.fill(7)('c'), Nil, List.fill(3)('c')))
  }

  // Pruebas pequeñas: tamaño de listas 100 vagones y movimientos

  test("Test 2.1: Movimiento Uno(10) desde principal a uno (100 vagones)") {
    val e1 = (List.fill(100)('b'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Uno(10))
    assert(e2 == (List.fill(90)('b'), List.fill(10)('b'), Nil))
  }


  test("Test 2.2: Movimiento Dos(50) desde principal a dos (100 vagones)") {
    val e1 = (List.fill(100)('z'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(50))
    assert(e2 == (List.fill(50)('z'), Nil, List.fill(50)('z')))
  }

  // Pruebas medianas: tamaño de listas 500 vagones y movimientos

  test("Test 3.1: Movimiento Uno(100) desde principal a uno (500 vagones)") {
    val e1 = (List.fill(500)('c'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Uno(100))
    assert(e2 == (List.fill(400)('c'), List.fill(100)('c'), Nil))
  }

  test("Test 3.2: Movimiento Dos(200) desde principal a dos (500 vagones)") {
    val e1 = (List.fill(500)('a'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(200))
    assert(e2 == (List.fill(300)('a'), Nil, List.fill(200)('a')))
  }


  // Pruebas grandes: tamaño de listas 1000 vagones y movimientos

  test("Test 4.1: Movimiento Uno(200) desde principal a uno (1000 vagones)") {
    val e1 = (List.fill(1000)('d'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Uno(200))
    assert(e2 == (List.fill(800)('d'), List.fill(200)('d'), Nil))
  }

  test("Test 4.2: Movimiento Dos(500) desde principal a dos (1000 vagones)") {
    val e1 = (List.fill(1000)('e'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(500))
    assert(e2 == (List.fill(500)('e'), Nil, List.fill(500)('e')))
  }

  // Pruebas muy grandes: tamaño de listas 2000 vagones y movimientos

  test("Test 5.1: Movimiento Dos(500) desde principal a dos (2000 vagones)") {
    val e1 = (List.fill(2000)('h'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(500))
    assert(e2 == (List.fill(1500)('h'), Nil, List.fill(500)('h')))
  }

  test("Test 5.2: Movimiento Uno(1000) desde principal a uno (2000 vagones)") {
    val e1 = (List.fill(2000)('i'), Nil, Nil)
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Uno(1000))
    assert(e2 == (List.fill(1000)('i'), List.fill(1000)('i'), Nil))
  }

  test("Test 5.3: Movimiento Dos(-1000) desde dos a principal (2000 vagones)") {
    val e1 = (Nil, Nil, List.fill(2000)('j'))
    val e2 = objAplicarMovimiento.aplicarMovimiento(e1, objAplicarMovimiento.Dos(-1000))
    assert(e2 == (List.fill(1000)('j'), Nil, List.fill(1000)('j')))
  }
}
