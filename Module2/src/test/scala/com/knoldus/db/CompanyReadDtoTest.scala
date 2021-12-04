package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoTest extends AnyFlatSpec {
  val companyReadDtoTest : CompanyReadDto = new CompanyReadDto()

  behavior of "getCompanyByName method"

  it should "return the company if it exists in the database" in {
    val result = companyReadDtoTest.getCompanyByName("Knoldus")

    assert(result.isDefined)
  }

  it should "not return the company it does not exists in the database" in {
    val result = companyReadDtoTest.getCompanyByName("Infosys")

    assert(result.isEmpty)
  }
}
