package br.com.flickr

import com.typesafe.config.ConfigFactory

object Main extends App{

  val config = ConfigFactory.load()
  val flickrClient = FlickrClient.fromConfig(config)

  flickrClient.buscaFotos(List("scala")) match {
    case Right(fotos) => fotos foreach println
    case Left(err) => println(s"Erro getting fotos: ${err.msg}")
  }

}
