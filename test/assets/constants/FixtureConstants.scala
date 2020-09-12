package assets.constants

import java.time.Instant

import models.fixtures.Fixture
import play.api.libs.json.Json

object FixtureConstants {

  val exampleFixture = Fixture(
    gameweek = Some(1),
    kickOffTime = Some(Instant.parse("2020-09-12T14:00:00Z")),
    minutes = 50,
    started = Some(true),
    finished = false,
    homeTeamId = 6,
    awayTeamId = 16,
    homeScore = Some(0),
    awayScore = Some(2),
    homeDifficulty = 3,
    awayDifficulty = 2
  )

  val jsonResponse = Json.obj(
    "code" -> 2128287,
    "event" -> 1,
    "finished" -> false,
    "finished_provisional" -> false,
    "id" -> 1,
    "kickoff_time" -> "2020-09-12T14:00:00Z",
    "minutes" -> 50,
    "provisional_start_time" -> false,
    "started" -> true,
    "team_a" -> 16,
    "team_a_score" -> 2,
    "team_h" -> 6,
    "team_h_score" -> 0,
    "team_h_difficulty" -> 3,
    "team_a_difficulty" -> 2
  )
}
