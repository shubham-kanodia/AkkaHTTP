package sampleapi

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class GreetingAPITest extends FlatSpec with Matchers with ScalatestRouteTest with GreetingService {
  "GreetingAPI" should "return desired responses for defined endpoints" in {

    Get("/greet/shubham") ~> route ~> check {
      status.isSuccess() should equal(true)
    }
  }
}
