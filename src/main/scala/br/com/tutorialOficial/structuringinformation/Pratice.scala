package br.com.tutorialOficial.structuringinformation

object Pratice extends App{

  case class Note(name: String)

  val n1 = Note("Fernando")
  val n2 = Note("ernando")

  println(n1 == n2)

}

object ex2 extends App {
  sealed trait Duration
  case object Whole extends Duration
  case object Half extends Duration
  case object Quarter extends Duration

  def fractionOfWhoe(duration: Duration)
  : Double = duration match {
    case Whole => 1.0
    case Half => 0.5
    case Quarter => 0.25
  }

  println(fractionOfWhoe(Half))
  println(fractionOfWhoe(Quarter))
}
