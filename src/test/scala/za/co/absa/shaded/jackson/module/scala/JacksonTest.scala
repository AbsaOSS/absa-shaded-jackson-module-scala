package za.co.absa.shaded.jackson.module.scala

import za.co.absa.shaded.jackson.databind.{Module, ObjectMapper}
import za.co.absa.shaded.jackson.databind.json.JsonMapper

abstract class JacksonTest extends BaseSpec {
  def module: Module

  def newBuilder: JsonMapper.Builder = {
    JsonMapper.builder().addModule(module)
  }

  def newMapper: ObjectMapper = newBuilder.build()
}
