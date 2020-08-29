package models.player

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}


case class Transfers(transfersInGW: Int,
                     transfersOutGW: Int,
                     transfersIn: Int,
                     transfersOut: Int,
                     selectedBy: BigDecimal
                    )

object Transfers {
  implicit val reads: Reads[Transfers] = (
    (__ \ "transfers_in_event").read[Int] and
      (__ \ "transfers_out_event").read[Int] and
      (__ \ "transfers_in").read[Int] and
      (__ \ "transfers_out").read[Int] and
      (__ \ "selected_by_percent").read[BigDecimal]
    )(Transfers.apply _)
}