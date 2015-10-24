package info.cucumber.scala.api

import info.cucumber.scala.ScalaDsl

trait En {
  this: ScalaDsl =>

  val Given = new Step

  val And = new Step

  val But = new Step

  val When = new Step

  val Then = new Step
}
