package config

import javax.inject.Inject
import play.api.Configuration

class AppConfig @Inject()(configuration: Configuration){

  val fplUrl = configuration.get[String]("connectors.fpl.url")
  val fplShirtAsset = (code: Int) => s"https://fantasy.premierleague.com/dist/img/shirts/standard/shirt_$code-66.webp"
  val fplPlayerAsset = (image: String) => s"https://resources.premierleague.com/premierleague/photos/players/110x140/p${image.replace(".jpg", ".png")}"

}
