package com.knoldus.validator

import com.knoldus.models.Employee

import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

class EmailValidator {

  def emailIdIsValid(email: String): Boolean = {
    val regexString : Regex = new Regex("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$")
    if(!email.matches(regexString.toString())) {
      false
    }
    else {
      var domainName : ArrayBuffer[String] = new ArrayBuffer[String]
      domainName.addAll(email.split('.'))
      if(domainName(1).equals("com") || domainName(1).equals("org") || domainName(1).equals("net"))
        true
      else
        false
    }
  }
}
