import za.co.absa.shaded.jackson.module.scala.DefaultScalaModule
import za.co.absa.shaded.jackson.module.scala.ser.SerializerTest

case class UnpackagedCaseClass(intValue: Int, stringValue: String)

class UnpackagedTest extends SerializerTest {

  def module: DefaultScalaModule.type = DefaultScalaModule

  behavior of "DefaultScalaModule"

  it should "serialize a case class not in a package" in {
    val result = serialize(UnpackagedCaseClass(1, "foo"))
    result should be ("""{"intValue":1,"stringValue":"foo"}""")
  }
}
