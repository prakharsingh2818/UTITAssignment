package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator = mock[UserValidator]
  val userImpl = new UserImpl(mockedUserValidator)

  behavior of "UserImplUnitTest"

   "A user" should "be valid" in {
      val mockUser : User = new User("", "", "", "")
      when(mockedUserValidator.userIsValid(mockUser)) thenReturn true
      val result = userImpl.createUser(mockUser)
      assert(result != None)
    }
}
