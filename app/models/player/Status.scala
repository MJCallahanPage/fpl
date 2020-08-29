package models.player

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Status(status: String,
                  statusInfo: String,
                  statusInfoTimeStamp: Option[String],
                  chancePlaying: Option[Int],
                  chancePlayingNext: Option[Int]
                 )

object Status {
  implicit val reads: Reads[Status] = (
    (__ \ "status").read[String] and
      (__ \ "news").read[String] and
      (__ \ "news_added").readNullable[String] and
      (__ \ "chance_of_playing_this_round").readNullable[Int] and
      (__ \ "chance_of_playing_next_round").readNullable[Int]
    )(Status.apply _)
}