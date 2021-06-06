package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

object PackagingAndImports extends App {

  val writer = new Writer("Gabriel", "Gandra", 22)

  val princess = new Princess
  val prince = new PrinceCharming

  sayHello()
  println(SPEED_OF_LIGHT)
}
