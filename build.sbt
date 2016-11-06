name := "josephus"

version := "0.0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq (
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-deprecation", "-unchecked", "-feature", "-Xlint",
  "-Ywarn-infer-any"
)
