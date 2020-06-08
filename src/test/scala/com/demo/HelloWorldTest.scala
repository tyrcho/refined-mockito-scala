package com.demo

import org.mockito.scalatest.MockitoSugar
import org.scalatest.Matchers
import org.scalatest.flatspec.AnyFlatSpecLike

class HelloWorldTest extends AnyFlatSpecLike with MockitoSugar with Matchers {
  val hello = mock[HelloWorld]
  val helloRefined = mock[RefinedHelloWorld]

  "greeter" should "greet" in {
    when(hello.greet(*)) thenReturn "hello"
    hello.greet("me") shouldBe "hello"
  }

  "refined" should "greet" in {
    when(helloRefined.greet(*)) thenReturn "hello"
    hello.greet("me") shouldBe "hello"
  }
}
