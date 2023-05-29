package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.databind._
import za.co.absa.shaded.jackson.module.scala.introspect.OrderingLocator
import za.co.absa.shaded.jackson.module.scala.modifiers.MapTypeModifierModule

import scala.collection._
import scala.collection.generic.SortedMapFactory
import scala.language.existentials

trait SortedMapDeserializerModule extends MapTypeModifierModule {
  this += (_ addDeserializers new GenericMapFactoryDeserializerResolver[SortedMap, SortedMapFactory] {

    override val CLASS_DOMAIN: Class[Collection[_, _]] = classOf[SortedMap[_, _]]

    override val factories: Iterable[(Class[_], Factory)] = sortFactories(Vector(
      (classOf[SortedMap[_, _]], SortedMap.asInstanceOf[Factory]),
      (classOf[immutable.SortedMap[_, _]], immutable.SortedMap.asInstanceOf[Factory]),
      (classOf[immutable.TreeMap[_, _]], immutable.TreeMap.asInstanceOf[Factory]),
      (classOf[mutable.SortedMap[_, _]], mutable.SortedMap.asInstanceOf[Factory]),
      (classOf[mutable.TreeMap[_, _]], mutable.TreeMap.asInstanceOf[Factory])
    ))

    override def builderFor[K, V](factory: Factory, keyType: JavaType, valueType: JavaType): Builder[K, V] =
      factory.newBuilder[K, V](OrderingLocator.locate[K](keyType))
  })
}
