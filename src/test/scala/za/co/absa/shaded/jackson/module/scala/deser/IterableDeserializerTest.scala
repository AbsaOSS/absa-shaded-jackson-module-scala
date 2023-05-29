package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.core.`type`.TypeReference

class IterableDeserializerTest extends DeserializationFixture {

  // Testing values
  val listJson =  "[1,2,3,4,5,6]"
  val listScala: Range.Inclusive = 1 to 6

  behavior of "ObjectMapper"

  it should "deserialize a list to an Iterable" in { f =>
    val result = f.readValue(listJson, new TypeReference[Iterable[Int]] {})
    result should equal (listScala)
  }
}
