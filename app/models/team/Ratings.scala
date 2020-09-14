package models.team

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}
import utils.MathUtils

case class Ratings(strength: BigDecimal,
                   overallHome: BigDecimal,
                   overallAway: BigDecimal,
                   attackHome: BigDecimal,
                   attackAway: BigDecimal,
                   defenceHome: BigDecimal,
                   defenceAway: BigDecimal
                  ) extends MathUtils {
}

object Ratings extends Enumeration {

  type Rating = Value

  val Overall = Value("Overall")
  val Defence = Value("Defence")
  val Attack = Value("Attack")

  implicit val reads: Reads[Ratings] = (
    (__ \ "strength").read[BigDecimal] and
      (__ \ "strength_overall_home").read[BigDecimal] and
      (__ \ "strength_overall_away").read[BigDecimal] and
      (__ \ "strength_attack_home").read[BigDecimal] and
      (__ \ "strength_attack_away").read[BigDecimal] and
      (__ \ "strength_defence_home").read[BigDecimal] and
      (__ \ "strength_defence_away").read[BigDecimal]
    ) (Ratings.apply _)
}
