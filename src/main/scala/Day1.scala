package com.github.burlap101

import scala.io.Source
import scala.util.{Try, Success, Failure}

object Day1 {
  def ingestFile(filename: String): Set[Int] = {
    val reader = Source.fromFile(filename)
    var nums: Set[Int] = Set()
    reader.getLines().foreach(line => nums += line.toInt)
    reader.close()
    nums
  }

  def findSumAndMultiply(input: Set[Int]): Int = {
    val first: Int = input.find(f => input(2020-f)) match {
      case Some(value) => value
    }
    first * (2020 - first)
  }

  def findSumAndMultiplyPart2(input: Set[Int]): Long = {
    var firstTwo: (Long, Long) = (0L, 0L)
    input.find(m => {
      input.find(n => {
        if (m != n) input(2020 - m - n) else false
      }) match {
        case Some(n) => {
          firstTwo = (m, n)
          true
        }
        case None => false
      }
    })
    firstTwo._1* firstTwo._2* (2020L - firstTwo._1 - firstTwo._2)
  }

  def main(args: Array[String]): Unit = {
    val nums = ingestFile("input/day1/actual.txt")
    println(s"Part1 Answer:${findSumAndMultiply(nums)}")
    println(s"Part2 Answer:${findSumAndMultiplyPart2(nums)}")
  }
}
