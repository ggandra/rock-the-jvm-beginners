package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a, b) => a + b

  val justDoSomething: () => Int = () => 3

  val stringToInt = { (string: String) =>
    string.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _
}
