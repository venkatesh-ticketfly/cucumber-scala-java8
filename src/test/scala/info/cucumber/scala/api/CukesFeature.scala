package info.cucumber.scala.api

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(strict = true,
  features = Array("src/test/resources/info/cucumber/scala/cukes.feature"),
  tags = Array("~@ignore"),
  plugin = Array("pretty", "html:target/cucumber_html", "junit:target/cucumber_junit"))
class CukesFeature
