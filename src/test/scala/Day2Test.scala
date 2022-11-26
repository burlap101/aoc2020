package com.github.burlap101

import com.github.burlap101.Day2.{PasswordLine, validLine, validLine2}
import org.scalatest.funsuite.AnyFunSuite

class Day2Test extends AnyFunSuite {
  test("Day2.ingestFile") {
    assert(Day2.ingestFile("input/day2/test.txt") match {
      case _: List[PasswordLine] => true
      case _ => false
    })
  }

  test("Day2.count") {
    assert(Day2.ingestFile("input/day2/test.txt").count(p => validLine(p)) == 2)
  }

  test("Day2.countPart2") {
    assert(Day2.ingestFile("input/day2/test.txt").count(p => validLine2(p)) == 1)
  }
}
