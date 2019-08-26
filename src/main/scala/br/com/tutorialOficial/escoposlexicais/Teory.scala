package br.com.tutorialOficial.escoposlexicais

object Teory extends App{

  //Nested Functions

  def sqrt(x: Double): Double
  = {

    def sqrtIter( guess: Double, x: Double) : Double
    = if(isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double)
    = (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) : Boolean
    = abs(square(guess) - x) < 0.001

    sqrtIter(1.0 , x)
  }

  def square(d: Double) = d * d
  def abs(d: Double) = if(d>0) d else -d

  println(sqrt(16))


  // blocks in scala

  {
    val x = 3
    x * x
  }

  val x = 50


  // Lexical scoping

  def sqrtMelhor(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if(isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(d: Double) =
    abs(square(d) - x) < 0.001

    sqrtIter(1.0)
  }


  println(sqrtMelhor(16))


  //semicolon

  val open = 1;

  val y = open + 1;  y * y

  println(y)

  val dd: scala.Int = 3



}
