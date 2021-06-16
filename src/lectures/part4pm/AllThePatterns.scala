package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

/*  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The truth"
    case AllThePatterns => "A singleton object"
  }
  println(constants)

  // match anything
  // wild card
  val matchAnything = x match {
    case _ => _
  }

  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 2) => "1 and 1"
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // PMs can be Nested!!

  // case classes = constructor pattern

  val aList: MyList[Int] = Cons(1, Cons(2, Empty))

  val matchAList = aList match {
    case Empty => "Empty List"
    case Cons(head, Cons(subhead, subtail)) => head + subhead
  }

  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor
    case List(1, _*) // list of arbitrary length
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern
  }

  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) =>  // name binding
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested params
  }

  // multi patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }*/

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match  {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => "not a string or numbers list"
  }

  println(numbersMatch)
  // JVM trick question

}
