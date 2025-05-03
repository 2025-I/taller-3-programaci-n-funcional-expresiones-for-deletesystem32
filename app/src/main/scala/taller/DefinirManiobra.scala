package taller

class DefinirManiobra {


  sealed trait Movimiento
  case class Uno(n: Int) extends Movimiento
  case class Dos(n: Int) extends Movimiento

  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)
  type Maniobra = List[Movimiento]


  def definirManiobra(t1: Tren, t2: Tren): Maniobra = {

    def moverHasta(trenActual: Tren, trenObjetivo: Tren): Maniobra = {
      def paso(state: Estado, objetivo: Tren, acumulado: Maniobra): Maniobra = objetivo match {
        case Nil => acumulado
        case x :: xs =>
          val (principal, uno, dos) = state


          if (principal.nonEmpty && principal.last == x) {
            val mov = Uno(1)
            val nuevoEstado = aplicarMovimiento(state, mov)
            val devolver = Uno(-1)
            val finalState = aplicarMovimiento(nuevoEstado, devolver)
            paso(finalState, xs, acumulado :+ mov :+ devolver)

          } else {

            val mov =
              if (principal.nonEmpty) {
                Uno(1)
              } else if (uno.nonEmpty && uno.head == x) {
                Uno(-1)
              } else if (dos.nonEmpty && dos.head == x) {
                Dos(-1)
              } else {

                Uno(1)
              }

            val nuevoEstado = aplicarMovimiento(state, mov)
            paso(nuevoEstado, objetivo, acumulado :+ mov)
          }
      }

      val estadoInicial: Estado = (trenActual, Nil, Nil)
      paso(estadoInicial, trenObjetivo, Nil)
    }

    moverHasta(t1, t2)
  }


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
}








