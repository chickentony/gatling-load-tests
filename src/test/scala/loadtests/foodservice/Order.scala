package loadtests.foodservice

import actions.ConfigurationsFromEnv
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


class Order extends Simulation {
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(ConfigurationsFromEnv.getURL)
    .contentTypeHeader("application/json")
    .header(ConfigurationsFromEnv.getAuthHeaderName, ConfigurationsFromEnv.getToken)

  val scn: ScenarioBuilder = scenario("Create order")
    .exec(http("Order")
      .post("/api/order")
      .body(StringBody(
        """
          | {
          |   "items":[
          |
          |      {
          |         "id":186,
          |         "count": 1
          |      }
          |   ],
          |   "address":"В ПЕРЕПЕЧЕИНО ПЛИЗ",
          |   "phone":"89022621111",
          |   "comment":"Тестовый комментарий",
          |   "paymentTypeId": 1,
          |   "name": "Artemka",
          |   "pickup": false
          |}
          |""".stripMargin
      ))
      .asJson
      .check(status is 200)
    )

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}
