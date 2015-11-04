package info.cucumber.scala.guice

import javax.inject.Inject

import com.google.inject.Provider
import info.cucumber.scala.ScalaDsl
import info.cucumber.scala.api.EN
import org.scalatest.Matchers._

import scala.collection.mutable

class UnscopedGuiceSteps @Inject() (unscopedObjectProvider: Provider[UnscopedObject]) extends ScalaDsl with EN {

  Given("^an un-scoped instance has been provided in this scenario$") { () =>
    UnscopedGlobalState.objects += unscopedObjectProvider.get()
  }

  When("^another un-scoped instance is provided$") { () =>
    UnscopedGlobalState.objects += unscopedObjectProvider.get()
  }

  Then("""^all (\d+) provided instances are unique instances$""") { (expectedCount: Int) =>
    UnscopedGlobalState.objects += unscopedObjectProvider.get()
    UnscopedGlobalState.objects.toSet should have size expectedCount
  }
}

private object UnscopedGlobalState {
  val objects = mutable.MutableList[UnscopedObject]()
}

class UnscopedObject
