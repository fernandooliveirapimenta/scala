package br.com.livro.flickr

object ImplicitsTreino extends App {

  //  implicit def toPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)
  implicit def newPrintableFoto(foto: Foto): PrintableFoto = new PrintableFoto(foto)

  println("99".toInt)

  val f = Foto(33, "dd", "d", 8)

  f.print()

  implicit val qualquer: String = "gg"
  implicit val inteiro: Int = 99

  //  implicit class PrintableFoto(foto: Foto) {
  //    def print(): Unit = println("printando foto")
  //  }

  def buscaComImplicits(tag: Option[String])
                       (implicit token: String, test: Int): Seq[String] = {
    println(token)
    println(test)

    List()
  }

  buscaComImplicits(Some("dkgjkdg"))

  val listString = List("f", "d")
  val listFefe = List(Fefe(33), Fefe(20))


  implicit object FefeNumeric extends FefeNumeric
  println(listFefe.sum)

}


case class Fefe(id: Int) {

}

class FefeNumeric extends Numeric[Fefe] {
  override def plus(x: Fefe, y: Fefe): Fefe = x.copy(id = x.id + y.id)

  override def fromInt(x: Int): Fefe = Fefe(x)

  override def minus(x: Fefe, y: Fefe): Fefe = ???

  override def times(x: Fefe, y: Fefe): Fefe = ???

  override def negate(x: Fefe): Fefe = ???


  override def toInt(x: Fefe): Int = ???

  override def toLong(x: Fefe): Long = ???

  override def toFloat(x: Fefe): Float = ???

  override def toDouble(x: Fefe): Double = ???

  override def compare(x: Fefe, y: Fefe): Int = ???
}

class PrintableFoto(foto: Foto) {
  def print(): Unit = println("printando foto")
}




