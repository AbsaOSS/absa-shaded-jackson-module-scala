package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.core.JsonParser
import za.co.absa.shaded.jackson.databind.deser.Deserializers
import za.co.absa.shaded.jackson.databind.deser.std.StdDeserializer
import za.co.absa.shaded.jackson.databind._
import za.co.absa.shaded.jackson.module.scala.JacksonModule
import za.co.absa.shaded.jackson.module.scala.util.ClassW

import scala.languageFeature.postfixOps

private class ScalaObjectDeserializer(clazz: Class[_]) extends StdDeserializer[Any](classOf[Any]) {
  override def deserialize(p: JsonParser, ctxt: DeserializationContext): Any = {
    clazz.getDeclaredFields.find(_.getName == "MODULE$").map(_.get(null)).getOrElse(null)
  }
}

private object ScalaObjectDeserializerResolver extends Deserializers.Base {
  override def findBeanDeserializer(javaType: JavaType, config: DeserializationConfig, beanDesc: BeanDescription): JsonDeserializer[_] = {
    val clazz = javaType.getRawClass
    if (ClassW(clazz).isScalaObject)
      new ScalaObjectDeserializer(clazz)
    else null
  }
}

trait ScalaObjectDeserializerModule extends JacksonModule {
  override def getModuleName: String = "ScalaObjectDeserializerModule"
  this += { _ addDeserializers ScalaObjectDeserializerResolver }
}

object ScalaObjectDeserializerModule extends ScalaObjectDeserializerModule
