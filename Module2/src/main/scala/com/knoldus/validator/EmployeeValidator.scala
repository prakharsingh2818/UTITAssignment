package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee

class EmployeeValidator {

  def employeeIsValid(employee: Employee): Boolean = {
    val companyValidator : CompanyReadDto = new CompanyReadDto()
    val emailValidator : EmailValidator = new EmailValidator()
    if(emailValidator.emailIdIsValid(employee.emailId) && companyValidator.getCompanyByName(employee.companyName) != None) {
      true
    }
    else
      false
  }
}
