package sampleapi

import spray.json.DefaultJsonProtocol

object Models {

  trait Response

  case class Greet(name: String, message: String) extends Response

  object ServiceJsonProtocol extends DefaultJsonProtocol {
    implicit val personProtocol = jsonFormat2(Greet.apply)
  }

}
