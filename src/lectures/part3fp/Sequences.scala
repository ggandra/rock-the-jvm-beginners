package lectures.part3fp

import java.util
import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence.reverse)
  println(aSequence ++ Seq(0, 5 , 7))
  val newSequence = aSequence ++ Seq(0, 5, 7)
  println(newSequence.sorted)

  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println(_))

  (1 to 10).foreach(x => println(x * 2))

  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString(" - | - "))

  // arrays
  val numbers = Array(1, 2, 3, 4)
  val treeElements = Array.ofDim[String](3)
  treeElements.foreach(println)
  numbers(2) = 0
  println(numbers.mkString(" "))

  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs list

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      itr <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  // keeps reference to tail
  // updating an element in the middle takes long
  val numbersList = (1 to maxCapacity).toList
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  val vectorList = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(vectorList))
}
