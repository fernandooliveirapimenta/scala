package br.com.tutorialOficial.classesvscaseclasses

object Teory extends App{

  val aliceAccount = new BankAccount
  val bobAccount = new BankAccount
  println(aliceAccount == bobAccount)
  val c3 = Note("C", "Quarter", 3)
  println(c3.name)
  val cThree =Note("C", "Quarter", 3)
  println(c3 == cThree)




}

class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Unit =
    if(amount > 0) balance += amount
  def withdraw(amount: Int): Int =
    if(amount > 0 && amount <= balance) {
      balance -= amount
      balance
    } else throw new Error("insuficiants found")
}

case class Note(name: String, duration: String, octave: Int)