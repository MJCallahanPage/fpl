package models

import assets.constants.FixtureConstants
import base.SpecBase
import models.fixtures.Fixture

class FixtureSpec extends SpecBase {

  "team model" must {

    "create model from json returned from api" in {

      FixtureConstants.jsonResponse.as[Fixture] mustBe FixtureConstants.exampleFixture

    }
  }
}
