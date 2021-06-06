package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(theRockstar: String): Person = new Person(s"$name $theRockstar", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def apply(): String = "hello"

    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"

    def learns(learning: String): String = s"$name learns $learning"

    def learnsScala: String = this learns "Scala"
  }

  val mary = new Person("mary", "inception", 23)
  println(mary.likes("inception"))
  println(mary likes "inception")
  val gabriel = new Person("Gabriel", "Fight Club")

  val maryRockstar =  mary + "the rockstar"

  val maryBirthday = +mary
  println(maryBirthday.age)

  println(maryRockstar.name)

  println(!mary)
  println(mary(10))
  println(mary learnsScala)
}
