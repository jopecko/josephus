import scala.math.{floor, log, pow}

import Josephus._

import org.scalatest.FunSpec

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

class ScalaTestWithScalaCheck extends FunSpec with GeneratorDrivenPropertyChecks {

  // exploit power of two shortcut in Josephus problem
  // http://www.exploringbinary.com/powers-of-two-in-the-josephus-problem/
  val positiveIntGen = for (n <- Gen.choose(1, 10000)) yield n
  val lnOf2 = log(2)
  def log2(x: Double) = log(x) / lnOf2
  def w(n: Int) = 2 * (n - pow(2.0, floor(log2(n)))) + 1

  describe("Josephus") {
    it("requires a non-negative population") {
      assertThrows[IllegalArgumentException] {
        findLastManStanding(-1, 2)
      }
    }
    it("requires a non-zero population") {
       assertThrows[IllegalArgumentException] {
         findLastManStanding(0, 2)
      }
    }
    it("requires a non-negative skip") {
       assertThrows[IllegalArgumentException] {
         findLastManStanding(41, -1)
      }
    }
    it("solves the Josephus problem") {
      findLastManStanding(41, 3) === 31
    }
    it("solves for n = 3 and k = 2") {
      findLastManStanding(3, 2) == 3
    }
    it("solves for n == k") {
      findLastManStanding(3, 3) == 2
    }
    it("finds survivor for large n with k = 2") {
      forAll(positiveIntGen) {
        (population: Int) => {
          findLastManStanding(population, 2) === w(population)
        }
      }
    }
  }
}
