package za.co.absa.shaded.jackson.module.scala.experimental

import za.co.absa.shaded.jackson.databind.ObjectMapper

/**
 * @deprecated use [[za.co.absa.shaded.jackson.module.scala.ScalaObjectMapper]]
 */
@deprecated("use za.co.absa.shaded.jackson.module.scala.ScalaObjectMapper", "2.12.1")
trait ScalaObjectMapper extends za.co.absa.shaded.jackson.module.scala.ScalaObjectMapper {
  self: ObjectMapper =>
}
