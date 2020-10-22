package loadtests.foodservice

import actions.ConfigurationsFromEnv
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class Menu extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(ConfigurationsFromEnv.getURL)
    .header(ConfigurationsFromEnv.getAuthHeaderName, ConfigurationsFromEnv.getToken)
    .contentTypeHeader("application/json")

  val scn: ScenarioBuilder = scenario("Get menu")
    .exec(http("get menu")
      .get("/api/menu")
      .check(status is 200)
    )

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
