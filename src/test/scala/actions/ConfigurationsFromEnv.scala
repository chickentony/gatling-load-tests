package actions

import io.github.cdimascio.dotenv.Dotenv

object ConfigurationsFromEnv {
  val dotenv: Dotenv = Dotenv.load()

  lazy val getURL: String = dotenv.get("URL")
  lazy val getAuthHeaderName: String = dotenv.get("AUTH_HEADER")
  lazy val getToken: String = dotenv.get("TOKEN")
}
