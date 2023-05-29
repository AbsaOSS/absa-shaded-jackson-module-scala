package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.databind.{JsonNode, ObjectMapper}
import za.co.absa.shaded.jackson.module.scala.JacksonTest

trait SerializerTest extends JacksonTest {
  def serialize(value: Any, mapper: ObjectMapper = newMapper): String = mapper.writeValueAsString(value)

  def jsonOf(s: String): JsonNode = newMapper.readTree(s)
}
