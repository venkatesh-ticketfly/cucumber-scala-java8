package info.cucumber.scala.api

import cucumber.api.DataTable
import info.cucumber.scala.ScalaDsl
import info.cucumber.scala.model.{Cukes, Person, Snake}
import org.scalatest.Matchers._
import scala.collection.JavaConversions._
import java.util.{List => JList, Map => JMap}


class CukesStepDefs extends ScalaDsl with EN {

  Given("""^I have (\d+) "([^"]*)" in my belly$"""){ (howMany:Int, what:String) =>

  }

  var calorieCount = 0.0

  Given("""^I have the following foods :$"""){ (table:DataTable) =>
    val maps: JList[JMap[String, String]] = table.asMaps(classOf[String], classOf[String])
    calorieCount = maps.map(_.get("CALORIES")).map(_.toDouble).fold(0.0)(_+_)
  }

  And("""^have eaten (.*) calories today""") { (calories:Double) =>
    calorieCount shouldBe calories
  }

  var intBelly:Int = 0

  Given("""^I have eaten an int (\d+)$"""){ (arg0:Int) =>
    intBelly = arg0
  }

  Then("""^I should have one hundred in my belly$"""){ () =>
    intBelly shouldBe 100
  }

  var longBelly:Long = 0L

  Given("""^I have eaten a long (\d+)$"""){ (arg0:Long) =>
    longBelly = arg0
  }

  Then("""^I should have long one hundred in my belly$"""){ () =>
    longBelly shouldBe 100L
  }

  var stringBelly:String = ""

  Given("""^I have eaten "(.*)"$"""){ (arg0:String) =>
    stringBelly = arg0
  }

  Then("""^I should have numnumnum in my belly$"""){ () =>
    stringBelly shouldBe "numnumnum"
  }

  var doubleBelly:Double = 0.0

  Given("""^I have eaten (.*) doubles$"""){ (arg0:Double) =>
    doubleBelly = arg0
  }

  Then("""^I should have one and a half doubles in my belly$"""){ () =>
    doubleBelly shouldBe 1.5
  }

  var floatBelly:Float = 0.0f

  Given("""^I have eaten (.*) floats$"""){ (arg0:Float) =>
    floatBelly = arg0
  }

  Then("""^I should have one and a half floats in my belly$"""){ () =>
    floatBelly shouldBe 1.5f
  }

  var shortBelly:Short = 0.toShort

  Given("""^I have eaten a short (\d+)$"""){ (arg0:Short) =>
    shortBelly = arg0
  }

  Then("""^I should have short one hundred in my belly$"""){ () =>
    shortBelly shouldBe 100.toShort
  }

  var byteBelly:Byte = 0.toByte

  Given("""^I have eaten a byte (\d+)$"""){ (arg0:Byte) =>
    byteBelly = arg0
  }

  Then("""^I should have two byte in my belly$"""){ () =>
    byteBelly shouldBe 2.toByte
  }

  var bigDecimalBelly:BigDecimal = BigDecimal(0)

  Given("""^I have eaten (.*) big decimals$"""){ (arg0:java.math.BigDecimal) =>
    bigDecimalBelly = arg0
  }

  Then("""^I should have one and a half big decimals in my belly$"""){ () =>
    bigDecimalBelly shouldBe BigDecimal(1.5)
  }

  var bigIntBelly:BigInt = BigInt(0)

  Given("""^I have eaten (\d+) big int$"""){ (arg0:java.math.BigInteger) =>
    bigIntBelly = arg0.intValue()
  }

  Then("""^I should have a ten big int in my belly$"""){ () =>
    bigIntBelly shouldBe BigInt(10)
  }

  var charBelly:Char = 'A'

  Given("""^I have eaten char '(.*)'$"""){ (arg0:Char) =>
    charBelly = 'C'
  }

  Then("""^I should have character C in my belly$"""){ () =>
    charBelly shouldBe 'C'
  }

  var boolBelly:Boolean = false

  Given("""^I have eaten boolean (.*)"""){ (arg0:Boolean) =>
    boolBelly = arg0
  }

  Then("""^I should have truth in my belly$"""){ () =>
    boolBelly shouldBe true
  }

  Given("""^I have a table the sum of all rows should be (\d+) :$"""){ (value:Int, table:DataTable) =>
    table.asList(classOf[String]).drop(1).map(_.toInt).sum shouldBe value
  }

  var snake:Snake = null

  Given("""^I see in the distance ... (.*)$"""){ (s: Snake) =>
    snake = s
  }

  Then("""^I have a snake of length (\d+) moving (.*)$"""){ (size:Int, dir:String) =>
    snake.length shouldBe size
    snake.direction shouldEqual Symbol(dir)
  }

  var person: Person = null

  Given("""^I have a person (.*)""") { (p: Person) =>
    person = p
  }

  Then("""^he should say \"(.*)\"""") { s:String =>
    s shouldBe s"Hello, I'm ${person.name}!"
  }

  var cukes: JList[Cukes] = null

  Given("^I have eaten the following cukes$") { cs: JList[Cukes] =>
    cukes = cs
  }

  Then("""^I should have eaten (\d) cukes$""") { total: Int =>
    cukes.map(_.number).sum shouldBe total
  }

  And("^they should have been (.*)$") { colors: String =>
    cukes.map(_.color).mkString(", ") shouldBe colors
  }
}

class ThenDefs extends ScalaDsl with EN {
  Then("""^I am "([^"]*)"$"""){ (arg0:String) =>
  }
}
