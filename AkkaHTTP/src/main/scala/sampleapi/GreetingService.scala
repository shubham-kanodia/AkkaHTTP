package sampleapi

import akka.actor.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import sampleapi.Models.Greet
import spray.json._

trait GreetingService {

  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  import Models.ServiceJsonProtocol._
  import akka.http.scaladsl.server.Directives._

  val route: Route = {
    (path("greet" / Segment) & get) { name =>
      complete(
        HttpEntity(
          ContentTypes.`application/json`,
          Greet(name, s"Hello $name").toJson.prettyPrint
        )
      )
    } ~
      (path("health") & get) {
        complete(StatusCodes.OK)
      }
  }
}
