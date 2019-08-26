package br.com.tutorialOficial.loopsfuncionais

object Pratice extends App{

  def factorial(n: Int): Int = {
    if(n == 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(3))
  println(factorial(4))


}
