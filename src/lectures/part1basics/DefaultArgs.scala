package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n * acc)

  val fact5 = trFact(5)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    println("saving picture")
  }

  println(savePicture(width = 800, height = 600))
}
