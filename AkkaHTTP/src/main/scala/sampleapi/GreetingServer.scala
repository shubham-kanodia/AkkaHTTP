package sampleapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

class GreetingServer(implicit val system: ActorSystem,
                     implicit val materializer: ActorMaterializer) extends GreetingService {
  def startServer(address: String, port: Int) = {
    Http().bindAndHandle(route, address, port)
  }
}

object GreetingServer extends App {

  implicit val system = ActorSystem("RestServer")
  implicit val materializer = ActorMaterializer()

  val server = new GreetingServer()
  server.startServer("localhost", 8080)

}
