package com.fasterxml.jackson.module.scala.ser

import com.fasterxml.jackson.annotation.{JsonIdentityInfo, ObjectIdGenerators}
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, JacksonModule}

object ObjectIdSerializerTest {
  @JsonIdentityInfo(generator = classOf[ObjectIdGenerators.IntSequenceGenerator])
  case class Foo(x: Int)

  case class FooPair(l: Foo, r: Foo)

  //https://github.com/FasterXML/jackson-module-scala/issues/443
  case class ManyFooPairs(foos: Seq[FooPair])
}

class ObjectIdSerializerTest extends SerializerTest {
  import ObjectIdSerializerTest._
  lazy val module = DefaultScalaModule

  "An ObjectMapper" should "serialize with ids when @JsonIdentityInfo is used" in {
    val f1 = Foo(1)
    val f2 = Foo(2)
    val result = serialize(ManyFooPairs(Seq(FooPair(f1, f1), FooPair(f1, f2))))
    result should be ("""{"foos":[{"l":{"@id":1,"x":1},"r":1},{"l":1,"r":{"@id":2,"x":2}}]}""")
  }
}
