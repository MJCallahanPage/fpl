package models.player

import config.AppConfig
import play.api.Logging
import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}
import utils.CurrencyFormatter

import scala.math.BigDecimal.RoundingMode

case class Player(firstName: String,
                  lastName: String,
                  shirtName: String,
                  teamID: Int,
                  positionId: Int,
                  image: String,
                  value: Int,
                  stats: Stats,
                  fplStats: FplStats,
                  status: Status,
                  transfers: Transfers
                 ) extends CurrencyFormatter with Logging {
  val name = s"$firstName $lastName"
  val price: String = currencyFormat(BigDecimal(value)/10)

  val positionMap = Map(1 -> "Goalkeeper", 2 -> "Defender", 3 -> "Midfielder", 4 -> "Attacker")
  val position = positionMap(positionId)

  val pointsPerMinute: BigDecimal = {
    if(stats.minutes == 0) { 0 } else {
      (BigDecimal(fplStats.points) / stats.minutes).setScale(4, RoundingMode.UP)
    }
  }

  val avgPointsPerGame = pointsPerMinute * 90
  def imageUrl(implicit appConfig: AppConfig) = appConfig.fplPlayerAsset(image)
}

object Player {
  implicit val reads: Reads[Player] = (
    (__ \ "first_name").read[String] and
      (__ \ "second_name").read[String] and
      (__ \ "web_name").read[String] and
      (__ \ "team").read[Int] and
      (__ \ "element_type").read[Int] and
      (__ \ "photo").read[String] and
      (__ \ "now_cost").read[Int] and
      Stats.reads and
      FplStats.reads and
      Status.reads and
      Transfers.reads
    ) (Player.apply _)
}