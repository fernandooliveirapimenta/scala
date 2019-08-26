package br.com.tutorialOficial.higherorderfunctions

import scala.annotation.tailrec

object Pratice extends App{

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      if(x > b) acc
      else loop(x + 1, acc + f(x))
    }

    loop(a, 0)
  }

  println(sum(x => x, 1, 10))

}
