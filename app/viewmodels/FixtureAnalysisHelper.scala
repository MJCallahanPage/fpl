package viewmodels

import models.FPLDataModel
import models.fixtures.Fixtures
import models.team.Club
import models.team.Club.Club
import models.team.Ratings.{Attack, Defence, Overall, Rating}
import play.api.i18n.Messages
import play.api.mvc.{MessagesBaseController, MessagesControllerComponents}
import play.twirl.api.Html
import utils.AnalysisUtils

class FixtureAnalysisHelper()(implicit val fplDataModel: FPLDataModel,
                              implicit val fixtures: Fixtures,
                              val controllerComponents: MessagesControllerComponents,
                              table: views.html.components.table
) extends AnalysisUtils with MessagesBaseController {

  def allTeamsAllFixtures(metric: Rating)(implicit messages: Messages) = {

    table(
      headers = gameweeks(1, 38),
      rows = Club.values.toSeq.map(team => opponentRatings(team, Attack, 1, 38))
    )
  }

  def gameweeks(start: Int, end: Int): Seq[Html] = {
    (start to end).map { gameweek =>
      Html(s"$gameweek")
    }
  }

  def opponentRating(team: Club, metric: Rating, gameweek: Int): Html = {
    Html(s"${
      metric match {
        case Overall => analyseOpponent(team, gameweek).rating
        case Defence => analyseOpponent(team, gameweek).defenceRating
        case Attack => analyseOpponent(team, gameweek).attackRating
      }
    }")
  }

  def opponentRatings(team: Club, metric: Rating ,start: Int, end: Int): Seq[Html] = {
    (start to end).map { gameweek =>
      Html(s"${
        opponentRating(team, metric, gameweek)
      }")
    }
  }
}
