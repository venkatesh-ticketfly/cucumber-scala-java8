organization := "info.cucumber"

name := "scala"

version := "1.0.2"

scalaVersion := "2.11.7"

val cucumberJvmVersion       = "1.2.4"
val guiceVersion             = "4.0"
val scalaTestVersion         = "2.2.4"
val junitInterfaceVersion    = "0.11"

libraryDependencies ++= Seq(

  "info.cukes"                %  "cucumber-java8"          % cucumberJvmVersion,

  "com.google.inject"         %  "guice"                   % guiceVersion           % Test,
  "info.cukes"                %  "cucumber-guice"          % cucumberJvmVersion     % Test,
  "info.cukes"                %  "cucumber-junit"          % cucumberJvmVersion     % Test,
  "org.scalatest"             %  "scalatest_2.11"          % scalaTestVersion       % Test,
  "com.novocode"              %  "junit-interface"         % junitInterfaceVersion  % Test
)

compileOrder := CompileOrder.JavaThenScala

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

credentials += Credentials(Path.userHome / ".artifactory" / ".credentials")

resolvers ++= Seq(
  "TFly Github Repo"                       at "http://ticketfly.github.com/repo",
  "Ticketfly Artifactory (libs-snapshot)"  at "http://build.ticketfly.com/artifactory/libs-snapshot-local",
  "Ticketfly Artifactory (libs-release)"   at "http://build.ticketfly.com/artifactory/libs-release-local"
)

publishTo := {
  val tflyArtifactory = "http://build.ticketfly.com/artifactory/"
  if (isSnapshot.value)
    Some("tfly-snapshot" at tflyArtifactory + "libs-snapshot-local")
  else
    Some("tfly-release" at tflyArtifactory + "libs-release-local")
}
