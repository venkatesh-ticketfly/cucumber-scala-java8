package info.cucumber.scala.guice

import com.google.inject.{Scopes, AbstractModule}
import cucumber.api.guice.CucumberScopes

class SampleGuiceModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[ScenarioScopedObject]).in(CucumberScopes.SCENARIO)
    bind(classOf[SingletonScopeObject]).in(Scopes.SINGLETON)
  }
}
