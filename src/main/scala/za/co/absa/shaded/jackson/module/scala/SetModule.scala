package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.{SortedSetDeserializerModule, UnsortedSetDeserializerModule}

trait SetModule extends UnsortedSetDeserializerModule with SortedSetDeserializerModule {
  override def getModuleName: String = "SetModule"
}
