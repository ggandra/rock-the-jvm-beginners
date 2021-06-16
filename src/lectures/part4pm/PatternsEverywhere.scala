package lectures.part4pm

object PatternsEverywhere extends App {

  try {

  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  // catches are actually matches

  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield x * 10

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(tuple)

  val head :: tail = list
  println(head)

  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "is the one"
    case _ => "something else"
  }
}
