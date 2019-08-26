package br.com.tutorialOficial.loopsfuncionais

object Teory extends App{

  def abs(x: Double) = if (x >= 0)
    x else -x


  println(abs(5))
  println(abs(-5))

  println(s"${true} ${false} Constants")
  val b = true
  println(s"${!b} Negation")

  println(s"${b && b} Conjunction")
  println(s"${b ||  b} Disconjunction")

  val e = 30

  println(s"${ e <= e}")
  println(s"${ e >= e}")
  println(s"${ e < e}")
  println(s"${ e > e}")
  println(s"${ e == e}")

  def sqrtIter(guess: Double, x: Double): Double
  = if(isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double)
  = (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double)
  = abs(guess * guess - x) < 0.001

  def sqrt(x: Double) = sqrtIter(1.0, x)

  println(sqrt(16.0))


}
