ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "br.com.basico"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  )
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.5"

