package sampleapi

import akka.actor.ActorSystem
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import sampleapi.Models.{Greet, ServiceJsonProtocol}

trait GreetingService extends ServiceJsonProtocol with SprayJsonSupport {

  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  import akka.http.scaladsl.server.Directives._

  val route: Route = {
    (path("greet" / Segment) & get) { name =>
      complete(Greet(name, s"Hello $name"))
    } ~
      (path("health") & get) {
        complete(StatusCodes.OK)
      }
  }
}
