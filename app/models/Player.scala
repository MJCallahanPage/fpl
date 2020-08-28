package models

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Player(firstName: String,
                  lastName: String,
                  shirtName: String,
                  form: BigDecimal,
                  teamID: Int) {
  val name = s"$firstName $lastName"
}

object Player {
  implicit val reads: Reads[Player] = (
    (__ \ "first_name").read[String] and
      (__ \ "second_name").read[String] and
      (__ \ "web_name").read[String] and
      (__ \ "form").read[BigDecimal] and
      (__ \ "team").read[Int]
    )(Player.apply _)
}