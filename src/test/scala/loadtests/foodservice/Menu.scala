package loadtests.foodservice

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class Menu extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://lapkoshka.ru")
    .contentTypeHeader("application/json")
    .header("x-auth-token", "a140556b-a011-4df8-bbc9-f13eae548a73")

  val scn: ScenarioBuilder = scenario("Get menu")
    .exec(http("get menu")
      .get("/api/menu"))

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}