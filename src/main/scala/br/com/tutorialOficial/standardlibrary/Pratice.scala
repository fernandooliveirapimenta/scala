package br.com.tutorialOficial.standardlibrary

object Pratice extends App{

  def triple(x: Int): Int = 3 * x

  def tripleEither(x: Either[String, Int]): Either[String, Int] =
    x.right.map(triple)

  println(tripleEither(Right(1)))
  println(tripleEither(Left("not a number")))

}
