package models.fixtures

import java.time.Instant

import play.api.libs.functional.syntax._
import play.api.libs.json.{Reads, __}

case class Fixture(gameweek: Option[Int],
                   kickOffTime: Option[Instant],
                   minutes: Int,
                   started: Option[Boolean],
                   finished: Boolean,
                   homeTeamId: Int,
                   awayTeamId: Int,
                   homeScore: Option[Int],
                   awayScore: Option[Int],
                   homeDifficulty: Int,
                   awayDifficulty: Int
                  )

object Fixture {
  implicit val reads: Reads[Fixture] = (
    (__ \ "event").readNullable[Int] and
      (__ \ "kickoff_time").readNullable[Instant] and
      (__ \ "minutes").read[Int] and
      (__ \ "started").readNullable[Boolean] and
      (__ \ "finished").read[Boolean] and
      (__ \ "team_h").read[Int] and
      (__ \ "team_a").read[Int] and
      (__ \ "team_h_score").readNullable[Int] and
      (__ \ "team_a_score").readNullable[Int] and
      (__ \ "team_h_difficulty").read[Int] and
      (__ \ "team_a_difficulty").read[Int]
    ) (Fixture.apply _)
}
