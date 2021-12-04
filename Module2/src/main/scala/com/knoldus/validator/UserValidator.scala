package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User

class UserValidator {
  def userIsValid(user : User): Boolean = {
    val companyValidator : CompanyReadDto = new CompanyReadDto()
    val emailValidator : EmailValidator = new EmailValidator()

    val validEmail = emailValidator.emailIdIsValid(user.email)
    val validCompany = companyValidator.getCompanyByName(user.companyName)

    if(validEmail && validCompany != None)
      true
    else
      false
  }
}
