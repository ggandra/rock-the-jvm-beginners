package exercises

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators
import lectures.part2oop.Generics.MyList
import sun.invoke.empty.Empty

import scala.annotation.tailrec
import scala.runtime.Nothing$

abstract class MyList[+A]() {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  override def toString: String = "["+ printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = Cons(n, Empty)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = println()

  def sort(compare: (Nothing, Nothing) => Int): Empty.type = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = Cons(n, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: A => B): MyList[B] =
    Cons(transformer(h), t.map(transformer))

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t++list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))


    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {

    if  (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B =
    t.fold(operator(start, h))(operator)
}

/*trait MyPredicate[-T] {
  def apply(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def apply(elem: A): B
}*/

object ListTest extends App {
  val list = Cons(1, Cons(5, Cons(3, Cons(4, Empty))))

  /*println(list.toString)

  println(list.map(_ * 2).toString)

  println(list.filter((elem: Int) => elem % 2 == 0).toString)*/

  val anotherList = Cons(1, Cons(4, Cons(5, Cons(7, Empty))))

  /*println(anotherList.flatMap((elem: Int) => Cons(elem, Cons(elem + 1, Empty))).toString)*/

  anotherList.foreach((elem: Int) => elem * 2)

  println(list.sort((x, y) => y - x))
  println(list.zipWith(anotherList, (x, y: Int) => x + y))
  println(anotherList.fold(0)((x, y: Int) => x + y))

  val myListComprehension = for {
    n <- anotherList
  } yield  n

  println(myListComprehension)
}