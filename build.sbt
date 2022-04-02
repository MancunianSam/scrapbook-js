ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dev.sampalmer"
ThisBuild / organizationName := "example"

enablePlugins(ScalaJSPlugin)

name := "Scrapbook  JS"
scalaVersion := "2.13.1" // or any other Scala version >= 2.11.12

scalaJSUseMainModuleInitializer := true
jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

lazy val root = (project in file("."))
  .settings(
    name := "scrapbook-js",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.1.0",
      "com.softwaremill.sttp.client3" %%% "core" % "3.5.1",
      "org.scala-js" %%% "scala-js-macrotask-executor" % "1.0.0",
      "com.lihaoyi" %%% "utest" % "0.7.11" % Test
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
