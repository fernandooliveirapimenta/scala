package br.com.tutorialOficial.definitionsandevaluation

object Teory extends App{

  println(3.14159 * 10 * 10)

  val radius = 10
  val pi = 3.14159

  println(pi * radius * radius)

  def square(x: Double) = x * x

  println(square(3))
  println(square(5))

  def area(radius: Double) = 3.14159 * square(radius)

  println(area(10))

  def sumOfSquare(x: Double, y: Double)
  = square(x) + square(y)

  println(sumOfSquare(10, 20))

  val x = 2
  val y = square(x)
  println(y)

  def loop: Int = loop

  def d = loop

//  val infinitLoop = loop



}
