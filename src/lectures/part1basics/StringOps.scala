package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, im learning Scala"

  println(str.charAt(2))
  println(str.substring(0, 5))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')

  val name = "Gabriel"
  val speed: Float = 4.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per hour"
  println(myth)

  println(raw"This is an \n newline")
  val escaped = "This is an \n newline"
  println(raw"$escaped")
}
