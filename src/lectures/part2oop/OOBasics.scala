package lectures.part2oop

import java.io.Writer

object OOBasics extends App {

  val person = new Person("Daniel", 22)

  val writer = new Writer("Robert", "C. Martin", 1980)

  val book = new Book("Clean Code", 2011, writer)
  println(book.isWrittenBy(writer))
  val newBook = book.copy(2020)
  println(newBook.releaseYear)

  val counter = new Counter(1)
  val newCounterAdd = counter.changeCounter("add", 2)
  val newCounterRm = newCounterAdd.changeCounter("rm")
  println(newCounterRm.currentCount())
}

class Person(name: String, val age: Int) {
  val x: Int = 2

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, i am ${name}")

  def this(name: String) = this(name, 0)
}

class Writer(name: String, surname: String, val year: Int) {
  def fullName(): String = s"$name $surname"
}

class Book(val name: String, val releaseYear: Int, val author: Writer) {

  def authorAge: Int = releaseYear - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(releaseYear: Int): Book = new Book(name, releaseYear, author)
}

class Counter(val n: Int) {
  def currentCount(): Int = n

  def changeCounter(operation: String): Counter = {
    if (operation == "add") new Counter(n + 1)
    else new Counter(n - 1)
  }

  def changeCounter(operation: String, amount: Int): Counter = {
    if (operation == "add") new Counter(amount + 1)
    else new Counter(amount - 1)
  }

  // alternative
  /*def inc() = new Counter(n + 1)
  def dec() = new Counter(n - 1)
  def inc(amount: Int) = new Counter(amount + 1)
  def dec(amount: Int) = new Counter(amount - 1)*/

  //alternative with block code for printing data
  /*def inc: Counter = {
    println("incrementing")
    new Counter(n + 1)
  }

  def dec: Counter = {
    println("decrementing")
    new Counter(n - 1)
  }

  def inc(amount: Int): Counter = {
    if (amount <= 0) this
    else inc.inc(amount + 1)
  }

  def dec(amount: Int): Counter = {
    if (amount <= 0) this
    else dec.dec(amount - 1)
  }*/
}