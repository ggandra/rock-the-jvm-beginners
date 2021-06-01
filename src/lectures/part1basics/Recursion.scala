package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
      println(s"Computing factorial of $n i first need factorial of ${n-1}")
      val result = n * factorial(n-1)
      println(s"Computed factorial of $n")
      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  def stringConcat(name: String, times: Int): String = {
    @tailrec
    def concatHelper(strAccumulator: String, times: Int): String =
      if (times <= 0) strAccumulator
      else concatHelper(strAccumulator + name, times - 1)

    concatHelper("", times)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, isStillPrime = true)
  }

  println(isPrime(11))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }
}
