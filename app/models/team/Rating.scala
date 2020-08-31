package models.team

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}
import utils.MathUtils

case class Rating(strength: BigDecimal,
                  overallHome: BigDecimal,
                  overallAway: BigDecimal,
                  attackHome: BigDecimal,
                  attackAway: BigDecimal,
                  defenceHome: BigDecimal,
                  defenceAway: BigDecimal
                 ) extends MathUtils {

  //TODO standardise ratings so they are more usable


}

object Rating {
  implicit val reads: Reads[Rating] = (
    (__ \ "strength").read[BigDecimal] and
      (__ \ "strength_overall_home").read[BigDecimal] and
      (__ \ "strength_overall_away").read[BigDecimal] and
      (__ \ "strength_attack_home").read[BigDecimal] and
      (__ \ "strength_attack_away").read[BigDecimal] and
      (__ \ "strength_defence_home").read[BigDecimal] and
      (__ \ "strength_defence_away").read[BigDecimal]
    ) (Rating.apply _)
}
