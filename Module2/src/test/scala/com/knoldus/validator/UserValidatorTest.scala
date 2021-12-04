package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  behavior of "UserValidatorTest"

  val userValidator : UserValidator = new UserValidator()

  "A valid user" should "be having valid email and its company exists in database" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@gmail.com", "Knoldus")
    assert(userValidator.userIsValid(user))
  }

  "An invalid user" should "be invalid because of invalid email" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@gmail.in", "Knoldus")
    assert(!userValidator.userIsValid(user))
  }

  it should "be invalid if its company name does not exists in the database" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@gmail.org", "Infosys")
    assert(!userValidator.userIsValid(user))
  }
  it should "be invalid if it has invalid email and company name does not exist in the database" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@gmail.in", "Infosys")
    assert(!userValidator.userIsValid(user))
  }
}
