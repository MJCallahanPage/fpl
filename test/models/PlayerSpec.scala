package models

import base.SpecBase
import assets.constants.PlayerConstants
import models.player.Player

class PlayerSpec extends SpecBase {

  "player model" must {

    "create model from json returned from api" in {

      PlayerConstants.jsonResponse.as[Player] mustBe PlayerConstants.examplePlayer

    }
  }

}
