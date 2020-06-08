scalaVersion := "2.12.11"
libraryDependencies ++= Seq(
  "eu.timepit" %% "refined-pureconfig" % "0.9.14",
  "org.scalatest" %% "scalatest" % "3.1.2" % Test,
  "org.mockito" %% "mockito-scala-cats" % "1.14.3" % Test,
  "org.mockito" %% "mockito-scala-scalatest" % "1.14.3" % Test
)

