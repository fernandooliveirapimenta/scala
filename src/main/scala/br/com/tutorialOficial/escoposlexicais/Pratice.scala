package br.com.tutorialOficial.escoposlexicais

object Pratice extends App{

  // Scope rules

  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  println(result)


}
