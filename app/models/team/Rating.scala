package models.team

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Rating(strength: Int,
                  overallHome: Int,
                  overallAway: Int,
                  attackHome: Int,
                  attackAway: Int,
                  defenceHome: Int,
                  defenceAway: Int
                 ) {

  //TODO standardise ratings so they are more usable

}

object Rating {
  implicit val reads: Reads[Rating] = (
    (__ \ "strength").read[Int] and
      (__ \ "strength_overall_home").read[Int] and
      (__ \ "strength_overall_away").read[Int] and
      (__ \ "strength_attack_home").read[Int] and
      (__ \ "strength_attack_away").read[Int] and
      (__ \ "strength_defence_home").read[Int] and
      (__ \ "strength_defence_away").read[Int]
    ) (Rating.apply _)
}
