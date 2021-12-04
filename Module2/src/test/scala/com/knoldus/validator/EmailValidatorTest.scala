package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {
  val validator = new EmailValidator()

  "A valid email" should "be valid if " in {
    //Positive Test Cases for Recipient Name

    var employeeEmail = "prakharsingh@knoldus.com"
    var result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharSingh@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharSingh1@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "2818@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "PRAKHARSINGH2818@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "PRAKHARSINGH@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    //Positive Test Cases for Domain Name
    employeeEmail = "prakharsingh2818@Knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@KNOLDUS.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@Knoldus1.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@knoldus1.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@KNOLDUS1.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@knoldus.org"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)

    employeeEmail = "prakharsingh2818@knoldus.net"
    result = validator.emailIdIsValid(employeeEmail)
    assert(result)
  }

  "An invalid email" should "be if recipient name contains special characters" in {
  //Negative Test Cases for recipient name
  val employeeEmail = "prakharsingh.2818@knoldus.com"
  val result = validator.emailIdIsValid(employeeEmail)
  assert(!result)
  }

  it should "be if domain name contains special characters" in {
    //Negative Test Cases for domain name
    val employeeEmail = "prakharsingh2818@_knoldus.com"
    val result = validator.emailIdIsValid(employeeEmail)
    assert(!result)
  }

  it should "be if top-level domain is not .com or .org or .net" in {
    //Negative Test Case for top-level domain
    val employeeEmail = "prakharsingh@knoldus.in"
    val result = validator.emailIdIsValid(employeeEmail)
    assert(!result)
  }

  it should "be if Email Id does not follow proper syntax" in {
    //Negative Test Case for improper email syntax
    var employeeEmail = "prakharsinghknoldus.com"
    var result = validator.emailIdIsValid(employeeEmail)
    assert(!result)

    employeeEmail = "prakharsingh@knolduscom"
    result = validator.emailIdIsValid(employeeEmail)
    assert(!result)

    employeeEmail = "prakh@arsingh@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(!result)

    employeeEmail = "@knoldus.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(!result)

    employeeEmail = "prakharsingh@.com"
    result = validator.emailIdIsValid(employeeEmail)
    assert(!result)

    employeeEmail = "prakharsingh@knoldus."
    result = validator.emailIdIsValid(employeeEmail)
    assert(!result)
  }

}
