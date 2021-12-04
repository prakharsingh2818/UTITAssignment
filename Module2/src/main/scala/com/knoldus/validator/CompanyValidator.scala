package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator {

  def companyIsValid(company: Company): Boolean = {
    val emailValidator = new EmailValidator()
    val checkCompanyExists = new CompanyReadDto().getCompanyByName(company.name)
    val companyEmail : String = company.emailId
    if(checkCompanyExists.isEmpty && emailValidator.emailIdIsValid(companyEmail))
      true
    else
      false
  }
}
