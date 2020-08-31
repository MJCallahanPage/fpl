package models

import assets.constants.TeamsJsonConstants
import base.SpecBase

class FPLDataModelSpec extends SpecBase{

  "teamsWithStandardisedRatings" when {

    "should return a seq of team containing with standardised ratings" in {

      val dataModel = FPLDataModel(
        players = Seq(),
        teams = TeamsJsonConstants.teams
      )

      println("Ratings:")
      println(dataModel.teams.map(_.rating))
      println("")
      println("")
      println("Standardised Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating))
      println("")
      println("")
      println("Overall Home Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.overallHome))
      println("")
      println("")
      println("Overall Away Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.overallAway))
      println("")
      println("")
      println("attackHome Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.attackHome))
      println("")
      println("")
      println("attackAway Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.attackAway))
      println("")
      println("")
      println("defenceHome Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.defenceHome))
      println("")
      println("")
      println("defenceAway Ratings:")
      println(dataModel.teamsWithStandardisedRatings.map(_.rating.defenceAway))
      println("")
      println("")
      println(dataModel.teamsWithStandardisedRatings.filter(_.name == "Liverpool").map(_.rating))
      println(dataModel.teamsWithStandardisedRatings.filter(_.name == "Man City").map(_.rating))
      println(dataModel.teamsWithStandardisedRatings.filter(_.name == "West Brom").map(_.rating))

    }
  }

}
