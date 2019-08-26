package br.com.tutorialOficial.structuringinformation

object Teory extends App{

 case class F (name: String)
 val f = F("ff")

 val c3 = Note("C", "Quarter", 3)

// println(c3.name)
// println(c3.duration)
// println(c3.octave)

 val symbol1: Symbol = Note("C", "Quarter",3)
 val symbol2: Symbol = Rest("whole")

  def symbolDuration(symbol: Symbol): String = symbol match {
   case Note(name, duration, octave) => name
   case Rest(duration) => duration
  }

  println(symbolDuration(symbol1))
 println(symbolDuration(symbol2))

 def unexhaustive(): Unit = {
  sealed trait Symbol
  case class Note(name: String, duration: String, octave: Int)
  extends Symbol
  case class Rest(duration: String)
    extends Symbol

  def nonExhaustiveDuration(symbol: Symbol): String =
   symbol match {
    case Rest(duration) => duration
   }
 }

}

sealed trait Symbol

case class  Note (
           name: String,
           duration: String,
           octave: Int
) extends Symbol

case class Rest(duration: String) extends
Symbol
