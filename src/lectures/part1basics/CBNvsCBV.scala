package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println(x)
    println(x)
  }

  def calledByName(x: => Long): Unit = {
    println(x)
    println(x)
  }

  calledByName(System.nanoTime())
  calledByValue(System.nanoTime())

}
