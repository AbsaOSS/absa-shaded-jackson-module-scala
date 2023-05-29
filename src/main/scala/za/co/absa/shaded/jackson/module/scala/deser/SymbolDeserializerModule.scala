package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.core.JsonParser
import za.co.absa.shaded.jackson.databind.deser.Deserializers
import za.co.absa.shaded.jackson.databind.deser.std.StdDeserializer
import za.co.absa.shaded.jackson.databind._
import za.co.absa.shaded.jackson.module.scala.JacksonModule

import scala.languageFeature.postfixOps

private object SymbolDeserializer extends StdDeserializer[Symbol](classOf[Symbol]) {
  override def deserialize(p: JsonParser, ctxt: DeserializationContext): Symbol =
    Symbol(p.getValueAsString)
}

private object SymbolDeserializerResolver extends Deserializers.Base {
  private val SYMBOL = classOf[Symbol]

  override def findBeanDeserializer(javaType: JavaType, config: DeserializationConfig, beanDesc: BeanDescription): JsonDeserializer[Symbol] =
    if (SYMBOL isAssignableFrom javaType.getRawClass)
      SymbolDeserializer
    else null
}

trait SymbolDeserializerModule extends JacksonModule {
  override def getModuleName: String = "SymbolDeserializerModule"
  this += { _ addDeserializers SymbolDeserializerResolver }
}
