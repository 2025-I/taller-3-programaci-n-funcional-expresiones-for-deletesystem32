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
    def aux(e: Estado, objetivo: Tren, movimientos: Maniobra): Maniobra = {
      val (principal, uno, dos) = e

      if (principal == objetivo && uno.isEmpty && dos.isEmpty) movimientos
      else {
        objetivo match {
          case Nil =>
            if (principal.nonEmpty) aux((principal.tail, uno, dos), objetivo, movimientos :+ Uno(1))
            else movimientos

          case x :: xs =>
            if (principal.headOption.contains(x)) {
              aux((principal.tail, uno, dos), xs, movimientos :+ Uno(1))
            } else if (uno.contains(x)) {
              aux((x :: principal, uno.filterNot(_ == x), dos), objetivo, movimientos :+ Uno(-1))
            } else if (dos.contains(x)) {
              aux((x :: principal, uno, dos.filterNot(_ == x)), objetivo, movimientos :+ Dos(-1))
            } else {
              if (uno.size <= dos.size)
                aux((principal.tail, principal.head :: uno, dos), objetivo, movimientos :+ Uno(1))
              else
                aux((principal.tail, uno, principal.head :: dos), objetivo, movimientos :+ Dos(1))
            }
        }
      }
    }

    aux((t1, Nil, Nil), t2, Nil)
  }
}