package br.com.tutorialOficial.imperativeprogramming

object Teory extends App{

  def iterate(n: Int, f: Int => Int, x: Int): Int =
    if(n == 0) x
    else iterate(n-1,f,f(x))

  def square(x: Int): Int = x * x


  println(iterate(1, square, 3))

  var count: Int = 111


  count += 1

  println(count)

  val account = new BandAccount

  account deposit 50
  account.withdraw(20)
  account.withdraw(20)


  val x = new BandAccount
  val y = new BandAccount



  val hh = new BandAccount
  val hy = hh

  hy.deposit(20)
  hy.deposit(10)

  hh.withdraw(30)

  x.deposit(30)
  x withdraw 20
//  y.withdraw(20)

  def power(x: Double, exp: Int): Double = {
    var r: Double = 1.0
    var i: Int = exp

    while (i > 0) {
      r= r * x; i = i -1
    }

    r
  }

  println(power(3.0, 3))
}

class BandAccount {

  private var balance = 0

  def deposit(amount: Int): Int = {
    if(amount > 0) balance += amount
    balance
  }

  def withdraw(amount: Int): Int =
    if(0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    }
    else throw new Error("insufficient founds")
}

object ForLoops extends App{

  for(i <- 1 to 10) {
    println(i)
  }

  for(variavel <- 1 until 3) {
    println(variavel)
  }


  for (i <- 1.to(10)) {
    println(i)
  }

  println()
  println()
  println()

  for (i <- 1 to 1; j <- "fernando")
    println(s"$j $i")

  for(i <- 1 until 3; j <- "abc") println(s"$i $j")

  (1 until 3) foreach (i => "abc" foreach( j => println(s"$i $j")))

}
