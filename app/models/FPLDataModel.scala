package models

import play.api.libs.json.Reads._
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class FPLDataModel(players: Seq[Player],
                       teams: Seq[Team]) {

  private val playersForTeam = (team: Team) => team.copy(players = players.filter(_.teamID == team.id))
  val teamsWithPlayers: Seq[Team] = teams map playersForTeam

}

object FPLDataModel {
  implicit val reads: Reads[FPLDataModel] = (
    (__ \ "elements").read[Seq[Player]] and
      (__ \ "teams").read[Seq[Team]]
  )(FPLDataModel.apply _)
}
