package info.cucumber.scala.guice

import javax.inject.Inject

import com.google.inject._
import cucumber.runtime.java.guice.ScenarioScoped
import info.cucumber.scala.ScalaDsl
import info.cucumber.scala.api.EN
import org.scalatest.Matchers._

import scala.collection.mutable

@ScenarioScoped
class ScenarioScopedGuiceSteps @Inject() (scenarioScopedObjectProvider: Provider[ScenarioScopedObject]) extends ScalaDsl
    with EN {

  Given("^a scenario scope instance has been provided in this scenario$") { () =>
    ScenarioScopedState.objects += scenarioScopedObjectProvider.get()
  }

  When("^another scenario scope instance is provided$") { () =>
    ScenarioScopedState.objects += scenarioScopedObjectProvider.get()
  }

  Then("^all three provided instances are the same instance$") { () =>
    ScenarioScopedState.objects should have size 3
    ScenarioScopedState.objects.toSet should have size 1
  }

  Given("^a scenario scope instance was provided in the previous scenario$") { () =>
    ScenarioScopedState.objects should not be empty
    ScenarioScopedState.objects += scenarioScopedObjectProvider.get()
  }

  Then("^the two provided instances are different$") { () =>
    ScenarioScopedState.objects.toSet should have size 2
  }
}

private object ScenarioScopedState {
  val objects = mutable.MutableList[ScenarioScopedObject]()
}

class ScenarioScopedObject


