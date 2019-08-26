package br.com.basico

import org.scalatest.FunSuite


class CubeCalculatorTest extends FunSuite{

  test("cube") {
    assert(CubeCalculator.cube(3) === 27)
  }

  test("cubeZero") {
    assert(CubeCalculator.cube(0) == 0)
  }

}
