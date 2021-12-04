package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplUnitTest extends AnyFlatSpec {
  val mockedCompanyValidator = mock[CompanyValidator]
  val companyImpl = new CompanyImpl(mockedCompanyValidator)

  "A company" should "be valid" in {
    val mockedCompany = new Company("", "", "")

    when(mockedCompanyValidator.companyIsValid(mockedCompany)) thenReturn true

    val result = companyImpl.createCompany(mockedCompany)

    assert(result != None)
  }

  it should "be invalid" in {
    val mockedCompany = new Company("", "", "")

    when(mockedCompanyValidator.companyIsValid(mockedCompany)) thenReturn false

    val result = companyImpl.createCompany(mockedCompany)

    assert(result == None)
  }
}
