package models.fixtures

import models.FPLDataModel
import play.api.libs.json.{Reads, _}

case class Fixtures(fixtures: Seq[Fixture])
                   (implicit val fplDataModel: FPLDataModel) {

  //TODO handle double gameweeks
  def findOpponent(team: String, gameweek: Int): (Int, Boolean) = {
    val id: Int = fplDataModel.idFromTeam(team)
    val gameweekFixture = teamFixtures(team).filter(_.gameweek.contains(gameweek)).head
    gameweekFixture.homeTeamId match {
      case id => (gameweekFixture.awayTeamId, true)
      case _ => (gameweekFixture.homeTeamId, false)
    }
  }

  def gameweekFixtures(gameweek: Int): Seq[Fixture] = {
    fixtures.filter(_.gameweek.contains(gameweek))
  }

  def teamFixtures(team: String): Seq[Fixture] = {
    fixtures.filter(fixture =>
      fixture.homeTeamId == fplDataModel.idFromTeam(team: String) || fixture.awayTeamId == fplDataModel.idFromTeam(team)
    )
  }

  def upcomingFixtures(team: String, startGameweek: Int, endGameweek: Int): Seq[Fixture] = {
    teamFixtures(team).filter(fixture =>
      (startGameweek to endGameweek).contains(fixture.gameweek.getOrElse(0))
    )
  }
}

//object Fixtures {
//  implicit val reads: Reads[Fixtures] = Json.reads[Fixtures]
//}

