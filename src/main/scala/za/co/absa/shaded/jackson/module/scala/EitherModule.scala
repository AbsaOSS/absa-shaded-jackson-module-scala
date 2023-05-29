package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.EitherDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.EitherSerializerModule

trait EitherModule extends EitherDeserializerModule with EitherSerializerModule {
  override def getModuleName: String = "EitherModule"
}
