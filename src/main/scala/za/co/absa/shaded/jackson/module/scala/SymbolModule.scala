package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.module.scala.deser.SymbolDeserializerModule
import za.co.absa.shaded.jackson.module.scala.ser.SymbolSerializerModule

/**
 * Adds support for serializing and deserializing Scala Symbols without the '.
 */
trait SymbolModule extends SymbolSerializerModule with SymbolDeserializerModule {
  override def getModuleName: String = "SymbolModule"
}
