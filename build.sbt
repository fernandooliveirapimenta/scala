ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "br.com.basico"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.5"

val specs2Version = "3.8.6"


libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "joda-time" % "joda-time" % "2.9.4",
  "org.specs2" %% "specs2-core" % specs2Version % "test",
  "org.specs2" %% "specs2-mock" % specs2Version % "test"
)

