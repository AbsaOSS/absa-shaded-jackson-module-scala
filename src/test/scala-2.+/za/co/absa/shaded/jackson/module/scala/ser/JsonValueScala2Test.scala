package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.annotation.JsonValue
import za.co.absa.shaded.jackson.databind.Module
import za.co.absa.shaded.jackson.module.scala.DefaultScalaModule

import scala.annotation.meta.getter

object JsonValueScala2Test {
  case class ValueClass(@(JsonValue @getter) value: String)
}

class JsonValueScala2Test extends SerializerTest {
  import JsonValueScala2Test._

  override def module: Module = DefaultScalaModule

  "DefaultScalaModule" should "support @JsonValue" in {
    serialize(ValueClass("Foo")) should equal (""""Foo"""")
  }
}
