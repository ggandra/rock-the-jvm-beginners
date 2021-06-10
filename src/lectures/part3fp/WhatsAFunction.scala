package lectures.part3fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("5") + 5)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder(2, 5))

  def stringConcat: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(str1: String, str2: String): String = s"$str1 $str2"
  }
  println(stringConcat("Hello", "Scala"))

  def functionInsideFunction: ((Int) => Function1[Int, Int]) = new Function1[Int, Function[Int, Int]] {
    override def apply(number: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(anotherNumber: Int): Int = number + anotherNumber
    }
  }

  def anotherFunctionInsideFunction: ((Int) => Function1[Int, Int]) = new Function1[Int, Function[Int, Int]] {
    override def apply(number: Int): Int => Int = anotherNumber => number + anotherNumber
  }

  val anotherFunctionInsideFunction2 = (x: Int) => (y: Int) => x + y

  println(anotherFunctionInsideFunction2(2)(25))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
