package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.databind.json.JsonMapper

class QuxScalaObjectMapperTest extends BaseSpec {
  "An ObjectMapper with the ScalaObjectMapper mixin" should "deserialize Qux" in {
    val objectMapper = JsonMapper
        .builder().addModule(DefaultScalaModule).build() :: ScalaObjectMapper
    val qux = objectMapper.readValue[Qux]("""{"qux": {"num": "3"}}""")
    qux.qux.num shouldEqual 3
  }
}
