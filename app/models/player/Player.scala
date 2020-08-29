package models.player

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}
import utils.CurrencyFormatter

case class Player(firstName: String,
                  lastName: String,
                  shirtName: String,
                  teamID: Int,
                  positionId: Int,
                  value: Int,
                  stats: Stats,
                  fplStats: FplStats,
                  status: Status,
                  transfers: Transfers
                 ) extends CurrencyFormatter{
  val name = s"$firstName $lastName"
  val price: String = currencyFormat(BigDecimal(value)/10)
}

object Player {
  implicit val reads: Reads[Player] = (
    (__ \ "first_name").read[String] and
      (__ \ "second_name").read[String] and
      (__ \ "web_name").read[String] and
      (__ \ "team").read[Int] and
      (__ \ "element_type").read[Int] and
      (__ \ "now_cost").read[Int] and
      Stats.reads and
      FplStats.reads and
      Status.reads and
      Transfers.reads
    ) (Player.apply _)
}