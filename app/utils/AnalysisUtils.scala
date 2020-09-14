package utils

import models.{FPLDataModel, OpponentAnalysis}
import models.fixtures.Fixtures
import models.team.Club.Club

trait AnalysisUtils {

  implicit val fplDataModel: FPLDataModel
  implicit val fixtures: Fixtures
  //TODO handle double gameweeks

  def analyseOpponent(team: Club, gameweek: Int): OpponentAnalysis = {
    val opponent = fplDataModel.teamFromId(fixtures.findOpponent(team, gameweek)._1)
    val home: Boolean = fixtures.findOpponent(team, gameweek)._2
    OpponentAnalysis(
      opponent = opponent.name,
      home = home,
      rating = if(home) opponent.rating.overallAway else opponent.rating.overallHome,
      attackRating = if(home) opponent.rating.attackAway else opponent.rating.attackHome,
      defenceRating = if(home) opponent.rating.defenceAway else opponent.rating.defenceHome,
      form = opponent.performance.form.getOrElse("")
    )
  }

}
