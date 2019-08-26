package br.com.tutorialOficial.definitionsandevaluation

object Pratice {

  def main(args: Array[String]): Unit = {

    def triangleArea(base: Double,
                     heig: Double) =
      base * heig / 2

    println(triangleArea(3, 4))
    println(triangleArea(5, 6))

  }

}
