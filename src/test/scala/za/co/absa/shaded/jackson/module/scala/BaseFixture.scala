package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.databind.ObjectMapper
import org.scalatest.Outcome
import org.scalatest.flatspec.FixtureAnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BaseFixture extends FixtureAnyFlatSpec with Matchers {

  type FixtureParam = ObjectMapper

  def withFixture(test: OneArgTest): Outcome = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
    test(mapper)
  }
}
