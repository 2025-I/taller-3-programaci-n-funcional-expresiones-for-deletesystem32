import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class DefinirManiobraTest {

  def probar(resultado: List[Int], esperado: List[Int]): Unit = {
    assertEquals(esperado, resultado)
  }

  @Test
  def pruebaJuguete(): Unit = {
    val resultado = (1 to 10).toList.reverse
    val esperado = (10 to 1 by -1).toList
    probar(resultado, esperado)
  }

  @Test
  def pruebaPequena(): Unit = {
    val resultado = (1 to 100).toList.reverse
    val esperado = (100 to 1 by -1).toList
    probar(resultado, esperado)
  }

  @Test
  def pruebaMediana(): Unit = {
    val resultado = (1 to 500).toList.reverse
    val esperado = (500 to 1 by -1).toList
    probar(resultado, esperado)
  }

  @Test
  def pruebaGrande(): Unit = {
    val resultado = (1 to 1000).toList.reverse
    val esperado = (1000 to 1 by -1).toList
    probar(resultado, esperado)
  }
}





