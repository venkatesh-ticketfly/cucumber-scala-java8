package info.cucumber.scala.guice

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(strict = true,
  features = Array("src/test/resources/info/cucumber/scala/guice"),
  tags = Array("~@ignore"),
  plugin = Array("pretty",
    "html:target/html/GuiceFeatures/",
    "junit:target/junit/GuiceFeatures.xml"))
class GuiceFeatures
