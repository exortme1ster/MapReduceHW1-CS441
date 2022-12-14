package MRTest

import com.typesafe.config.{Config, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class configTest extends AnyFlatSpec with Matchers {

  behavior of "common configuration parameters"
  val config: Config = ConfigFactory.load("application.conf").getConfig("randomLogGenerator")
  val config2: Config = ConfigFactory.load("application.conf").getConfig("map2")

  it should "obtain the Pattern" in {
    config.getString("Pattern") shouldBe "([a-c][e-g][0-3]|[A-Z][5-9][f-w]){5,15}"
  }

  it should "obtain the MinString" in {
    config.getInt("MinString") shouldBe 10
  }

  it should "obtain the MaxString" in {
    config.getInt("MaxString") shouldBe 50
  }

  it should "obtain the Frequency" in {
    config.getDouble("Frequency") shouldBe 0.07
  }

  it should "obtain the MaxCount" in {
    config.getInt("MaxCount") shouldBe 5000
  }

  it should "obtain inputpredata" in {
    config2.getString("inputpredata") shouldBe "C:/Users/vader/IdeaProjects/MapReduceHW1-CS441/src/main/resources/input/moreerrors.log"
  }

  it should "obtain outputpredata" in {
    config2.getString("outputpredata") shouldBe "C:/Users/vader/IdeaProjects/MapReduceHW1-CS441/src/main/resources/output/task2predata"
  }

}