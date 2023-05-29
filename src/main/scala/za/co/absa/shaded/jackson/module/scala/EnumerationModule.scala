package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.EnumerationDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.EnumerationSerializerModule

/**
 * Adds serialization and deserialization support for Scala Enumerations.
 */
trait EnumerationModule extends EnumerationSerializerModule with EnumerationDeserializerModule {
  override def getModuleName: String = "EnumerationModule"
}
