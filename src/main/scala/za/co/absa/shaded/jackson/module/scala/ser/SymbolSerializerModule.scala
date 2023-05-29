package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.core.JsonGenerator
import za.co.absa.shaded.jackson.databind.ser.Serializers
import za.co.absa.shaded.jackson.databind._
import za.co.absa.shaded.jackson.module.scala.JacksonModule

import scala.languageFeature.postfixOps

private object SymbolSerializer extends JsonSerializer[Symbol] {
  def serialize(value: Symbol, jgen: JsonGenerator, provider: SerializerProvider): Unit =
    jgen.writeString(value.name)
}

private object SymbolSerializerResolver extends Serializers.Base {
  private val SYMBOL = classOf[Symbol]

  override def findSerializer(config: SerializationConfig, javaType: JavaType, beanDesc: BeanDescription): JsonSerializer[Symbol] =
    if (SYMBOL isAssignableFrom javaType.getRawClass)
      SymbolSerializer
    else None.orNull
}

trait SymbolSerializerModule extends JacksonModule {
  override def getModuleName: String = "SymbolSerializerModule"
  this += { _ addSerializers SymbolSerializerResolver }
}
