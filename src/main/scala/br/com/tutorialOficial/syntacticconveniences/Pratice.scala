package br.com.tutorialOficial.syntacticconveniences

object Pratice extends App{

  type Result = Either[String, (Int, Int)]

  def divide(dividend: Int, divisor: Int): Result =
    if(divisor == 0) {
      Left("Division by zero")
    } else {
      Right((dividend/divisor, dividend % divisor))
    }

//  println(divide(6,4))
//  println(divide(2,0))
  private val result: Result = divide(50,2)

//  println(result.foreach((f: (Int, Int)) => f._1 * 4))
    result.fold(
    (fa: String) => {
      println(fa)
    },
    (fb: (Int, Int)) => {
      println(fb)
    })

}
