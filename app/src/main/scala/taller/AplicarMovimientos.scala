package taller

import scala.annotation.tailrec

class AplicarMovimientos {

  // Definiciones necesarias dentro de la clase
  sealed trait Movimiento
  case class Uno(n: Int) extends Movimiento
  case class Dos(n: Int) extends Movimiento

  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)
  type Maniobra = List[Movimiento]

  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = {
    val (principal, uno, dos) = e
    m match {
      case Uno(n) if n > 0 =>
        val (resto, mover) = principal.splitAt(principal.length - (n min principal.length))
        (resto, mover ++ uno, dos)
      case Uno(n) if n < 0 =>
        val (mover, resto) = uno.splitAt((-n) min uno.length)
        (mover ++ principal, resto, dos)
      case Dos(n) if n > 0 =>
        val (resto, mover) = principal.splitAt(principal.length - (n min principal.length))
        (resto, uno, mover ++ dos)
      case Dos(n) if n < 0 =>
        val (mover, resto) = dos.splitAt((-n) min dos.length)
        (mover ++ principal, uno, resto)
      case _ =>
        e
    }
  }

  def aplicarMovimientos(e: Estado, movs: Maniobra): List[Estado] = {
    @tailrec
    def aux(restantes: Maniobra, acumulado: List[Estado]): List[Estado] = {
      restantes match {
        case Nil => acumulado
        case mov :: ms =>
          val siguiente = aplicarMovimiento(acumulado.last, mov)
          aux(ms, acumulado :+ siguiente)
      }
    }

    aux(movs, List(e))
  }
}
