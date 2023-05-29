package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.ser.IterableSerializerModule

/**
 * Adds support for serializing Scala Iterables.
 */
trait IterableModule extends IterableSerializerModule {
  override def getModuleName: String = "IterableModule"
}
