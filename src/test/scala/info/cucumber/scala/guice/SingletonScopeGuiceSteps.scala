package info.cucumber.scala.guice

import javax.inject.Inject

import com.google.inject.Provider
import cucumber.runtime.java.guice.ScenarioScoped
import info.cucumber.scala.ScalaDsl
import info.cucumber.scala.api.EN
import org.scalatest.Matchers._

import scala.collection.mutable

@ScenarioScoped
class SingletonScopeGuiceSteps @Inject() (singletonScopeObjectProvider: Provider[SingletonScopeObject]) extends ScalaDsl
  with EN {

  Given("^a singleton scope instance has been provided in this scenario$") { () =>
    SingletonScopeState.objects += singletonScopeObjectProvider.get
  }

  When("^another singleton scope instance is provided$")  { () =>
    SingletonScopeState.objects += singletonScopeObjectProvider.get()
  }

  Then("^all three provided instances are the same singleton instance$") { () =>
    SingletonScopeState.objects.toSet should have size 1
  }

  Given("^a singleton scope instance was provided in the previous scenario$") { () =>
    SingletonScopeState.objects += singletonScopeObjectProvider.get
  }

  Then("^the two provided instances are the same instance$") { () =>
    SingletonScopeState.objects.toSet should have size 1
  }
}

class SingletonScopeObject

object SingletonScopeState {
  val objects = mutable.MutableList[SingletonScopeObject]()
}
