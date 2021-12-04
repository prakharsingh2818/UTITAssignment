package com.knoldus.implementations

class DivideAndFibonacci extends DivideAndFibonacciTrait {
  override def doDivision(dividend: Double, divisor: Double): Double = {
    if(divisor == 0)
      throw new ArithmeticException("Cannot divide by 0")
    dividend/divisor
  }

  override def createFibonacciSeries(number: Int): Int = {
    if(number <=1)
      return number
    createFibonacciSeries(number - 2) + createFibonacciSeries(number - 1)
  }
}
