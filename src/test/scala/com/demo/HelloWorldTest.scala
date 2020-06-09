package com.demo

import eu.timepit.refined.auto._
import eu.timepit.refined.types.string.NonEmptyString
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

  "refined" should "match and greet" in {
    when(helloRefined.greet(NonEmptyString("me"))) thenReturn "hello"
    when(helloRefined.greet(NonEmptyString("you"))) thenReturn "bye"
    helloRefined.greet("me") shouldBe "hello"
    helloRefined.greet("you") shouldBe "bye"
  }

//  "refined" should "greet" in {
//    when(helloRefined.greet(*[NonEmptyString])) thenReturn "hello"
//    hello.greet("me") shouldBe "hello"
//  }
}
