package br.com.tutorialOficial.tailrecursion

import scala.annotation.tailrec

object Pratice extends App{


  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if(x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)

  }

  println(factorial(3))
  println(factorial(4))

}
