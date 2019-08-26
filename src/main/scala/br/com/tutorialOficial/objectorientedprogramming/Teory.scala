package br.com.tutorialOficial.objectorientedprogramming


object Teory extends App{

//  def addRationalNumerator(n1: Int, d1: Int, n2: Int, d2: Int): Int

  println(new Rational(3,3))

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numer * s.denom + s.numer * r.denom,
      r.denom * s.denom
    )

  def makeString(r: Rational) = r.numer + "/" + r.denom

  println(makeString(addRational(new Rational(1,2), new Rational(2,3))))

  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)

  println(x.+(y).*(z))

  new Rational(3)


  println(Empty contains 1)
  println(new NonEmpty(7, Empty, Empty).contains(7))

  val d = new Square
  println( d.surface)


}

class Rational(x: Int, y: Int) {

  require(y > 0, "denominator mult be positive")

  def this(x: Int) = this(x,1)

  private val g = gcd(x, y)

  def numer: Int = x / g
  def denom: Int = y / g


  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a
    else gcd(b, a%b)

  def + (r: Rational) =
    new Rational(
      numer * r.denom + r.numer * denom,
      denom * r.denom
  )

  def * (r: Rational) =
    new Rational(
      numer * r.denom * r.numer * denom,
      denom * r.denom
  )

  def - (that: Rational): Boolean
  = numer * that.denom < that.numer * denom

  def max(that: Rational): Rational
  = if(this.-(that)) that
    else this

  override def toString: String = s"$numer / $denom"

}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

class Empty extends IntSet {

  override def incl(x: Int): IntSet =
    new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false
}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}

class NonEmpty(elem: Int,
               lef: IntSet,
               right: IntSet) extends IntSet{

  override def incl(x: Int): IntSet =
    if(x < elem) new NonEmpty(elem, lef incl x, right)
    else if(x > elem) new NonEmpty(elem, lef, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if(x < elem) lef contains x
    else if (x > elem) right.contains(x)
    else true

}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo: Int = 2
  def bar = 3
}

trait Planar {
  def height: Int
  def width: Int
  def surface: Int = height * width
}

abstract class Shape {
  def show(): Unit = println("shape")
}

class Square extends Shape with Planar {
  override def height: Int = 20
  override def width: Int = 20
}
