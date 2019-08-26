package br.com.tutorialOficial.higherorderfunctions

import java.time.LocalDate

object Teory extends App{

 def sumInts(a: Int, b: Int): Int =
  if(a > b) 0
  else a + sumInts(a+1, b)

 def cube(x: Int): Int = x * x * x
 def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0
  else cube(a) + sumCubes(a + 1, b)


 def factorial(a: Int): Int =
  if(a == 1) a
  else a * factorial(a - 1)


  println(sumInts(1, 4))
 println(sumCubes(4, 10))

 def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a+1, b)


 def id(x: Int): Int = x
 def sumInts2(a: Int, b: Int) = sum(id, a, b)
 def sumCubes2(a: Int, b: Int) = sum(cube, a, b)
 def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

 println(sumInts2(1, 3))

 val str = "abc"; println(str)
  println("abc")

 (x: Int) =>  x * x * x
 (x: Int, y: Int) => x + y


 def sumFactorials3(a: Int, b: Int)= sum( x => x, a, b )
  def sumCubes3(a: Int, b: Int) = sum(x => x * x * x, a, b)

 println(sumFactorials3(2, 3))

}
