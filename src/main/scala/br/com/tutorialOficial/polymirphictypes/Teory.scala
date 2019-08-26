package br.com.tutorialOficial.polymirphictypes

object Teory extends App{

  def singleton[A](elem: A) =
    new NonEmpty[A](elem, new Empty[A], new Empty[A])

  val e: Set[Boolean] = singleton[Boolean](false)
  val i: Set[Double] = singleton[Double](3.3)

  println(e)
  println(i)

  private val value: NonEmpty[Int] = singleton(1)


  def selection[A <: Animal](a1: A, a2: A): A
  = if(a1.fitness > a2.fitness) a1 else  a2

  val kkf = new Animal {
    override def fitness: Int = 49

    override def toString: String = "oo"
  }

  println(selection(kkf, kkf))

  val zebras: Array[Zebra] = Array(new Zebra {
    override def zebraCount: Int = ???

    override def fitness: Int = ???
  })


}


abstract class IntSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

abstract class Set[A] {
  def incl(a: A): Set[A]
  def contains(a: A): Boolean
}

class Empty[A] extends Set[A] {
  override def incl(a: A): Set[A] = ???

  override def contains(a: A): Boolean = ???
}

class NonEmpty[A](elem: A, left: Set[A], right: Set[A])
extends Set[A] {
  override def incl(a: A): Set[A] = ???

  override def contains(a: A): Boolean = false
}

trait Field[A] {
  def get: A
}

trait Animal {
  def fitness: Int
}

trait Reptile extends Animal
trait Mammal extends Animal
trait Zebra extends Mammal {
  def zebraCount: Int
}

trait Giraffe extends Mammal

trait Function1[-T, +U] {
  def apply(x: T): U
}

