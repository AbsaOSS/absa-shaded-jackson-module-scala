package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.databind.DeserializationFeature
import za.co.absa.shaded.jackson.databind.exc.UnrecognizedPropertyException
import za.co.absa.shaded.jackson.module.scala.deser.IgnorableFieldDeserializerTest.ExtractFields
import za.co.absa.shaded.jackson.module.scala.{DefaultScalaModule, JacksonModule}

object IgnorableFieldDeserializerTest {
  case class ExtractFields(s: String, i: Int)
}

class IgnorableFieldDeserializerTest extends DeserializerTest {

  lazy val module: JacksonModule = DefaultScalaModule

  "An ObjectMapper with the DefaultScalaModule" should "fail if field is not expected" in {
    val mapper = newMapper
    intercept[UnrecognizedPropertyException] {
      mapper.readValue(genJson(100), classOf[ExtractFields])
    }
  }

  it should "succeed if field is not expected" in {
    val mapper = newBuilder
      .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      .build()
    val ef = mapper.readValue(genJson(1000), classOf[ExtractFields])
    ef.s shouldEqual "s"
    ef.i shouldEqual 1
  }

  private def genJson(size: Int): String = {
    s"""{"s":"s","n":${"7" * size},"i":1}"""
  }

}
