package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2

  var aVariable = 1

  val aCondition = true
  val aConditionedValue = if(!aCondition) 5 else 3

  val aWeirdValue: Unit = (aVariable = 3)

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }
  
  println(aCodeBlock)

}
