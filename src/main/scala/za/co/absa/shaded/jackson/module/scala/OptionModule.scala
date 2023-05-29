package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.OptionDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.OptionSerializerModule

/**
 * Adds support for serializing and deserializing Scala Options.
 */
trait OptionModule extends OptionSerializerModule with OptionDeserializerModule {
  override def getModuleName: String = "OptionModule"
}
