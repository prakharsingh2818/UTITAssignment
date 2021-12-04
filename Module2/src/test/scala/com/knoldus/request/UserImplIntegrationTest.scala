package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val userValidator : UserValidator = new UserValidator()
  val userImpl : UserImpl = new UserImpl(userValidator)

  "A user" should "be valid if its email is valid and company name exists in database" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@knoldus.com", "Knoldus")

    val result = userImpl.createUser(user)
    assert(result != None)
  }

  "A user" should "be invalid its email is invalid" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh.2818@knoldus.com", "Knoldus")

    val result = userImpl.createUser(user)
    assert(result == None)
  }

  "A user" should "be invalid company name does not exist in database" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh2818@knoldus.com", "Infosys")

    val result = userImpl.createUser(user)
    assert(result == None)
  }

  "A user" should "be invalid company name does not exist in database and its email is invalid" in {
    val user: User = new User("Prakhar", "Singh", "prakharsingh.2818@knoldus.com", "Infosys")

    val result = userImpl.createUser(user)
    assert(result == None)
  }
}
