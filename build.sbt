ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "br.com.basico"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )