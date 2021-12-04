package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  behavior of "CompanyValidatorTest"
  val companyValidator = new CompanyValidator()
  "A company" should "be valid if it does not exist in the database and its email is valid" in {
    val company = new Company("Infosys", "infosys@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(result)
  }

  it should "be invalid if it exists in the database and its email is invalid" in {
    val company = new Company("Knoldus", "Knoldus.123@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  it should "be invalid if it already exist in the database" in {
    val company = new Company("Knoldus", "knoldus@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

  it should "be invalid if its email is invalid" in {
    val company = new Company("Infosys", "infosys.123@gmail.com", "Bengaluru")
    val result = companyValidator.companyIsValid(company)
    assert(!result)
  }

}
