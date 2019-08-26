package br.com.tutorialOficial.syntacticconveniences

object Teory extends App{

}


object StringInterpolation extends App {

  def greet(name: String): String =
    s"Hello, ${name.toUpperCase}"


  println(greet("fefe"))

  def triple(i: Int, s: String):(Int, String, String) =
    (i,s,s)

  def pair(i: Int, s: String):(Int, String) =
    (i,s)

  println(triple(38,"dkgsg"))
  println(pair(33,"dksgjdks"))

  val is: (Int, String) = (42, "foo")
  println(is._1)
  println(is._2)

  val (i, s) = is
  println(i)
  println(s)

  val tres: (String, String, String) = ("fernando","oliveira","pimenta")
  println(s"${tres._1} ${tres._2} ${tres._3}")
}


object FunctionObject extends App {

  class AnonFun extends Function1[Int, Int] {
    override def apply(x: Int): Int = x * x
  }

  val fun = new Function1[Int, Int] {
      override def apply(x: Int): Int = x * x
    }

  val f = (x: Int) => x * x

  def test(x: Int): Int = fun.apply(x)
  def test2(x: Int): Int = fun.apply(x)

  println(test(50))
  println(test2(50))
  println(f(7))

  def average(x: Int, xs: Int*): Double =
    (x :: xs.to[List]).sum.toDouble / (xs.size + 1)

  def average2( xs: Int*): Double =
    xs.to[List].sum.toDouble / xs.size
  println(average(1))
  println(average(1,2))
  println(average2(1,2,3))

}

trait Function1[A, B] {
  def apply(x: A): B
}
