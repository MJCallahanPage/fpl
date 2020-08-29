package models.player

import play.api.libs.json.{Reads, __}
import play.api.libs.functional.syntax._


case class FplStats(points: Int,
                    gameweekPoints: Int,
                    form: BigDecimal,
                    expectedPoints: Option[BigDecimal],
                    expectedPointsNext: BigDecimal,
                    bonus: Int,
                    bps: Int,
                    influence: BigDecimal,
                    creativity: BigDecimal,
                    threat: BigDecimal,
                    ictIndex: BigDecimal,
                    dreamteam: Boolean,
                    dreamteamCount: Int,
                    valueChangeGW: Int,
                    valueChange: Int
                   )

object FplStats {
  implicit val reads: Reads[FplStats] = (
    (__ \ "total_points").read[Int] and
      (__ \ "event_points").read[Int] and
      (__ \ "form").read[BigDecimal] and
      (__ \ "ep_this").readNullable[BigDecimal] and
      (__ \ "ep_next").read[BigDecimal] and
      (__ \ "bonus").read[Int] and
      (__ \ "bps").read[Int] and
      (__ \ "influence").read[BigDecimal] and
      (__ \ "creativity").read[BigDecimal] and
      (__ \ "threat").read[BigDecimal] and
      (__ \ "ict_index").read[BigDecimal] and
      (__ \ "in_dreamteam").read[Boolean] and
      (__ \ "dreamteam_count").read[Int] and
      (__ \ "cost_change_event").read[Int] and
      (__ \ "cost_change_start").read[Int]
    ) (FplStats.apply _)
}
