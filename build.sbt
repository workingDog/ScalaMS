
enablePlugins(ScalaJSPlugin)

name := "scalams"

organization := "com.github.workingDog"

version := (version in ThisBuild).value

scalaJSStage in Global := FullOptStage //FastOptStage

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.querki" %%% "querki-jsext" % "0.7"
)

jsDependencies += RuntimeDOM

skip in packageJSDependencies := false

homepage := Some(url("https://github.com/workingDog/ScalaMS"))

licenses := Seq("Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xlint" // Enable recommended additional warnings.
)

