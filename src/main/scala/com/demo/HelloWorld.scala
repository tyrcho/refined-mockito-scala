package com.demo

import eu.timepit.refined.types.string.NonEmptyString

trait HelloWorld {
  def greet(name: String): String
}

trait RefinedHelloWorld {
  def greet(name: NonEmptyString): String
}
