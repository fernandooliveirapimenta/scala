package br.com.livro.flickr

import scala.xml.XML

object ParseandoXml extends App{

  val fotos =
  <fotos>
    <foto>uma foto</foto>
    <foto>outra fot</foto>
    <foto>
    <foto>dgdg</foto>
    </foto>
  </fotos>

  println(fotos)

  println()
  println()
  println()

  println(fotos \ "foto")
  println()
  println()
  println()
  println(fotos \\ "foto")

  println()
  println()
  println()

  val txt = fotos.\("foto").map(_.text)
  println(txt)

  val respXml =

    <rsp stat="ok">
      <photos page="1" pages="5573" perpage="10" total="55728">
        <photo id="14406205613" owner="59634982@N05" secret="1073a5b91
                7" server="3871" farm="4"
               title="La Scala" ispublic="1" isfriend="0" isfamily="0"/>
        <photo id="14382256984" owner="34527570@N05" secret="c77830c9f
                4" server="2900" farm="3"
               title="Vertigo" ispublic="1" isfriend="0" isfamily="0"/>
        <photo id="14194771350" owner="108099607@N06" secret="72d20104 b1" server="3926" farm="4"
               title="IMG_0228" ispublic="1" isfriend="0" isfamily="0"/>
        <photo id="14351480646" owner="36117086@N05" secret="96581e18f 5" server="3857" farm="4"
               title="Samsung Motors 3" ispublic="1" isfriend="0" isfamily="0"/>
        <photo id="14371242601" owner="36117086@N05" secret="701e103e5 8" server="5543" farm="6"
               title="Samsung Motors 3" ispublic="1" isfriend="0" isfamily="0"/>
      </photos>
    </rsp>



   val parseado = respXml \\ "photo" map {
     p => Foto(
       (p \ "@id" text).toLong,
       p \ "@owner" text,
       p \ "@title" text,
       (p \ "@farm" text).toInt,
     )
   }

  println(parseado)






  }
