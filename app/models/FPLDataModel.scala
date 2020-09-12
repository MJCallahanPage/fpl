package models

import models.player.Player
import models.team.{Club, Team}
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json._
import utils.MathUtils

import scala.language.postfixOps

case class FPLDataModel(players: Seq[Player],
                        teams: Seq[Team]) extends MathUtils {

  private val playersForTeam: Team => Team = (team: Team) => team.copy(players = players.filter(_.teamID == team.id))
  val teamsWithPlayers: Seq[Team] = teams map playersForTeam

  private val standardisedRatings: Team => Team = (team: Team) =>
    team.copy(rating = team.rating.copy(
      overallHome = std(team.rating.overallHome, teams.map(team => team.rating.overallHome)),
      overallAway = std(team.rating.overallAway, teams.map(team => team.rating.overallAway)),
      attackHome = std(team.rating.attackHome, teams.map(team => team.rating.attackHome)),
      attackAway = std(team.rating.attackAway, teams.map(team => team.rating.attackAway)),
      defenceHome = std(team.rating.defenceHome, teams.map(team => team.rating.defenceHome)),
      defenceAway = std(team.rating.defenceAway, teams.map(team => team.rating.defenceAway))
    ))
  val teamsWithStandardisedRatings: Seq[Team] = teams map standardisedRatings

  val teamNameFromId: Map[Int, String] = teams.map(_.id) zip teams.map(_.name) toMap
  val teamFromId: Map[Int, Team] = teams.map(_.id) zip teamsWithStandardisedRatings toMap
  val idFromTeam: Map[String, Int] = teams.map(_.name) zip teams.map(_.id) toMap

}

object FPLDataModel {
  implicit val reads: Reads[FPLDataModel] = (
    (__ \ "elements").read[Seq[Player]] and
      (__ \ "teams").read[Seq[Team]]
    ) (FPLDataModel.apply _)
}
