package assets.constants

import models.team.{Performance, Ratings, Team}
import play.api.libs.json.Json

object TeamConstants {

  val examplePerformance: Performance = Performance (
    position = 1,
    played = 38,
    win = 28,
    draw = 8,
    loss = 2,
    points = 92,
    form = Some("WDWLW")
  )

  val exampleRating: Ratings = Ratings(
    strength = 4,
    overallHome = 1200,
    overallAway = 1260,
    attackHome = 1140,
    attackAway = 1270,
    defenceHome = 1240,
    defenceAway = 1250
  )

  val exampleTeam: Team = Team(
    id = 5,
    code = 8,
    name = "Chelsea",
    abbr = "CHE",
    players = Seq(),
    performance = examplePerformance,
    rating = exampleRating
  )

  val exampleJson = Json.obj(
    "code"-> 8,
    "draw"-> 8,
    "form"-> "WDWLW",
    "id"-> 5,
    "loss"-> 2,
    "name"-> "Chelsea",
    "played"-> 38,
    "points"-> 92,
    "position"-> 1,
    "short_name"-> "CHE",
    "strength"-> 4,
    "team_division"-> 1,
    "unavailable"-> false,
    "win"-> 28,
    "strength_overall_home"-> 1200,
    "strength_overall_away"-> 1260,
    "strength_attack_home"-> 1140,
    "strength_attack_away"-> 1270,
    "strength_defence_home"-> 1240,
    "strength_defence_away"-> 1250,
    "pulse_id"-> 4
  )
}
