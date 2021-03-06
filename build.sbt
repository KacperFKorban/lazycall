val scala3Version = "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lazyCall",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test
  )
