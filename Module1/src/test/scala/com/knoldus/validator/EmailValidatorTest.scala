package com.knoldus.validator

import com.knoldus.models.Person
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {
  val validator = new EmailValidator()

  "A valid email" should "be valid if " in {

    var user = new Person("prakharsingh@knoldus.com")
    var result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharSingh@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharSingh1@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("2818@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("PRAKHARSINGH2818@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("PRAKHARSINGH@knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    //Positive Test Cases for Domain Name
    user = new Person("prakharsingh2818@Knoldus.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@KNOLDUS.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@Knoldus1.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@knoldus1.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@KNOLDUS1.com")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@knoldus.org")
    result = validator.isEmailValid(user)
    assert(result)

    user = new Person("prakharsingh2818@knoldus.net")
    result = validator.isEmailValid(user)
    assert(result)
  }

  "An invalid email" should "be if recipient name contains special characters" in {

    //Negative Test Cases for recipient name
    val user = new Person("prakharsingh.2818@knoldus.com")
    val result = validator.isEmailValid(user)
    assert(!result)
  }

  it should "be if domain name contains special characters" in {
    //Negative Test Cases for domain name
    val user = new Person("prakharsingh2818@_knoldus.com")
    val result = validator.isEmailValid(user)
    assert(!result)
  }

  it should "be if top-level domain is not .com or .org or .net" in{
    //Negative Test Case for top-level domain
    val user = new Person("prakharsingh@knoldus.in")
    val result = validator.isEmailValid(user)
    assert(!result)
  }
  it should "be if Email Id does not follow proper syntax" in{
    //Negative Test Case for improper email syntax
    var user = new Person("prakharsinghknoldus.com")
    var result = validator.isEmailValid(user)
    assert(!result)

    user = new Person("prakharsingh@knolduscom")
    result = validator.isEmailValid(user)
    assert(!result)

    user = new Person("prakh@arsingh@knoldus.com")
    result = validator.isEmailValid(user)
    assert(!result)

    user = new Person("@knoldus.com")
    result = validator.isEmailValid(user)
    assert(!result)

    user = new Person("prakharsingh@.com")
    result = validator.isEmailValid(user)
    assert(!result)

    user = new Person("prakharsingh@knoldus.")
    result = validator.isEmailValid(user)
    assert(!result)

  }

}
