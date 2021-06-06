package lectures.part2oop

import scala.annotation.tailrec

object Exceptions extends App {

  class PocketCalculator {
    def add(n1: Int, n2: Int): Int = {
      val result = n1 + n2
      if (n1 > 0 && n2 > 0 && result < 0) throw new OverflowException
      else if (n1 < 0 && n1 < 0 && result > 0) throw new UnderflowException
      else result
    }

    def sub(n1: Int, n2: Int): Int = {
      val result = n1 - n2
      if (n1 > 0 && n2 < 0 && result < 0) throw new OverflowException
      else if (n1 < 0 && n1 > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multi(n1: Int, n2: Int): Int = {
      val result = n1 * n2
      if(n1 > 0 && n2 > 0 && result < 0) throw new OverflowException
      if(n1 < 0 && n2 < 0 && result < 0) throw new OverflowException
      if(n1 > 0 && n2 < 0 && result > 0) throw new UnderflowException
      if(n1 < 0 && n2 > 0 && result > 0) throw new UnderflowException
      else result
    }

    def div(n1: Int, n2: Int): Int = {
      if (n2 == 0) throw new MathCalculationException
      else n1 / n2
    }
  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  val calc = new PocketCalculator
  println(calc.add( 0, 2))
  println(calc.sub(10, 5))
  println(calc.multi(10, 5))
  println(calc.div(10, 2))

  val x: String = null
  // println(x.length)

  //val aWeirdValue: String = throw new NullPointerException

  // println(aWeirdValue)

  // catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    println(getInt(true))
  } catch {
    case e: RuntimeException => 42
  } /*finally {
    println(getInt(false))
  }*/
  println(potentialFail)

  // StackOverflowError
  val stringExc = "\"Adieu.\n    \"ERNST VON DRESCHLER, COUNT MELNIK.\"\n\n\n\n\"To my Daughter, Christabel von Dreschler.\n\n\"MY DEAREST CHILD,—If you are ever to read these lines it will be because your uncle believes you are fitted to take up the task of clearing our name, from the stain of crime which the villainy of others has put upon it. But whether you will make the effort must be decided finally by yourself alone. For two years I have tried, with such strength as was left to me by those who did me this foul wrong, and I have failed. Were you a son, I should lay this task upon you as a solemn charge; but you are only a girl, and left in your hands, it would be all but hopeless, because of both its difficulty and probable danger. I leave you free to decide: for the reason that if you have not the personal capacity to make the decision, you will not have in you the power to succeed. One thing only I enjoin upon you. If you cannot clear my name, do not bear it.\n\n\"I have not strength to write out in full all the details of the matter, but I give you the main outline here and send in this packet many memoranda which I have made from time to time. These will give you much that you need.\n\n\"At the time of your mother's death and your leaving Hungary for the United States I was, as you may remember, a colonel in the Austro-Hungarian army, in possession of my title and estates, and in favour with one of the two most powerful of all the great Slav nobles, Ladislas, Duke of Kremnitz. I continued, as I believed, to enjoy his confidence for two years longer, up to the last, indeed. He was one of the leaders of the Patriots—the great patriotic movement which you will find described in the papers I send you—the other being the Hungarian magnate, Duke Alexinatz of Waitzen. Two of my friends, whose names you must remember, were Major Katona, my intimate associate, and Colonel von Erlanger, whom I knew less well.\n\n\"If the Patriots were successful, the Hungarian Throne was to be filled by Duke Alexinatz with reversion to his only son, Count Stephen; and it is necessary for you to understand that this arrangement was expressly made by Duke Ladislas himself.\n\n\"So matters stood when, one day, some hot words passed between young Count Stephen and myself, and he insulted me grossly. Two days later, Major Katona came to my house at night in great agitation. He declared that the Count had sworn to shoot me, and that his father had espoused his side in the quarrel and threatened to have me imprisoned; and that Duke Ladislas, unwilling to quarrel with Duke Alexinatz, although taking my part in the affair, desired me to absent myself from Buda-Pesth until the storm had blown over. He pressed me to leave instantly; and, suspecting nothing, I yielded. I had scarcely left my house when the carriage was stopped, I was seized, gagged, and blindfolded, and driven for many hours in this condition, and then imprisoned. I believed that I was in the hands of the agents of Duke Alexinatz; and continued in this belief for six years, during the whole of which time I was kept a close prisoner."
  //println(stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc ++stringExc ++ stringExc ++ stringExc ++ stringExc ++ stringExc++ stringExc++stringExc)

  // OutOfMemory
  // val array = Array.ofDim(Int.MaxValue)
}
