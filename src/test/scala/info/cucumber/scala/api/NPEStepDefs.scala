package info.cucumber.scala.api

import info.cucumber.scala.ScalaDsl

class NPEStepDefs extends ScalaDsl with EN {

  Given("""(foo)?bar""") { withFoo: String =>
    // Should not throw an NPE.
  }

  When("""(foo)?(bar)?x""") { (withFoo: String, withBar: String) =>
  }
}
