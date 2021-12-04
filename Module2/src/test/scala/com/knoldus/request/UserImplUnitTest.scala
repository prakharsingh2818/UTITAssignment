package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator : UserValidator = mock[UserValidator]
  val userImpl = new UserImpl(mockedUserValidator)

   "A user" should "be valid" in {
      val mockUser : User = User("", "", "", "")
      when(mockedUserValidator.userIsValid(mockUser)) thenReturn true
      val result = userImpl.createUser(mockUser)
      assert(result.isDefined)
    }

    it should "be invalid" in {
      val mockUser : User = User("", "", "", "")
      when(mockedUserValidator.userIsValid(mockUser)) thenReturn false
      val result = userImpl.createUser(mockUser)
      assert(result.isEmpty)
    }
}
