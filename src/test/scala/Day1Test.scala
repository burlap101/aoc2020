package com.github.burlap101

import org.scalatest.funsuite.AnyFunSuite

class Day1Test extends AnyFunSuite {
  test("Day1.ingestFile") {
    assert(Day1.ingestFile("input/day1/test.txt") match {
      case _:Set[Int] => true
      case _ => false
    })
  }

  test("Day1.findSumAndMultiply") {
    val nums = Day1.ingestFile("input/day1/test.txt")
    assert(Day1.findSumAndMultiply(nums) == 514579)
  }

  test("Day1.findSumAndMultiplyPart2") {
    val nums = Day1.ingestFile("input/day1/test.txt")
    assert(Day1.findSumAndMultiplyPart2(nums) == 241861950)
  }
}
