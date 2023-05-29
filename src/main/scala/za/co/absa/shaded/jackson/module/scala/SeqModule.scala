package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.SeqDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.IterableSerializerModule

/**
 * Adds support for serializing and deserializing Scala sequences.
 */
trait SeqModule extends IterableSerializerModule with SeqDeserializerModule {
  override def getModuleName: String = "SeqModule"
}
