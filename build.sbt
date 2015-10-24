name := "cucumber_scala_java8"

version := "1.0"

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
