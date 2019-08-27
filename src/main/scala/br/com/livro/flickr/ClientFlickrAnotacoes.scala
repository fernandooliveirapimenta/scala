package br.com.livro.flickr

import java.util.Properties

object ClientFlickrAnotacoes extends App{

  val FOTOS = 1
  val VIDEOS = 2
  val TODAS = 3

  val media = FOTOS

  media match {
    case FOTOS => println("fotos")
    case VIDEOS => println("videos")
    case _ => println("TODOS")
  }

  val props = new Properties
  props.load(getClass.getClassLoader
    .getResourceAsStream("config.properties"))

  val apiKey = props.getProperty("flickr.api.key")

  val secret = "caa7d6fda9fd3997"
  val method = "flickr.photos.search"
  val tags = "scala"

  val url
  = s"https://api.flickr.com/services/rest/" +
    s"?method=$method&api_key=$apiKey&tags=$tags"

  scala.io.Source.fromURL(url).getLines().foreach(println)

  private val caller = new FlickrCaller(apiKey)

//  println(caller.api)
//  println(caller.buscaFotos("scala"))
//  println(caller.buscaFotos(userId = "userId"))

//  val fotos = MediaCase("fotos")
//  val videos = MediaCase("videos")
//  val all = MediaCase("all")
//
//  println(fotos == videos)
//  println(videos)
//
//  val copia = fotos.copy(value = "videos")
}

//class FlickrCaller(val api: String) {
//
//  def buscaFotos(tag: String = "",
//                 userId: String = ""): Seq[Foto] = ???
//
//}

case class MediaCase(value: String)

case object MediaCaseObject {

}


//abstract class Media(val value: String)
//object Fotos extends Media("fotos")
//object Videos extends Media("videos")
//object Todas extends Media("all")

object PatternMatching extends App{

  val midia = 1

  val texto = midia match {
    case 1 => "fotos"
    case 2 => "videos"
    case _  => "todos"
  }

  val resultado = midia match {
    case 1 => "fotos"
    case 2 => "videos"
    case _ => -1
  }


  println(texto)
  println(resultado)

  val foto = Foto(33, "jcranky", "oi", 3);
  val foto2 = Foto(33, "jcranky", "oi", 3);
  val foto3 = Foto(33, "jcranky", "oi", 3);

  val fotos = List(foto,foto2,foto3)

  println(fotos(1))
  println(fotos.apply(0))

  val teste = foto match {
    case  Foto(_, "jcranky", _, _ ) => true
    case _ => false
  }

  val teste2 = foto match {
    case  Foto(_, "jcranky", _, _ ) if 7 == 7 => true
    case _ => false
  }
 println(teste)

//  foto.copy(owner = "vic") match {
//    case Foto(_, "jcranky", _, _) => println("foto jcranky")
//    case f => println(s"outra: $f")
//  }

  val dobro: Int = new IntDobrado(10).dobrado
  println(dobro)
}

object ApiScala extends App{

  //Option, some, none

}

class IntDobrado(val x: Int) extends AnyVal {
  def dobrado: Int = x * 2
}