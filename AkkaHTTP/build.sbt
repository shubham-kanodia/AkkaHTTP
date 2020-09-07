enablePlugins(JavaAppPackaging)

val dockerUserName = sys.env.getOrElse("DOCKERHUB_USERNAME", "USER_NAME")
val dockerPassword = sys.env.getOrElse("DOCKERHUB_PASSWORD", "*****")
val pipelineLabel = sys.env.getOrElse("GO_PIPELINE_LABEL", "0-0")

packageName in Docker := "greetingapi"
dockerRepository in ThisBuild := Some("docker.io")
dockerAlias := DockerAlias(None, Some(dockerUserName), (packageName in Docker).value, Some(pipelineLabel))

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
