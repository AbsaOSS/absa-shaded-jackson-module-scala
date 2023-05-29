package za.co.absa.shaded.jackson.module.scala

import scala.beans.BeanProperty

class EnumContainer {
	@BeanProperty
	var day: Weekday.Value = Weekday.Fri
}
