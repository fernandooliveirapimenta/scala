package br.com.tutorialOficial.classesvscaseclasses

object Pratice extends App{

  val c3 = NoteC("C", "Quarter", 3)
  println(c3 toString)

  val d = NoteC("D", "Quarter", 3)
  println(c3.equals(d))

  val c4 = c3.copy(octave = 4)
  println(c4.toString)
}


class NoteC(_name: String,
           _duration: String,
           _octave: Int) extends Serializable {

  val name: String = _name
  val duration: String = _duration
  val octave: Int = _octave

  def canEqual(other: Any): Boolean = other.isInstanceOf[NoteC]

  override def equals(other: Any): Boolean = other match {
    case that: NoteC =>
      (that canEqual this) &&
        name == that.name &&
        duration == that.duration &&
        octave == that.octave
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, duration, octave)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString: String = s"Note($name,$duration,$octave)"

  def copy(name: String = this.name,
           duration: String = this.duration,
           octave: Int = this.octave): NoteC =
    new NoteC(name, duration, octave)
}

object NoteC {

  def apply(name: String, duration: String, octave: Int): NoteC =
  new NoteC(name, duration, octave)

  def unapply(note: NoteC): Option[(String,String,Int)] =
    if(note eq null) None
    else Some((note.name, note.duration,note.octave))

}