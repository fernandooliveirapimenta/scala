package br.com.basico

import org.scalatest.FunSuite

class MediaIdadeTest extends FunSuite{

  test("media de idade em uma sala") {
    val idade = List(10, 10, 10)

    assert(idade.sum./(idade.size) === 10)

  }

}
