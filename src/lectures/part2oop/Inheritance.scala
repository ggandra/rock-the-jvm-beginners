package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    final def eat :String = "nomnom"
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat
      println(s"crunch crunch, $eat")
    }
  }

  val cat = new Cat
  cat.crunch()


  //constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class Dog(dogType: String) extends Animal {
    override val creatureType: String = dogType
    /*override def eat: String = {
      println(super.eat)
      "dog crunch"
    }*/
  }

  val dog = new Dog("domestic")
  println(dog.creatureType)

  val unknownAnimal: Animal = new Dog("K9")
  println(unknownAnimal.eat)

}
