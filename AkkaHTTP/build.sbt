enablePlugins(JavaAppPackaging)

packageName in Docker := "shubhamkanodia/greetingapi"

dockerUpdateLatest in Docker := true

resolvers ++= Seq(
  "Sonatype Release" at "https://oss.sonatype.org/content/repositories/releases"
)

lazy val akkaHTTP = (project in file("."))
  .settings(
    name := "Akka HTTP",
    version := "1.0",
    scalaVersion := "2.11.11",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %%"akka-http-testkit-experimental" % "1.0",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test,
      "junit" % "junit" % "4.12" % Test,
      "com.typesafe.akka" %% "akka-http-experimental" % "1.0",
      "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "1.0"
    )
  )
