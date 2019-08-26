package br.com.tutorialOficial.imperativeprogramming

object Pratice extends  App{

  def factorial(n: Int): Int = {
    var result = 1
    var i = 1

    while (i <= n) {
      result *= i
      i = i + 1
    }

    result
  }

  println(factorial(2))
  println(factorial(3))
  println(factorial(4))
  println(factorial(5))
}
