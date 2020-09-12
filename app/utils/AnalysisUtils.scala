package utils

import models.{FPLDataModel, OpponentAnalysis}
import models.fixtures.Fixtures

trait AnalysisUtils {

  implicit val fplDataModel: FPLDataModel
  implicit val fixtures: Fixtures
  //TODO handle double gameweeks

  def analyseOpponent(team: String, gameweek: Int): OpponentAnalysis = {
    val opponent = fplDataModel.teamFromId(fixtures.findOpponent(team, gameweek)._1)
    val home: Boolean = fixtures.findOpponent(team, gameweek)._2
    OpponentAnalysis(
      opponent = opponent.name,
      home = home,
      opponentRating = if(home) opponent.rating.overallAway else opponent.rating.overallHome,
      opponentAttackRating = if(home) opponent.rating.attackAway else opponent.rating.attackHome,
      opponentDefenceRating = if(home) opponent.rating.defenceAway else opponent.rating.defenceHome,
      opponentForm = opponent.performance.form.getOrElse("")
    )
  }

}
