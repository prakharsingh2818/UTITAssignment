package com.knoldus.implementations

import org.scalatest.flatspec.AnyFlatSpec

class DivideAndFibonacciTest extends AnyFlatSpec {


  "Fibonacci of number 5" should "be" in {
    val number : Int = 5
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(5)(lastNumber)
  }

  "Fibonacci of number 9" should "be" in {
    val number : Int = 9
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(34)(lastNumber)
  }

  "Fibonacci of number 0" should "be" in {
    val number : Int = 0
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(0)(lastNumber)
  }

  "Fibonacci of number 1" should "be" in {
    val number : Int = 1
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(1)(lastNumber)
  }

  "Fibonacci of number 2" should "be" in {
    val number : Int = 2
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(1)(lastNumber)
  }

  "Fibonacci of number -2" should "be" in {
    val number : Int = -2
    val lastNumber = new DivideAndFibonacci().createFibonacciSeries(number)
    assertResult(-2)(lastNumber)
  }

  "Remainder of 20 divided by 3" should "be" in{
    val dividend : Double = 20
    val divisor : Double = 3
    val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    assertResult(6.666666666666667)(result)
  }

  "Remainder of 20 divided by 4" should "be" in{
    val dividend : Double = 20
    val divisor : Double = 4
    val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    assertResult(5)(result)
  }

  "Remainder of -20 divided by 5" should "be" in{
    val dividend : Double = -20
    val divisor : Double = 5
    val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    assertResult(-4)(result)
  }

  "Remainder of 21 divided by -3" should "be" in{
    val dividend : Double = 21
    val divisor : Double = -3
    val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    assertResult(-7)(result)
  }

  "Remainder of -30 divided by -15" should "be" in{
    val dividend : Double = -30
    val divisor : Double = -15
    val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    assertResult(2)(result)
  }

  "Remainder of a number divided by 0" should "be an exception" in{
    val dividend : Double = 20
    val divisor : Double = 0
    assertThrows[ArithmeticException] {
      val result = new DivideAndFibonacci().doDivision(dividend, divisor)
    }
  }

}
