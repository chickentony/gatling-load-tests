package loadtests

import io.gatling.core.Predef.{atOnceUsers, scenario}
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.core.Predef._

class Order extends Simulation {
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://lapkoshka.ru")
    .contentTypeHeader("application/json")
    .header("x-auth-token", "20f12688-7f10-43cb-a120-3d06edb7f03c")

  val scn: ScenarioBuilder = scenario("Create order")
    .exec(http("Order")
      .post("/api/order")
      .body(StringBody(
        "{\n   \"items\":[\n   \n      {\n         \"id\":186,\n         \"count\": 1\n      }\n   ],\n   \"address\":\"В ПЕРЕПЕЧЕИНО ПЛИЗ\",\n   \"phone\":\"89022621111\",\n   \"comment\":\"Тестовый комментарий\",\n   \"paymentTypeId\": 1,\n   \"name\": \"Artemka\",\n   \"pickup\": false\n}"
      ))
    )

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}