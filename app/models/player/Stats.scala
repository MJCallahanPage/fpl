package models.player

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Stats(minutes: Int,
                 goals: Int,
                 assists: Int,
                 yellows: Int,
                 reds: Int,
                 ownGoals: Int,
                 penaltiesMissed: Int,
                 conceded: Int,
                 cleanSheets: Int,
                 saves: Int,
                 penaltiesSaved: Int
                )

object Stats {
  implicit val reads: Reads[Stats] = (
    (__ \ "minutes").read[Int] and
      (__ \ "goals_scored").read[Int] and
      (__ \ "assists").read[Int] and
      (__ \ "yellow_cards").read[Int] and
      (__ \ "red_cards").read[Int] and
      (__ \ "own_goals").read[Int] and
      (__ \ "penalties_missed").read[Int] and
      (__ \ "goals_conceded").read[Int] and
      (__ \ "clean_sheets").read[Int] and
      (__ \ "saves").read[Int] and
      (__ \ "penalties_saved").read[Int]
    ) (Stats.apply _)

}
