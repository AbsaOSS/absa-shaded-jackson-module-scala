package za.co.absa.shaded.jackson.module.scala


class DefaultScalaModuleTest extends BaseSpec {

  "DefaultScalaModule" should "have a sensible version" in {
    val version = DefaultScalaModule.version
    version.getMajorVersion should be >= 2
    version.getArtifactId should be ("jackson-module-scala")
    version.getGroupId should be ("za.co.absa.shaded.jackson.module")
  }
}
