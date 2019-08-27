package br.com.livro.flickr

import java.util.Properties

import scala.util.control.NonFatal

object ClientFlickr extends App{

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

  println(Videos)

  var foto: Foto = _

  val listaVazia = List[Nothing]()
  var lista: List[String] = listaVazia

  val x: Unit = ()

  def pr: Unit = None

  val t = new FlickrCaller("")

  try {
    t.buscaFotos()
  } catch {
    case e: Throwable => println("erro ao buscar fotos")
    case e: Exception => println("indefinida")
    case NonFatal(e) => println("alguma outra")
  }

}

class FlickrCaller(val api: String) {

  def buscaFotos(tag: Option[String] = None,
                 userId: Option[String] = Some("")): Seq[Foto] =
    throw new NotImplementedError

}

class Media(value: String)

case object Fotos extends Media("fotos")
case object Videos extends Media("videos")
case object Todas extends Media("all")

