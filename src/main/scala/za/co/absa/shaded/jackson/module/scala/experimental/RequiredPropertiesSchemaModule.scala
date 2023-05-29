package za.co.absa.shaded.jackson.module.scala.experimental

import za.co.absa.shaded.jackson.databind.introspect.{AnnotatedMember, NopAnnotationIntrospector}

/**
 * @deprecated use [[za.co.absa.shaded.jackson.module.scala.DefaultRequiredAnnotationIntrospector]]
 */
@deprecated("use za.co.absa.shaded.jackson.module.scala.DefaultRequiredAnnotationIntrospector", "2.12.1")
object DefaultRequiredAnnotationIntrospector extends NopAnnotationIntrospector {
  override def hasRequiredMarker(m: AnnotatedMember) =
    za.co.absa.shaded.jackson.module.scala.DefaultRequiredAnnotationIntrospector.hasRequiredMarker(m)

}

/**
 * @deprecated use [[za.co.absa.shaded.jackson.module.scala.RequiredPropertiesSchemaModule]]
 */
@deprecated("use za.co.absa.shaded.jackson.module.scala.RequiredPropertiesSchemaModule", "2.12.1")
trait RequiredPropertiesSchemaModule extends za.co.absa.shaded.jackson.module.scala.RequiredPropertiesSchemaModule
