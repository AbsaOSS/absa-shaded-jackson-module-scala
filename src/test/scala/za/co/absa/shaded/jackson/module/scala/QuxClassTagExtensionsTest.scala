package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.databind.json.JsonMapper

class QuxClassTagExtensionsTest extends BaseSpec {
  "An ObjectMapper with the ClassTagExtensions mixin" should "deserialize Qux" in {
    val objectMapper = JsonMapper
      .builder().addModule(DefaultScalaModule).build() :: ClassTagExtensions
    val qux = objectMapper.readValue[Qux]("""{"qux": {"num": "3"}}""")
    qux.qux.num shouldEqual 3
  }
}
