package za.co.absa.shaded.jackson.module.scala.ser

import za.co.absa.shaded.jackson.databind._
import za.co.absa.shaded.jackson.databind.`type`.{MapLikeType, TypeFactory}
import za.co.absa.shaded.jackson.databind.jsontype.TypeSerializer
import za.co.absa.shaded.jackson.databind.ser.Serializers
import za.co.absa.shaded.jackson.databind.ser.std.StdDelegatingSerializer
import za.co.absa.shaded.jackson.databind.util.StdConverter
import za.co.absa.shaded.jackson.module.scala.modifiers.MapTypeModifierModule

import scala.collection.JavaConverters._
import scala.collection.Map

private class MapConverter(inputType: JavaType, config: SerializationConfig)
  extends StdConverter[Map[_,_],java.util.Map[_,_]]
{
  def convert(value: Map[_,_]): java.util.Map[_,_] = {
    val m = if (config.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
      value
    } else {
      value.filter(_._2 != None)
    }
    m.asJava
  }


  override def getInputType(factory: TypeFactory) = inputType

  override def getOutputType(factory: TypeFactory) =
    factory.constructMapType(classOf[java.util.Map[_,_]], inputType.getKeyType, inputType.getContentType)
      .withTypeHandler(inputType.getTypeHandler)
      .withValueHandler(inputType.getValueHandler)
}

private object MapSerializerResolver extends Serializers.Base {

  private val BASE_CLASS = classOf[collection.Map[_,_]]
  private val JSONSERIALIZABLE_CLASS = classOf[JsonSerializable]

  override def findMapLikeSerializer(config: SerializationConfig,
                                     mapLikeType : MapLikeType,
                                     beanDesc: BeanDescription,
                                     keySerializer: JsonSerializer[AnyRef],
                                     elementTypeSerializer: TypeSerializer,
                                     elementValueSerializer: JsonSerializer[AnyRef]): JsonSerializer[_] = {


    val rawClass = mapLikeType.getRawClass

    if (!BASE_CLASS.isAssignableFrom(rawClass) || JSONSERIALIZABLE_CLASS.isAssignableFrom(rawClass)) None.orNull
    else new StdDelegatingSerializer(new MapConverter(mapLikeType, config))
  }

}

trait MapSerializerModule extends MapTypeModifierModule {
  override def getModuleName: String = "MapSerializerModule"
  this += MapSerializerResolver
}
