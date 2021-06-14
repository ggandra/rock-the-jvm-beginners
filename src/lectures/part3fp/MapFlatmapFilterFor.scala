package lectures.part3fp

import lectures.part2oop.Generics.MyList

object MapFlatmapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val pairLists = (x: Int) => chars.flatMap((y) => colors.map(color => "" + y + x + "-" + color))
  println(numbers.flatMap(pairLists))

  // foreach
  // list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  for {
    n <- numbers
  } println(n)

  println(forCombinations)

  list.map { x =>
    x * 2
  }

}
