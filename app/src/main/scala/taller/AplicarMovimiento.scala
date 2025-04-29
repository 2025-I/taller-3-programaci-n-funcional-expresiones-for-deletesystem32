package taller

// Tipos requeridos por el taller

class AplicarMovimiento {


  trait Movimiento

  case class Uno(n: Int) extends Movimiento

  case class Dos(n: Int) extends Movimiento

  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren, Tren, Tren)

  // Función aplicarMovimiento como función de primer orden
  def aplicarMovimiento(e: Estado, m: Movimiento): Estado = {
    val (principal, uno, dos) = e

    val resultado = m match {
      case Uno(n) if n > 0 =>
        for {
          (quedar, mover) <- List(principal.splitAt((principal.length - n) max 0))
        } yield (quedar, uno ++ mover, dos)

      case Uno(n) if n < 0 =>
        for {
          (mover, quedar) <- List(uno.splitAt((-n) min uno.length))
        } yield (mover ++ principal, quedar, dos)

      case Dos(n) if n > 0 =>
        for {
          (quedar, mover) <- List(principal.splitAt((principal.length - n) max 0))
        } yield (quedar, uno, dos ++ mover)

      case Dos(n) if n < 0 =>
        for {
          (mover, quedar) <- List(dos.splitAt((-n) min dos.length))
        } yield (mover ++ principal, uno, quedar)

      case _ =>
        List(e)
    }

    resultado.head
  }
}
