package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.core.JsonGenerator
import za.co.absa.shaded.jackson.databind.{JsonSerializable, SerializerProvider}
import za.co.absa.shaded.jackson.databind.jsontype.TypeSerializer

import scala.collection.immutable.AbstractMap

class SerializableMap extends AbstractMap[String, String] with JsonSerializable {

  // Members declared in scala.collection.MapLike
  def get(key: String): Option[String] = None
  def iterator: Iterator[(String, String)] = throw new IllegalArgumentException("This shouldn't get called")

  override def serialize(jgen: JsonGenerator, provider: SerializerProvider): Unit = {
    jgen.writeNumber(10)
  }
  override def serializeWithType(jgen: JsonGenerator, provider: SerializerProvider, typeSer: TypeSerializer): Unit = {
    serialize(jgen, provider)
  }

  override def removed(key: String): Map[String, String] = ???

  override def updated[V1 >: String](key: String, value: V1): Map[String, V1] = ???
}
