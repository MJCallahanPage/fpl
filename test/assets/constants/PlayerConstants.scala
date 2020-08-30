package assets.constants

import java.time.Instant

import models.player.{FplStats, Player, Stats, Status, Transfers}
import play.api.libs.json.Json

object PlayerConstants {
  
  val exampleStats: Stats = Stats(
    minutes= 1717,
    goals= 9,
    assists= 8,
    yellows= 0,
    reds= 0,
    ownGoals= 0,
    penaltiesMissed= 0,
    conceded= 28,
    cleanSheets= 6,
    saves= 0,
    penaltiesSaved= 0
  )
  
  val exampleFplStats = FplStats(
    points= 127,
    gameweekPoints= 0,
    form= 0.0,
    expectedPoints= Some(3.0),
    expectedPointsNext= 1.9,
    bonus= 8,
    bps= 379,
    influence= 556.2,
    creativity= 426.0,
    threat= 1059.0,
    ictIndex= 204.2,
    dreamteam= false,
    dreamteamCount= 0,
    valueChangeGW= 0,
    valueChange= 0
  )
  
  val exampleStatus = Status(
    status= "d",
    statusInfo= "Hamstring injury - 50% chance of playing",
    statusInfoTimeStamp= Some("2020-08-15T10->00->11.562980Z"),
    chancePlaying= Some(50),
    chancePlayingNext= Some(50)
  )
  
  val exampleTransfer = Transfers(
    transfersInGW= 0,
    transfersOutGW= 0,
    transfersIn= 0,
    transfersOut= 0,
    selectedBy= 5.8
  )
  
  val examplePlayer: Player = Player(
    firstName = "Christian",
    lastName= "Pulisic",
    shirtName = "Pulisic",
    image = "176413.jpg",
    teamID = 5,
    positionId= 3,
    value= 85,
    stats= exampleStats,
    fplStats= exampleFplStats,
    status= exampleStatus,
    transfers= exampleTransfer
  )

  val jsonResponse = Json.obj(
    "chance_of_playing_next_round"-> 50,
    "chance_of_playing_this_round"-> 50,
    "code"-> 176413,
    "cost_change_event"-> 0,
    "cost_change_event_fall"-> 0,
    "cost_change_start"-> 0,
    "cost_change_start_fall"-> 0,
    "dreamteam_count"-> 0,
    "element_type"-> 3,
    "ep_next"-> "1.9",
    "ep_this"-> "3.0",
    "event_points"-> 0,
    "first_name"-> "Christian",
    "form"-> "0.0",
    "id"-> 119,
    "in_dreamteam"-> false,
    "news"-> "Hamstring injury - 50% chance of playing",
    "news_added"-> "2020-08-15T10->00->11.562980Z",
    "now_cost"-> 85,
    "photo"-> "176413.jpg",
    "points_per_game"-> "5.1",
    "second_name"-> "Pulisic",
    "selected_by_percent"-> "5.8",
    "special"-> false,
    "squad_number"-> 10,
    "status"-> "d",
    "team"-> 5,
    "team_code"-> 8,
    "total_points"-> 127,
    "transfers_in"-> 0,
    "transfers_in_event"-> 0,
    "transfers_out"-> 0,
    "transfers_out_event"-> 0,
    "value_form"-> "0.0",
    "value_season"-> "14.9",
    "web_name"-> "Pulisic",
    "minutes"-> 1717,
    "goals_scored"-> 9,
    "assists"-> 8,
    "clean_sheets"-> 6,
    "goals_conceded"-> 28,
    "own_goals"-> 0,
    "penalties_saved"-> 0,
    "penalties_missed"-> 0,
    "yellow_cards"-> 0,
    "red_cards"-> 0,
    "saves"-> 0,
    "bonus"-> 8,
    "bps"-> 379,
    "influence"-> "556.2",
    "creativity"-> "426.0",
    "threat"-> "1059.0",
    "ict_index"-> "204.2",
    "influence_rank"-> 90,
    "influence_rank_type"-> 29,
    "creativity_rank"-> 79,
    "creativity_rank_type"-> 56,
    "threat_rank"-> 24,
    "threat_rank_type"-> 10,
    "ict_index_rank"-> 34,
    "ict_index_rank_type"-> 18
  )

}
