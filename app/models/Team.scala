package models

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Team(id: Int,
                name: String,
                abbr: String,
                players: Seq[Player] = Seq())

object Team {
  implicit val reads: Reads[Team] = (
    (__ \ "id").read[Int] and
      (__ \ "name").read[String] and
      (__ \ "short_name").read[String] and
      Reads.pure(Seq())
    )(Team.apply _)
}