package models

import assets.constants.TeamConstants
import base.SpecBase
import models.team.Team

class TeamSpec extends SpecBase {

  "team model" must {

    "create model from json returned from api" in {

      TeamConstants.exampleJson.as[Team] mustBe TeamConstants.exampleTeam

    }
  }
}
