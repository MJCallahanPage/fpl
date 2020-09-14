package models.fixtures

import models.FPLDataModel
import models.team.Club.Club

case class Fixtures(fixtures: Seq[Fixture])
                   (implicit val fplDataModel: FPLDataModel) {

  //TODO handle double gameweeks
  def findOpponent(team: Club, gameweek: Int): (Int, Boolean) = {
    val id: Int = fplDataModel.idFromTeam(team.toString)
    val gameweekFixture = teamFixtures(team).filter(_.gameweek.contains(gameweek)).head
    gameweekFixture.homeTeamId match {
      case id => (gameweekFixture.awayTeamId, true)
      case _ => (gameweekFixture.homeTeamId, false)
    }
  }

  def gameweekFixtures(gameweek: Int): Seq[Fixture] = {
    fixtures.filter(_.gameweek.contains(gameweek))
  }

  def teamFixtures(team: Club): Seq[Fixture] = {
    fixtures.filter(fixture =>
      fixture.homeTeamId == fplDataModel.idFromTeam(team.toString: String) || fixture.awayTeamId == fplDataModel.idFromTeam(team.toString)
    )
  }

  def upcomingFixtures(team: Club, startGameweek: Int, endGameweek: Int): Seq[Fixture] = {
    teamFixtures(team).filter(fixture =>
      (startGameweek to endGameweek).contains(fixture.gameweek.getOrElse(0))
    )
  }
}

//object Fixtures {
//  implicit val reads: Reads[Fixtures] = Json.reads[Fixtures]
//}

