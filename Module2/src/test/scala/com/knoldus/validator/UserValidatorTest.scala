package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val userValidator : UserValidator = new UserValidator()
  behavior of "UserValidatorTest"

  "A user" should "be valid if email is valid and company exists in database" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@gmail.com", "Knoldus")
    assert(userValidator.userIsValid(user))
  }

  it should "be invalid if email is invalid" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@gmail.in", "Knoldus")
    assert(!userValidator.userIsValid(user))
  }

  it should "be invalid if company name is not present in the database" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@gmail.org", "Infosys")
    assert(!userValidator.userIsValid(user))
  }
  it should "be invalid if email is invalid and company name is not present in the database" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@gmail.in", "Infosys")
    assert(!userValidator.userIsValid(user))
  }



}
