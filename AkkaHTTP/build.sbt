name := "AkkaHTTP"

name := "Akka HTTP"

version := "0.1"

scalaVersion := "2.11.11"

val akkaHttpVersion = "10.1.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %%"akka-http-testkit-experimental" % "1.0",
  "org.jsoup" % "jsoup" % "1.8.3",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "junit" % "junit" % "4.12" % Test,
  "com.typesafe.akka" %% "akka-http-experimental" % "1.0",
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "1.0"
)
