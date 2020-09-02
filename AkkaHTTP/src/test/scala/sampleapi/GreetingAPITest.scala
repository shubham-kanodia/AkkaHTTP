package sampleapi

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}
import sampleapi.Models.{Greet, ServiceJsonProtocol}

class GreetingAPITest extends FlatSpec
  with Matchers
  with ScalatestRouteTest
  with GreetingService
  with SprayJsonSupport
  with ServiceJsonProtocol {
  "GreetingAPI" should "return desired responses for defined endpoints" in {

    val expectedResponse = Greet("USER_NAME", "Hello USER_NAME")

    Get("/greet/USER_NAME") ~> route ~> check {
      responseAs[Greet] should equal(expectedResponse)
    }

    Get("/greet/health") ~> route ~> check {
      status.isSuccess() should equal(true)
    }
  }
}
