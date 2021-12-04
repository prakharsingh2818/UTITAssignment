ThisBuild/ name := "UTITAssignment"

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val Module1 = project.in(file("Module1")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)

lazy val Module2 = project.in(file("Module2")).settings(
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.10" % "test",
    "org.mockito" %% "mockito-scala-scalatest" % "1.16.46" % "test"
  )
)


