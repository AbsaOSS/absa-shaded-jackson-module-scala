package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.module.scala.BaseFixture
import za.co.absa.shaded.jackson.databind.{JsonSerializable, SerializerProvider}
import za.co.absa.shaded.jackson.databind.jsontype.TypeSerializer
import za.co.absa.shaded.jackson.core.JsonGenerator

object JsonSerializableSpec {
  class SerializableIterable extends JsonSerializable.Base with Iterable[String] {
    override def iterator: Iterator[String] = throw new IllegalArgumentException("This shouldn't get called")
    override def serialize(jgen: JsonGenerator, provider: SerializerProvider): Unit = {
      jgen.writeNumber(10)
    }
    override def serializeWithType(jgen: JsonGenerator, provider: SerializerProvider, typeSer: TypeSerializer): Unit = {
      serialize(jgen, provider)
    }
  }

  class SerializableIterator extends JsonSerializable.Base with Iterator[String] {
    override def serialize(jgen: JsonGenerator, provider: SerializerProvider): Unit = {
      jgen.writeNumber(10)
    }
    override def serializeWithType(jgen: JsonGenerator, provider: SerializerProvider, typeSer: TypeSerializer): Unit = {
      serialize(jgen, provider)
    }

    override def hasNext: Boolean = ???

    override def next(): String = ???
  }
}

class JsonSerializableSpec extends BaseFixture {

  it should "use serialize method in JsonSerializable (Map)" in { mapper =>
    mapper.writeValueAsString(new SerializableMap()) shouldBe "10"
  }
  it should "use serialize method in JsonSerializable (Iterable)" in { mapper =>
    mapper.writeValueAsString(new JsonSerializableSpec.SerializableIterable()) shouldBe "10"
  }
  it should "use serialize method in JsonSerializable (Iterator)" in { mapper =>
    mapper.writeValueAsString(new JsonSerializableSpec.SerializableIterator()) shouldBe "10"
  }
  it should "use serialize method in JsonSerializable (Option[Iterable])" in { mapper =>
    mapper.writeValueAsString(Some(new JsonSerializableSpec.SerializableIterator())) shouldBe "10"
  }
}
