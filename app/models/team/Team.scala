package models.team

import config.AppConfig
import models.player.Player
import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Team(id: Int,
                code: Int,
                name: String,     //TODO convert to club enum
                abbr: String,
                players: Seq[Player] = Seq(),
                performance: Performance,
                rating: Ratings
               ) {
  def shirtImageUrl(implicit appConfig: AppConfig) = appConfig.fplShirtAsset(code)
}

object Team {

  implicit val reads: Reads[Team] = (
    (__ \ "id").read[Int] and
      (__ \ "code").read[Int] and
      (__ \ "name").read[String] and
      (__ \ "short_name").read[String] and
      Reads.pure(Seq()) and
      Performance.reads and
      Ratings.reads
    ) (Team.apply _)
}