package com.demo

import com.demo.Util._
import eu.timepit.refined.auto._
import eu.timepit.refined.types.string.NonEmptyString
import org.mockito.{ArgumentMatcher, ArgumentMatchers}
import org.mockito.matchers.AnyMatcher
import org.mockito.scalatest.MockitoSugar
import org.scalatest.Matchers
import org.scalatest.flatspec.AnyFlatSpecLike

class HelloWorldTest extends AnyFlatSpecLike with MockitoSugar with Matchers {

  "greeter" should "greet" in {
    val hello = mock[HelloWorld]
    when(hello.greet(*)) thenReturn "hello"
    hello.greet("me") shouldBe "hello"
  }

  "refined" should "match and greet" in {
    val helloRefined = mock[RefinedHelloWorld]
    when(helloRefined.greet("me")) thenReturn "hello"
    when(helloRefined.greet("you")) thenReturn "bye"
    helloRefined.greet("me") shouldBe "hello"
    helloRefined.greet("you") shouldBe "bye"
  }

  "refined" should "greet" in {
    val helloRefined = mock[RefinedHelloWorld]
    when(helloRefined.greet(star)) thenReturn "hello"
    helloRefined.greet("me") shouldBe "hello"
    helloRefined.greet("you") shouldBe "hello"
  }

  implicit val defaultNes: NonEmptyString = NonEmptyString(" ")
}

object Util {
  def star[T](implicit default: T): T = {
    ArgumentMatchers.argThat((_: T) => true)
    default
  }
}
