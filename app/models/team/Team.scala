package models.team

import models.player.Player
import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Team(id: Int,
                name: String,
                abbr: String,
                players: Seq[Player] = Seq(),
                performance: Performance,
                rating: Rating
               )

object Team {
  implicit val reads: Reads[Team] = (
    (__ \ "id").read[Int] and
      (__ \ "name").read[String] and
      (__ \ "short_name").read[String] and
      Reads.pure(Seq()) and
      Performance.reads and
      Rating.reads
    ) (Team.apply _)
}