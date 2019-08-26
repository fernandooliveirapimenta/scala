package br.com.tutorialOficial.tailrecursion

import scala.annotation.tailrec

object Teory extends App{

  def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)

  println(gcd(14, 21))
  println(14 % 21)

  def factorial(n: Int): Int =
    if ( n == 0) 1
    else n * factorial(n -1)

  println(factorial(4))

  println(4 * (3 * ( 2 * (1 * 1))))

  //tail recursion

  @tailrec
  def $gcd(a: Int, b: Int): Int =
    if(b == 0) a else $gcd(b, a % b)

  println($gcd(14, 21))



}
