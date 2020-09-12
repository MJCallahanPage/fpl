package controllers

import config.AppConfig
import connectors.FPLConnector
import javax.inject._
import models.FPLDataModel
import models.fixtures.Fixture
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class PlayerPointsStatsController @Inject()(val controllerComponents: MessagesControllerComponents,
                                            fplConnector: FPLConnector)(implicit appConfig: AppConfig) extends MessagesBaseController {

  def onPageLoad(): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    fplConnector.getData().map { oModel: Option[FPLDataModel] =>
      fplConnector.getFixturesData().map { oFixtures: Option[Seq[Fixture]] =>
        oFixtures.map(fixtures =>
          println(fixtures)
        )
      }

      //println(oModel.map(_.teamsWithStandardisedRatings))

      Ok(views.html.playerPointsStats(oModel))
    }
  }
}
