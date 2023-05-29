package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.TupleDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.TupleSerializerModule

/**
 * Adds support for serializing and deserializing Scala Tuples.
 */
trait TupleModule extends TupleSerializerModule with TupleDeserializerModule {
  override def getModuleName: String = "TupleModule"
}
