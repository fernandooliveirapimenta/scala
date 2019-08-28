package br.com.flickr

import scala.util.control.NonFatal

class HttpClient {

  import HttpClient._

  def get(url: String): Either[GetError, GetResponse] = try {
    val body = scala.io.Source.fromURL(url).getLines().mkString("\n")
    Right(GetResponse(200, body))
  } catch {
    case NonFatal(e) => Left(GetError(e.getMessage))
  }

}

object HttpClient {
  case class GetError(msg: String)
  case class GetResponse(code: Int, body: String)

  def fromConfig(): HttpClient = new HttpClient()
}
