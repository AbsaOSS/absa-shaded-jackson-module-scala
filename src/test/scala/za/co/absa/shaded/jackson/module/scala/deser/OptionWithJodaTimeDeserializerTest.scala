package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.datatype.joda.JodaModule
import za.co.absa.shaded.jackson.module.scala.DefaultScalaModule

private case class OptionalInt(x: Option[Int])

class OptionWithJodaTimeDeserializerTest extends DeserializerTest {

  def module: DefaultScalaModule.type = DefaultScalaModule

  "DefaultScalaModule" should "deserialize a case class with Option without JodaModule" in {
    deserialize(stringValue, classOf[OptionalInt]) should be (OptionalInt(Some(123)))
  }

  it should "deserialize a case class with Option with JodaModule" in {
    val mapper = newMapper.registerModule(new JodaModule)
    mapper.readValue(stringValue, classOf[OptionalInt]) should be (OptionalInt(Some(123)))
  }

  val stringValue = """{"x":123}"""
}
