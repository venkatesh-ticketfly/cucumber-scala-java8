package info.cucumber.scala.guice

import com.google.inject.{Injector, Stage, Guice}
import cucumber.api.guice.CucumberModules
import cucumber.runtime.java.guice.InjectorSource

class SampleInjectorSource extends InjectorSource {
  override def getInjector: Injector = Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO,
    new SampleGuiceModule)
}
