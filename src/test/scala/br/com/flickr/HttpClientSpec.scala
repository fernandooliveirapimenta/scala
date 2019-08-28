package br.com.flickr

import br.com.flickr.HttpClient.{GetError, GetResponse}
import org.specs2.mutable.Specification

class HttpClientSpec extends Specification{

  "the http client" should {
    "respod with a body" in {
      new HttpClient().get("https://httpbin.org/get") must beRight[GetResponse]
    }

    "responde with an error" in {
      new HttpClient().get("bla-bla") must beLeft[GetError]
    }
  }

}
