package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val userValidator : UserValidator = new UserValidator()
  val userImpl : UserImpl = new UserImpl(userValidator)

  "A valid user" should "be valid if its email is valid and company exists in database" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@knoldus.com", "Knoldus")

    val result = userImpl.createUser(user)
    assert(result.isDefined)
  }

  "An invalid user" should "be invalid its email is invalid" in {
    val user: User =  User("Prakhar", "Singh", "prakharsingh.2818@knoldus.com", "Knoldus")

    val result = userImpl.createUser(user)
    assert(result.isEmpty)
  }

  it should "be invalid if its company name does not exists in database" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh2818@knoldus.com", "Infosys")

    val result = userImpl.createUser(user)
    assert(result.isEmpty)
  }

  it should "be invalid if its company name does not exist in database and having an invalid email" in {
    val user: User = User("Prakhar", "Singh", "prakharsingh.2818@knoldus.com", "Infosys")

    val result = userImpl.createUser(user)
    assert(result.isEmpty)
  }
}
