# UTITAssignment

The Project contains 2 modules.  

1. **Module1**
  - com.knoldus.implementations package contains DivideAndFibonacci class and Trait which performs division operation and calculate fibonacci series by returning the last number of the series 
  - com.knoldus.validator package contains EmailValidator.scala file which performs email validation based on:
      - Email should have 4 parts in order mentioned below
      - Recipient name - alphanumeric characters (both lower and upper case)
      - @ symbol
      - Domain name – alphanumeric (both lower and upper case)
      - Top-level domain - .com/.net/.org
  - com.knoldus.models package contains Person.scala file which contains email member variable upon which validation is performed
  
2. **Module2**
  - com.knoldus.models package provides Model classes like Company and User on which validation will be performed
  - com.knoldus.validator package provide validation classes for email, company and user
  - com.knoldus.db package provides CompanyReadDto.scala file which provides us with 2 companies for testing the code
  - com.knoldus.request package provides CompanyImpl.scala and UserImpl.scala file which are used to create a company and a user respectively after performing validations
  


Both the modules contains test files under com.knoldus.test package for performing unit and integration tests. 
**The project makes use of AnyFlatSpec testing style for performing these tests.**



