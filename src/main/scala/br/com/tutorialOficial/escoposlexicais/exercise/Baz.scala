package br.com.tutorialOficial.escoposlexicais.exercise

import Bar.x
object Baz {

  val y: Int = x + Foo.x

  def main(args: Array[String]): Unit = {

    println(Baz.y)

  }

}
