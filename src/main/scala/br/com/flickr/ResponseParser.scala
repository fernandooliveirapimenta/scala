package br.com.flickr

import br.com.flickr.model.Foto
import com.typesafe.config.Config

import scala.xml.{Elem, XML}

sealed trait ResponseParser {
  def parse(xmlStr: String): Either[FlickrError, Seq[Foto]]
}

final class XmlFlickrParser extends ResponseParser{

  import ResponseParser._

  override def parse(xmlStr: String): Either[FlickrError, Seq[Foto]] = {
    val xml = XML.loadString(xmlStr)

    (xml \\ "rsp" \ "@stat").text match {
      case "ok" => Right(processSuccess(xml))
      case `failStat` => Left(processFailure(xml))
      case _ => Left(FlickrUnknownError(unknownFlicrResp))
    }
  }

  def processSuccess(xml: Elem): Seq[Foto] =
    (xml \\ "photo").map { photoXml =>
      Foto(
        (photoXml \ "@id").text,
        (photoXml \ "@owner").text,
        (photoXml \ "@secret").text,
        (photoXml \ "@server").text,
        (photoXml \ "@farm").text.toInt,
        (photoXml \ "@title").text,
        flickrBoolean((photoXml \ "@ispublic").text),
        flickrBoolean((photoXml \ "@isfriend").text),
        flickrBoolean((photoXml \ "@isfamily").text)
      )
  }

  def processFailure(xml: Elem): FlickrError =
    (xml \\ "err").map { errXml =>
      FlickrKnownError(
        (errXml \ "@code").text.toInt,
        (errXml \ "@msg").text
      )
    }.headOption.getOrElse(
      FlickrUnknownError(errNotFound)
    )

}

final class JsonFlickrParser extends ResponseParser {
  override def parse(xmlStr: String): Either[FlickrError, Seq[Foto]] = ???
}


object ResponseParser {
  val okStat = "ok"
  val failStat = "fail"
  val unknownFlicrResp = "Could not parse Fickr response"
  val errNotFound = "Clud not parser Flickr error response"

  def flickrBoolean(rawAttribute: String): Boolean = rawAttribute.toInt match {
    case 1 => true
    case _ => false
  }

  def fromConfig(config: Config): ResponseParser = {
    val parser = config.getString("flickr.api.parser")
    parser match {
      case "xml" => new XmlFlickrParser
      case "json" => new JsonFlickrParser
      case _  => new XmlFlickrParser
    }
  }
}

sealed trait FlickrError
final case class FlickrKnownError(code: Int, msg: String) extends FlickrError
final case class FlickrUnknownError(msg: String) extends FlickrError
