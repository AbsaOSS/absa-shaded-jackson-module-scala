package za.co.absa.shaded.jackson.module.scala.deser

import za.co.absa.shaded.jackson.core.{JsonParser, StreamReadCapability}
import za.co.absa.shaded.jackson.core.util.{JacksonFeatureSet, JsonParserDelegate}

class WithDupsParser(p: JsonParser) extends JsonParserDelegate(p) {
  override def getReadCapabilities: JacksonFeatureSet[StreamReadCapability] = {
    super.getReadCapabilities.`with`(StreamReadCapability.DUPLICATE_PROPERTIES)
  }
}
