package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.module.scala.JacksonModule

class SymbolDeserializerTest extends DeserializerTest {
  lazy val module = new JacksonModule with SymbolDeserializerModule

  "An ObjectMapper with the SymbolDeserializer" should "deserialize a string into a Symbol" in {
    val result = deserialize(""""symbol"""", classOf[Symbol])
    result should equal (Symbol("symbol"))
  }
}
