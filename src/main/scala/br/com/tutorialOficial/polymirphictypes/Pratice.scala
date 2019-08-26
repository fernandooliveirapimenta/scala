package br.com.tutorialOficial.polymirphictypes

object Pratice extends App{

  def size[A](xs: List[A]): Int =
    xs match {
      case Nil => 0
      case y :: gg => xs.size
    }

  println(size(Nil))
  println(size(List(1,2)))
  println(size(List("a","b","c")) )
}
