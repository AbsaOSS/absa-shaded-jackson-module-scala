package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.ser.IteratorSerializerModule

trait IteratorModule extends IteratorSerializerModule {
  override def getModuleName: String = "IteratorModule"
}
