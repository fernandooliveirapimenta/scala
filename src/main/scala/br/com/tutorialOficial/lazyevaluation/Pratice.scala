package br.com.tutorialOficial.lazyevaluation

object Pratice extends App{

  var rec = 0
  def streamRange(lo: Int, hi: Int): Stream[Int] = {
    rec = rec + 1
    if(lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi))
  }

  println(streamRange(1, 10).take(3).toList)


  val builder = new StringBuilder

  val x: Int = { builder += 'x'; 1 }
  lazy val y: Int = { builder += 'y'; 2 }
  def z: Int = { builder += 'z'; 3 }

  z + y + x + z + y + x


  println(builder.result)

}
