import scala.collection.mutable.ListBuffer

object Josephus {

  def findLastManStanding(population: Int, skip: Int) = {
    require(population >= 1)
    require(skip >= 0)

    val men = ListBuffer.range(1, population + 1)
    var idx = 0;
    while (men.size > 1) {
      idx = (idx + skip - 1) % men.size
      men.remove(idx)
    }
    men(0)
  }

  def main(args: Array[String]): Unit = {
    require(args.size == 2, "Usage Josephus <population> <step>")
    val population = args(0).toInt
    val step = args(1).toInt
    println(findLastManStanding(population, step))
  }
}
