package br.com.tutorialOficial.typeclass

object Pratice extends App{


  val compareRationals: (Rational,  Rational) => Int = null

  implicit val rationalOrder: Ordering[Rational]
  = (x: Rational, y: Rational) => compareRationals(x, y)

  val half = new Rational(1,2)
  val third = new Rational(1,3)
  val fourth = new Rational(1,4)
  val rationals = List(third, half, fourth)
}

class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a
    else gcd(b, a%b)

  private val g = gcd(x,y)

  lazy val numver: Int = x / g
  lazy val denom: Int  = y / g
}
