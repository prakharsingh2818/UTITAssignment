package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  behavior of "CompanyValidatorTest"
  val companyValidator = new CompanyValidator()
  "A valid company" should "be not existing in the database and its email is valid" in {
    val company = Company("Infosys", "infosys@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(result)
  }

  "An invalid company" should "be existing in the database and its email is invalid" in {
    val company = Company("Knoldus", "Knoldus.123@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  it should "be already existing in the database" in {
    val company = Company("Knoldus", "knoldus@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  it should "be having an invalid email" in {
    val company = Company("Infosys", "infosys.123@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

}
