name := "smath"

val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "biz.enef",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-feature","-deprecation","-Xlint")
)

lazy val root = project.in(file(".")).
  aggregate(jvm,js,commons).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val smath = crossProject.in(file(".")).
  settings(commonSettings:_*).
  settings(
    name := "smath"
  ).
  jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "0.6.1"
  ).
  jsSettings()

lazy val jvm = smath.jvm
lazy val js  = smath.js    

// Apache math-commons backend
lazy val commons = project.
  dependsOn(jvm).
  settings(commonSettings:_*).
  settings(
    name := "smath-commons",
    libraryDependencies += "org.apache.commons" % "commons-math3" % "3.4.1" 
  )

