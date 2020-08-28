package config

import javax.inject.Inject
import play.api.Configuration

class AppConfig @Inject()(configuration: Configuration){

  val fplUrl = configuration.get[String]("connectors.fpl.url")

}
