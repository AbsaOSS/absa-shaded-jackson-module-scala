package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.{SortedMapDeserializerModule, UnsortedMapDeserializerModule}
import za.co.absa.shaded.jackson.module.scala.ser.MapSerializerModule

trait MapModule
  extends MapSerializerModule
    with UnsortedMapDeserializerModule
    with SortedMapDeserializerModule {
  override def getModuleName: String = "MapModule"
}
