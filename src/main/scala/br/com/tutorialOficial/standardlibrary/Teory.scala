package br.com.tutorialOficial.standardlibrary

import scala.util.{Failure, Success, Try}

object Teory extends App{

}

object Lists extends App {

  val fruit: List[String] = List("apples", "oranges", "pears")
  val nums: List[Int] = List(1, 2, 3, 4)
  val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 0, 1))
  val empty: List[String] = List()

  println(nums)


}

object MoreLists extends App {
  val fruit = "apples" :: ("orange" :: ("pears" :: Nil))
  val nums = 1 :: (2:: (3 :: ( 4:: Nil)))
  println(fruit)
  println(nums)
  val nums2 = 1 :: 2 :: 3 :: 4 :: Nil
  print(nums2)
  val nums3 = Nil.::(4).::(3).::(2).::(1)
}

object ManipulatingLists extends App {
  val nums3 = Nil.::(4).::(3).::(2).::(1)
  nums3 match {
    case  1 :: 2 :: xs => 1
    case x :: Nil => 2
    case List(x) => 3
    case List() => 4
  }

//  def insertionSort(xs: List[Int]): List[Int] =
//    xs match {
//      case List() => List()
//      case y :: ys => insert(y, insertionSort(ys))
//  }

//  val cond: (Int, Int) => Boolean
//
//  def insert(x: Int, xs: List[Int]): List[Int]
//  = xs match {
//    case List() => x :: xs
//    case y :: ys =>
//      if(cond(x, y)) x :: y :: ys
//      else y :: insert(x, ys)
//  }

  println(List(1,2,3).map(x => x + 1) == List(2, 3 ,4))
  println(List(33,44,55,34).filter(t => t > 33))
  println(List(1,2,3).filter(x => x % 2 == 0) == List(2))
  val xs = List(1,2,3).flatMap{
    x => List(x, 2*x, 3*x)
  }
  println(xs == List(1, 2, 3, 2, 4, 6, 3, 6, 9) )

}

object ValoresOpcionais extends App {

  def sqrt(x: Double): Option[Double]
  = if( x < 0) None
  else Some(x)

  def foo(x: Double): String =
    sqrt(x) match {
      case None => "no result"
      case Some(y) => y.toString
  }

  println(foo(-3))
  println(foo(3))

  println(Some(1).map(x => x + 1))
  println(None.map((x: Int) => x + 1))

  println(Some(1).filter(x => x % 2 == 0))
  println(Some(2).filter(x => x % 2 == 0))


}

object TratamentoErros extends App {

  def sqrt(x: Double): Try[Double] =
    if(x < 0) Failure(new IllegalArgumentException("x must be positive"))
    else Success(50.0)

  println(sqrt(-33))
  println(sqrt(33).get)

  def metodo(x: Double): Either[String, Double] =
    if(x< 0) Left("be positive")
    else Right(x)

  println(Right(1).map(x => x + 1))
  println(Left("foo").map((x: Int) => x + 1))
  println(Right(1).filterOrElse(x => x % 2 == 0, "Odd value"))

}