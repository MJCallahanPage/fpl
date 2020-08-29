package models

import java.time.Instant

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Player(firstName: String,
                  lastName: String,
                  shirtName: String,
                  form: BigDecimal,
                  teamID: Int,
                  positionId: Int,
                  value: BigDecimal,
                  gameweekPoints: Int,
                  points: Int,
                  selectedBy: BigDecimal,
                  status: String,
                  statusInfo: String,
                  statusInfoTimeStamp: Instant,
                  chancePlaying: Int,
                  chancePlayingNext: Int,
                  expectedPoints: BigDecimal,
                  expectedPointsNext: BigDecimal,
                  minutes: Int,
                  goals: Int,
                  assists: Int,
                  yellows: Int,
                  reds: Int,
                  ownGoals: Int,
                  penaltiesMissed: Int,
                  conceded: Int,
                  cleanSheets: Int,
                  saves: Int,
                  penaltiesSaved: Int,
                  bonus: Int,
                  bps: Int,
                  influence: BigDecimal,
                  creativity: BigDecimal,
                  threat: BigDecimal,
                  ictIndex: BigDecimal,
                  dreamteamCount: Int,
                  valueChangeGW: Int,
                  valueChange: Int,
                  transfersInGW: Int,
                  transfersOutGW: Int,
                  transfersIn: Int,
                  transfersOut: Int
                 ) {
  val name = s"$firstName $lastName"
}

object Player {
  implicit val reads: Reads[Player] = (
    (__ \ "first_name").read[String] and
      (__ \ "second_name").read[String] and
      (__ \ "web_name").read[String] and
      (__ \ "form").read[BigDecimal] and
      (__ \ "team").read[Int] and
      (__ \ "element_type").read[Int] and
      (__ \ "now_cost").read[BigDecimal] and
      (__ \ "event_points").read[Int] and
      (__ \ "total_points").read[Int] and
      (__ \ "selected_by_percent").read[BigDecimal] and
      (__ \ "status").read[String] and
      (__ \ "news").read[String] and
      (__ \ "news_added").read[String] and
      (__ \ "chance_of_playing_this_round").read[BigDecimal] and
      (__ \ "chance_of_playing_next_round").read[BigDecimal] and
      (__ \ "ep_this").read[BigDecimal] and
      (__ \ "ep_next").read[BigDecimal] and
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
      (__ \ "penalties_saved").read[Int] and
      (__ \ "bonus").read[Int] and
      (__ \ "bps").read[Int] and
      (__ \ "influence").read[Int] and
      (__ \ "creativity").read[Int] and
      (__ \ "threat").read[Int] and
      (__ \ "ict_index").read[Int] and
      (__ \ "dreamteam_count").read[Int] and
      (__ \ "cost_change_event").read[Int] and
      (__ \ "cost_change_start").read[Int] and
      (__ \ "transfers_in_event").read[Int] and
      (__ \ "transfers_out_event").read[Int] and
      (__ \ "transfers_in").read[Int] and
      (__ \ "transfers_out").read[Int]
    ) (Player.apply _)
}