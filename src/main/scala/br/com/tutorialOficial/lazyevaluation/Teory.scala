package br.com.tutorialOficial.lazyevaluation

object Teory extends App{

  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))

  def streamRange(lo: Int, hi: Int): Stream[Int]
  = if(lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))

  private val ints: Stream[Int] = streamRange(1, 10)

  ints #:: streamRange(1,2)

  def listRange(lo: Int, hi: Int): List[Int] =
    if(lo >= hi) Nil
    else lo :: listRange(lo + 1, hi)

}


