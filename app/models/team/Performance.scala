package models.team

import play.api.libs.json.{Reads, __}
import play.api.libs.functional.syntax._


case class Performance(position: Int,
                       played: Int,
                       win: Int,
                       draw: Int,
                       loss: Int,
                       points: Int,
                       form: String
                      ) {
  val scored: Int = 0 //to be calculated from fixtures in future.
  val conceded: Int = 0 //to be calculated from fixtures in future.

}

object Performance {
  implicit val reads: Reads[Performance] = (
    (__ \ "position").read[Int] and
      (__ \ "played").read[Int] and
      (__ \ "win").read[Int] and
      (__ \ "draw").read[Int] and
      (__ \ "loss").read[Int] and
      (__ \ "points").read[Int] and
      (__ \ "form").read[String]
    ) (Performance.apply _)
}
