package lectures.part1basics

import scala.math.BigInt.int2bigInt

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + s" $b"

  def aParameterlessFunction(): Int = 42

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  def aGreetingFunction(name: String, age: Int): String = {
    s"Hello, my name is $name and i am $age"
  }

  def factorial(number: Int): Int = {
    if (number <= 1) 1
    else number * factorial(number-1)
  }

  def fibonacci(number: Int): Int = {
    if(number <= 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
}
