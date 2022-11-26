package com.github.burlap101

import scala.io.Source
import scala.util.{Failure, Success, Try}

object Day2 {

  case class PasswordLine(min: Int, max: Int, letter: Char, password: String)
  def ingestFile(filename: String): List[PasswordLine] = {
    val reader = Source.fromFile(filename)
    val result: List[PasswordLine] = reader.getLines().toList.map(line => {
      val parts = line.split(" ")
      val minmax = parts(0).split("-").map[Int](_.toInt)
      val letter = parts(1).charAt(0)
      val password = parts(2)
      PasswordLine(minmax(0), minmax(1), letter, password)
    })
    reader.close()
    result
  }

  def validLine(input: PasswordLine): Boolean = {
    val count = input.password.count(_ == input.letter)
    count <= input.max && count >= input.min
  }

  def validLine2(input: PasswordLine): Boolean = {
    input.password.charAt(input.min-1) == input.letter ^ input.password.charAt(input.max-1) == input.letter
  }

  def main(args: Array[String]): Unit = {
    println(s"Part 1 answer: ${ingestFile("input/day2/actual.txt").count(p => validLine(p))}")
    val part2filtered = ingestFile("input/day2/actual.txt")
    println(s"Part 2 answer: ${part2filtered.count(p => validLine2(p))}")
  }
}
