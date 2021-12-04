package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyValidator : CompanyValidator = new CompanyValidator()
  val companyImpl : CompanyImpl = new CompanyImpl(companyValidator)

  "A company" should "be valid" in {
    var company : Company = new Company("Infosys", "infosys@gmail.com", "Bengaluru")
    var result : Option[String] = companyImpl.createCompany(company)

    assert(result.getOrElse("Infosys").equals("Infosys"))

    company = new Company("Wipro", "wipro789@gmail.com", "Bengaluru")
    result = companyImpl.createCompany(company)

    assert(result.getOrElse("Wipro").equals("Wipro"))
  }

  it should "be invalid" in {
    var company : Company = new Company("Knoldus", "knoldus@gmail.com", "Noida")
    var result : Option[String] = companyImpl.createCompany(company)

    assert(result == None)

  }
}
